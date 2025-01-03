import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kuan96.SingleMode;

class SingleModeTest {
    private SingleMode singleMode;
    
    @BeforeEach
    void setUp() {
        singleMode = new SingleMode();
    }
    
    @Test
    void testInitialState() {
        // 測試初始狀態
        assertEquals("O", singleMode.getText()[0]);
        assertEquals("X", singleMode.getText()[1]);
        assertEquals(new Color(255,215,0), singleMode.getColor()[0]);
        assertEquals(new Color(138,43,226), singleMode.getColor()[1]);
        assertEquals(0, singleMode.getTurn());
    }
    
    @Test
    void testInitialButtonState() {
        // 測試按鈕初始狀態
        JButton[] buttons = singleMode.getButtons();
        for (JButton button : buttons) {
            assertNotNull(button);
            assertEquals("", button.getText());
            assertTrue(button.isEnabled());
        }
    }
    
    @Test
    void testSingleMove() {
        // 模擬單次移動
        JButton[] buttons = singleMode.getButtons();
        ActionEvent actionEvent = new ActionEvent(buttons[0], ActionEvent.ACTION_PERFORMED, "");
        
        singleMode.actionPerformed(actionEvent);
        
        // 檢查玩家移動
        assertEquals("O", buttons[0].getText());
        
        // 檢查是否有電腦回應
        boolean computerMoved = false;
        for (int i = 1; i < 9; i++) {
            if (!buttons[i].getText().isEmpty()) {
                computerMoved = true;
                break;
            }
        }
        assertTrue(computerMoved, "Computer should make a move");
    }
    
    
    @Test
    void testInvalidMove() {
        // 先在位置0下一步棋
        JButton[] buttons = singleMode.getButtons();
        buttons[0].setText("O");
        
        // 嘗試在同一位置再次下棋
        ActionEvent actionEvent = new ActionEvent(buttons[0], ActionEvent.ACTION_PERFORMED, "");
        singleMode.actionPerformed(actionEvent);
        
        // 驗證按鈕狀態沒有改變
        assertEquals("O", buttons[0].getText());
    }
}