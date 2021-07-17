package io.github.rotsayman.calculate;

import io.github.rotsayman.exceptions.InputExpressionException;
import io.github.rotsayman.interfaces.Calculateble;

public class ArabicCalculateImpl implements Calculateble{

    private final int number1;
    private final int number2;

    public ArabicCalculateImpl(String[] input) throws InputExpressionException {
        if(input.length > 3){
            throw new InputExpressionException();
        }
        this.number1 = Integer.parseInt(input[0]);
        this.number2 = Integer.parseInt(input[2]);
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
        if(number2 == 0){
            throw new ArithmeticException("Деление на ноль!");
        }
        return number1 / number2;
    }
}
