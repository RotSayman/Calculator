package io.github.rotsayman.calculate;

import io.github.rotsayman.exceptions.InputExpressionException;
import io.github.rotsayman.interfaces.Calculateble;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoamCalculateImplTest {

    private static Calculateble calculateble;
    private static String[] operation;

    @BeforeAll
    static void init() throws InputExpressionException {
        operation = new String[]{"V","+","II"};
        calculateble = new RoamCalculateImpl(operation);
    }

    @Test
    void add() {
        assertEquals(calculateble.add(), 7);
    }

    @Test
    void sub() {
        assertEquals(calculateble.sub(), 3);
    }

    @Test
    void mult() {
        assertEquals(calculateble.mult(), 10);
    }

    @Test
    void div() {
        assertEquals(calculateble.div(), 2);
    }
}