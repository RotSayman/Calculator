package io.github.rotsayman.calculate;

import io.github.rotsayman.exceptions.InputExpressionException;
import io.github.rotsayman.interfaces.Calculateble;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArabicCalculateImplTest {

    private static Calculateble calculateble;
    private static String[] operation;

    @BeforeAll
    static void init() throws InputExpressionException {
        // + для формальности
        operation = new String[]{"1","+", "0"};
        calculateble = new ArabicCalculateImpl(operation);

    }

    @Test
    void add() {
        assertEquals(calculateble.add(), 1);
    }

    @Test
    void sub() {
        assertEquals(calculateble.sub(), 1);
    }

    @Test
    void mult() {
        assertEquals(calculateble.mult(), 0);
    }

    @Test
    void div() {
        assertThrows(ArithmeticException.class, () -> calculateble.div());
    }
}