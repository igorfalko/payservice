package gpb;

import org.junit.Test;

import static gpb.utils.SomeUtils.getPortFromArgs;
import static gpb.utils.SomeUtils.isCorrectPortNumber;
import static org.junit.Assert.*;

public class SomeUtilsTests {
    @Test
    public void testIsNumeric() {
        assertFalse(isCorrectPortNumber(null));
        assertFalse(isCorrectPortNumber(""));
        assertFalse(isCorrectPortNumber("5.05"));
        assertFalse(isCorrectPortNumber("-200"));
        assertFalse(isCorrectPortNumber("abc"));

        assertTrue(isCorrectPortNumber("0"));
        assertTrue(isCorrectPortNumber("1"));
        assertTrue(isCorrectPortNumber("12"));
        assertTrue(isCorrectPortNumber("123"));
        assertTrue(isCorrectPortNumber("1234"));
        assertTrue(isCorrectPortNumber("12345"));
        assertTrue(isCorrectPortNumber("65535"));

        assertFalse(isCorrectPortNumber("65536"));
        assertFalse(isCorrectPortNumber("123456"));
    }

    @Test
    public void testGetPort() {
        assertEquals(getPortFromArgs(new String[]{}), "8080");
        assertEquals(getPortFromArgs(new String[]{"123"}), "123");
        assertEquals(getPortFromArgs(new String[]{"abc"}), "8080");
        assertEquals(getPortFromArgs(new String[]{"65535"}), "65535");
        assertEquals(getPortFromArgs(new String[]{"65536"}), "8080");
    }
}
