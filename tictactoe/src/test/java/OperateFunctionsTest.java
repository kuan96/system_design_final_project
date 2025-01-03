import javax.swing.JButton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kuan96.OperateFunctions;

class OperateFunctionsTest {
    private OperateFunctions operateFunctions;
    private JButton[] buttons;
    
    @BeforeEach
    void setUp() {
        operateFunctions = new OperateFunctions();
        buttons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");
        }
    }
    
    @Test
    void testCheckWin_HorizontalFirstRow() {
        // 測試第一行橫向獲勝
        buttons[0].setText("X");
        buttons[1].setText("X");
        buttons[2].setText("X");
        
        assertTrue(operateFunctions.check_win(buttons, "X"));
    }
    
    @Test
    void testCheckWin_HorizontalSecondRow() {
        // 測試第二行橫向獲勝
        buttons[3].setText("O");
        buttons[4].setText("O");
        buttons[5].setText("O");
        
        assertTrue(operateFunctions.check_win(buttons, "O"));
    }
    
    @Test
    void testCheckWin_HorizontalThirdRow() {
        // 測試第三行橫向獲勝
        buttons[6].setText("X");
        buttons[7].setText("X");
        buttons[8].setText("X");
        
        assertTrue(operateFunctions.check_win(buttons, "X"));
    }
    
    @Test
    void testCheckWin_VerticalFirstColumn() {
        // 測試第一列縱向獲勝
        buttons[0].setText("O");
        buttons[3].setText("O");
        buttons[6].setText("O");
        
        assertTrue(operateFunctions.check_win(buttons, "O"));
    }
    
    @Test
    void testCheckWin_VerticalSecondColumn() {
        // 測試第二列縱向獲勝
        buttons[1].setText("X");
        buttons[4].setText("X");
        buttons[7].setText("X");
        
        assertTrue(operateFunctions.check_win(buttons, "X"));
    }
    
    @Test
    void testCheckWin_VerticalThirdColumn() {
        // 測試第三列縱向獲勝
        buttons[2].setText("O");
        buttons[5].setText("O");
        buttons[8].setText("O");
        
        assertTrue(operateFunctions.check_win(buttons, "O"));
    }
    
    @Test
    void testCheckWin_DiagonalTopLeftToBottomRight() {
        // 測試左上到右下斜向獲勝
        buttons[0].setText("X");
        buttons[4].setText("X");
        buttons[8].setText("X");
        
        assertTrue(operateFunctions.check_win(buttons, "X"));
    }
    
    @Test
    void testCheckWin_DiagonalTopRightToBottomLeft() {
        // 測試右上到左下斜向獲勝
        buttons[2].setText("O");
        buttons[4].setText("O");
        buttons[6].setText("O");
        
        assertTrue(operateFunctions.check_win(buttons, "O"));
    }
    
    @Test
    void testCheckTie_True() {
        // 測試平局情況
        String[] values = {"X", "O", "X", "O", "X", "O", "O", "X", "O"};
        for (int i = 0; i < 9; i++) {
            buttons[i].setText(values[i]);
        }
        
        assertTrue(operateFunctions.check_tie(buttons));
    }
    
    @Test
    void testCheckTie_False() {
        // 測試非平局情況
        buttons[0].setText("X");
        buttons[1].setText("O");
        buttons[2].setText(""); // 空格
        
        assertFalse(operateFunctions.check_tie(buttons));
    }
    
    @Test
    void testRestart() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("X");
            buttons[i].setEnabled(false);
        }
        
        operateFunctions.restart(buttons);
        
        // 驗證所有按鈕都被重置
        for (int i = 0; i < 9; i++) {
            assertEquals("", buttons[i].getText());
            assertTrue(buttons[i].isEnabled());
        }
    }
    
    @Test
    void testCompareHorizontal_AllRows() {
        // 測試所有橫行
        // 第一行
        buttons[0].setText("X");
        buttons[1].setText("X");
        buttons[2].setText("X");
        assertTrue(operateFunctions.compare_horizontal(buttons, "X"));
        
        setUp();
        
        // 第二行
        buttons[3].setText("O");
        buttons[4].setText("O");
        buttons[5].setText("O");
        assertTrue(operateFunctions.compare_horizontal(buttons, "O"));
        
        setUp();
        
        // 第三行
        buttons[6].setText("X");
        buttons[7].setText("X");
        buttons[8].setText("X");
        assertTrue(operateFunctions.compare_horizontal(buttons, "X"));
    }
    
    @Test
    void testCompareVertical_AllColumns() {
        // 測試所有縱列
        // 第一列
        buttons[0].setText("O");
        buttons[3].setText("O");
        buttons[6].setText("O");
        assertTrue(operateFunctions.compare_vertical(buttons, "O"));
        
        setUp();
        
        // 第二列
        buttons[1].setText("X");
        buttons[4].setText("X");
        buttons[7].setText("X");
        assertTrue(operateFunctions.compare_vertical(buttons, "X"));
        
        setUp();
        
        // 第三列
        buttons[2].setText("O");
        buttons[5].setText("O");
        buttons[8].setText("O");
        assertTrue(operateFunctions.compare_vertical(buttons, "O"));
    }
    
    @Test
    void testCompareSlash_BothDiagonals() {
        // 測試兩個斜線
        // 左上到右下
        buttons[0].setText("X");
        buttons[4].setText("X");
        buttons[8].setText("X");
        assertTrue(operateFunctions.compare_slash(buttons, "X"));
        
        setUp();
        
        // 右上到左下
        buttons[2].setText("O");
        buttons[4].setText("O");
        buttons[6].setText("O");
        assertTrue(operateFunctions.compare_slash(buttons, "O"));
    }
}