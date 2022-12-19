package study;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {

    @Test
    void size() {
        Set<Integer> set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);

        assertEquals(3, set.size());
    }

    @Test
    void contains() {
        Set<Integer> set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);

        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertTrue(set.contains(3));
        assertFalse(set.contains(4));
    }

    @Test
    void contains2() {
        Set<Integer> set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);

        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertTrue(set.contains(3));
        assertFalse(set.contains(4));
        assertFalse(set.contains(5));
    }
}
