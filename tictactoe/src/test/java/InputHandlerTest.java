import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kuan96.InputHandler;
import com.kuan96.playerData;

class InputHandlerTest {
    
    private InputHandler inputHandler;
    private playerData playerData;
    
    @BeforeEach
    void setUp() {
        playerData = new playerData();
        inputHandler = new InputHandler(playerData);
    }
    
    @Test
    void testPlayerDataInitialState() {
        // 測試初始狀態
        assertNull(playerData.get_ID());
    }
    
    @Test
    void testPlayerDataAfterInsertion() {
        // 測試插入ID後的狀態
        String testId = "testUser123";
        playerData.insert_ID(testId);
        assertEquals(testId, playerData.get_ID());
    }
    
    @Test
    void testPlayerDataOverwrite() {
        // 測試覆寫ID
        String firstId = "firstId";
        String secondId = "secondId";
        
        playerData.insert_ID(firstId);
        assertEquals(firstId, playerData.get_ID());
        
        playerData.insert_ID(secondId);
        assertEquals(secondId, playerData.get_ID());
    }
}