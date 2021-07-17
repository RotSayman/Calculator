package io.github.rotsayman.calculate;

import io.github.rotsayman.exceptions.InputExpressionException;
import io.github.rotsayman.interfaces.Calculateble;

public class ArabicCalculateImpl implements Calculateble{

    private final int number1;
    private final int number2;

    public ArabicCalculateImpl(String input) throws InputExpressionException {
        String[] s = input.split(" ");
        if(s.length > 2){
            throw new InputExpressionException();
        }
        this.number1 = Integer.parseInt(s[0]);
        this.number2 = Integer.parseInt(s[1]);
        if(number1 > 10 || number2 > 10){
            throw new InputExpressionException();
        }
    }

    @Override
    public int add() {
        return number1 + number2;
    }

    @Override
    public int sub() {
        return number1 - number2;
    }

    @Override
    public int mult() {
        return number1 * number2;
    }

    @Override
    public int div() {
        return number1 / number2;
    }
}
