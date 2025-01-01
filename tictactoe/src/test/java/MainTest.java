import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.kuan96.Main;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        // 重定向 System.out 到我們的測試 stream
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testMainMethod() {
        // 執行 main 方法
        Main.main(new String[]{});
        
        // 驗證輸出是否為 "Hello world!"
        assertEquals("Hello world!" + System.lineSeparator(), outContent.toString());
    }

    @After
    public void restoreStreams() {
        // 恢復原始的 System.out
        System.setOut(originalOut);
    }
}