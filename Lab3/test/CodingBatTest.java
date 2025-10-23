import org.junit.Test;

import static org.junit.Assert.*;

public class CodingBatTest {
    CodingBat cb = new CodingBat();
    @Test
    public void close10() {
        assertEquals(8, cb.close10(8,13));
        assertEquals(8, cb.close10(13,8));
        assertEquals(0, cb.close10(13,7));
        assertEquals(0, cb.close10(7,13));
        assertEquals(9, cb.close10(9,13));
        assertEquals(0, cb.close10(0,20));
    }

    @Test
    public void factorial() {
        assertEquals(6, cb.factorial(3));
        assertEquals(2, cb.factorial(2));
        assertEquals(6, cb.factorial(3));
        assertEquals(24, cb.factorial(4));
        assertEquals(120, cb.factorial(5));
        assertEquals(479001600, cb.factorial(12));


    }

    @Test
    public void scoresIncreasing() {
        assertEquals(true, cb.scoresIncreasing(new int[]{1,3,2}));
        assertEquals(false, cb.scoresIncreasing(new int[]{1,3,2}));
        assertEquals(true, cb.scoresIncreasing(new int[]{1,1,4}));
        assertEquals(true, cb.scoresIncreasing(new int[]{1,1,2,4,3,7}));
        assertEquals(true, cb.scoresIncreasing(new int[]{1,1,2,4,3,7}));
        assertEquals(true, cb.scoresIncreasing(new int[]{-5,4,11}));

    }

    @Test
    public void luckySum() {
        assertEquals(6, cb.luckySum(1,2,3));
        assertEquals(3, cb.luckySum(1,2,13));
        assertEquals(14, cb.luckySum(13,12,3));
        assertEquals(8, cb.luckySum(8,13,2));

    }
}
