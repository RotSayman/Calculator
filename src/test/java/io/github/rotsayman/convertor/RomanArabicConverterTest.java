package io.github.rotsayman.convertor;

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
}