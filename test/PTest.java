import com.company.P1;
import com.company.P2;
import com.company.P3;
import com.company.P4;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PTest {

    @Test
    public void P1() {
        assertEquals("233168", new P1().run());
    }

    @Test
    public void P2() {
        assertEquals("4613732", new P2().run());
    }

    @Test
    public void testP003() {
        assertEquals("6857",  String.valueOf(P3.getMaxPrimeFactorOf(600851475143L)));
    }

    @Test public void testP004() { assertEquals("906609", new P4().run()); }
}
