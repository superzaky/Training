import org.junit.Test;
import service.Library;

import static org.junit.Assert.assertEquals;
//tested with junit 4.12
public class LibraryTest {
    @Test
    public void testSqrtLong() {
        assertEquals(0L, Library.sqrt(0L));
        assertEquals(1L, Library.sqrt(1L));
        assertEquals(1L, Library.sqrt(2L));
        assertEquals(1L, Library.sqrt(3L));
        assertEquals(2L, Library.sqrt(4L));
        assertEquals(2L, Library.sqrt(5L));
        assertEquals(2L, Library.sqrt(8L));
        assertEquals(3L, Library.sqrt(9L));
        assertEquals(3L, Library.sqrt(10L));
        assertEquals(18L, Library.sqrt(360L));
        assertEquals(19L, Library.sqrt(361L));
        assertEquals(19L, Library.sqrt(362L));
        assertEquals(256L, Library.sqrt(65536L));
        assertEquals(32768L, Library.sqrt(1073741824L));
        assertEquals(46340L, Library.sqrt(2147483648L));
        assertEquals(2645751L, Library.sqrt(7000000000000L));
        assertEquals(3037000499L, Library.sqrt(9223372036854775807L));
    }
}
