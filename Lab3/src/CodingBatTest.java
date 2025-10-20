import static org.junit.Assert.*;

public class CodingBatTest {

    @org.junit.Test
    public void close10() {
        CodingBat cb = new CodingBat();
        assertEquals(8, cb.close10(8,13));
        assertEquals(8, cb.close10(13,8));
        assertEquals(0, cb.close10(13,7));
        assertEquals(0, cb.close10(7,13));
        assertEquals(9, cb.close10(9,13));
        assertEquals(0, cb.close10(0,20));
    }
}