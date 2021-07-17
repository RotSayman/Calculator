package io.github.rotsayman.convertor;

import io.github.rotsayman.enums.Number;
import io.github.rotsayman.exceptions.InputExpressionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanArabicConverterTest {

    @Test
    void romanToArabic() {
        final String roman2018 = "MMXVIII";
        final int result = RomanArabicConverter.romanToArabic(roman2018);
        assertEquals(result, 2018);
    }

    @Test
    void arabicToRoman() {
        final int arabic1999 = 1999;

        final String result = RomanArabicConverter.arabicToRoman(arabic1999);
        assertEquals(result, "MCMXCIX");
    }

    @Test
    void numberGetTest1() throws InputExpressionException {
        Number number = RomanArabicConverter.getNumber("VI");
        assertEquals(number, Number.ROMAN);
    }

    @Test
    void numberGetTest2() throws InputExpressionException {
        Number number = RomanArabicConverter.getNumber("12");
        assertEquals(number, Number.ARABIC);
    }

    @Test
    void numberGetTest3(){
        assertThrows(InputExpressionException.class,() -> RomanArabicConverter.getNumber("Hello"));
    }

    @Test
    void numberGetTest4(){
        assertThrows(InputExpressionException.class,() -> RomanArabicConverter.getNumber("124"));
    }
}