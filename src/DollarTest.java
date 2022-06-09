import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DollarTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        assertEquals(10, five.times(2));
        assertEquals(15, five.times(3));
    }

    @Test
    public void testEquality(){
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
    }


}