import com.company.P1;
import com.company.P2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class PTest {

    @Test public void P1() {
        assertEquals("233168" , new P1().run());
    }
    @Test public void P2() {
        assertEquals("4613732" , new P2().run());
    }
}
