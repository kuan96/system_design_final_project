import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kuan96.TwoPlayerMode;

class TwoPlayerModeTest {
    private TwoPlayerMode twoPlayerMode;
    
    @BeforeEach
    void setUp() {
        twoPlayerMode = new TwoPlayerMode();
    }
    
    @Test
    void testPlayerAlternation() {
        // 取得按鈕
        JButton[] buttons = twoPlayerMode.getButtons();
        
        // 第一位玩家下棋（位置0）
        ActionEvent firstMove = new ActionEvent(buttons[0], ActionEvent.ACTION_PERFORMED, "");
        twoPlayerMode.actionPerformed(firstMove);
        assertEquals("O", buttons[0].getText());
        assertEquals(new Color(255,215,0), buttons[0].getForeground());
        
        // 第二位玩家下棋（位置1）
        ActionEvent secondMove = new ActionEvent(buttons[1], ActionEvent.ACTION_PERFORMED, "");
        twoPlayerMode.actionPerformed(secondMove);
        assertEquals("X", buttons[1].getText());
        assertEquals(new Color(138,43,226), buttons[1].getForeground());
        
        // 第一位玩家再次下棋（位置2）
        ActionEvent thirdMove = new ActionEvent(buttons[2], ActionEvent.ACTION_PERFORMED, "");
        twoPlayerMode.actionPerformed(thirdMove);
        assertEquals("O", buttons[2].getText());
        assertEquals(new Color(255,215,0), buttons[2].getForeground());
    }
    
    @Test
    void testInvalidMove() {
        // 取得按鈕
        JButton[] buttons = twoPlayerMode.getButtons();
        
        // 第一位玩家下棋
        ActionEvent firstMove = new ActionEvent(buttons[0], ActionEvent.ACTION_PERFORMED, "");
        twoPlayerMode.actionPerformed(firstMove);
        
        // 嘗試在同一位置下棋
        twoPlayerMode.actionPerformed(firstMove);
        
        // 驗證按鈕狀態沒有改變，仍然是第一位玩家的符號
        assertEquals("O", buttons[0].getText());
        assertEquals(new Color(255,215,0), buttons[0].getForeground());
    }
    
    @Test
    void testWinningMove() {
        JButton[] buttons = twoPlayerMode.getButtons();
        
        // 設置即將獲勝的局面（玩家1）
        buttons[0].setText("O");
        buttons[1].setText("O");
        
        // 執行獲勝移動
        ActionEvent winningMove = new ActionEvent(buttons[2], ActionEvent.ACTION_PERFORMED, "");
        twoPlayerMode.actionPerformed(winningMove);
        
        // 驗證所有按鈕都被禁用
        for (JButton button : buttons) {
            assertFalse(button.isEnabled());
        }
    }
    
    @Test
    void testTieGame() {
        JButton[] buttons = twoPlayerMode.getButtons();
        
        // 設置即將平局的局面
        String[] moves = {"O", "X", "O", "X", "O", "X", "X", "O"};
        for (int i = 0; i < 8; i++) {
            buttons[i].setText(moves[i]);
        }
        
        // 執行最後一步移動
        ActionEvent finalMove = new ActionEvent(buttons[8], ActionEvent.ACTION_PERFORMED, "");
        twoPlayerMode.actionPerformed(finalMove);
        
        // 驗證所有按鈕都被禁用
        for (JButton button : buttons) {
            assertFalse(button.isEnabled());
        }
    }
    
    @Test
    void testCorrectTurnOrder() {
        JButton[] buttons = twoPlayerMode.getButtons();
        
        // 執行多個移動並驗證回合順序
        for (int i = 0; i < 4; i++) {
            ActionEvent move = new ActionEvent(buttons[i], ActionEvent.ACTION_PERFORMED, "");
            twoPlayerMode.actionPerformed(move);
            
            // 驗證正確的符號被放置
            assertEquals((i % 2 == 0) ? "O" : "X", buttons[i].getText());
            
            // 驗證正確的顏色被使用
            Color expectedColor = (i % 2 == 0) ? new Color(255,215,0) : new Color(138,43,226);
            assertEquals(expectedColor, buttons[i].getForeground());
        }
    }
}