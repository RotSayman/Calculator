package io.github.rotsayman.calculate;

import io.github.rotsayman.convertor.RomanArabicConverter;
import io.github.rotsayman.exceptions.InputExpressionException;
import io.github.rotsayman.interfaces.Calculateble;
import org.junit.jupiter.api.BeforeAll;
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

    @Test
    void allCalc() throws InputExpressionException {
        Calculateble calc;
        String[] str;
        for (int i = 1 ;  i <= 10; i++){
            for (int j = 1; j <= 10; j++) {
                str  = new String[]{RomanArabicConverter.arabicToRoman(i)," + ", RomanArabicConverter.arabicToRoman(j)};
                calc = new RoamCalculateImpl(str);
                calc.add();
                calc.mult();
                calc.sub();
                calc.div();
            }
        }
        System.out.println("OK!");
        assertTrue(true);
    }
}