package io.github.rotsayman;

import io.github.rotsayman.calculate.ArabicCalculateImpl;
import io.github.rotsayman.calculate.RoamCalculateImpl;
import io.github.rotsayman.convertor.RomanArabicConverter;
import io.github.rotsayman.enums.Number;
import io.github.rotsayman.exceptions.InputExpressionException;
import io.github.rotsayman.interfaces.Calculateble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/**
 * <h1>Задача: “Калькулятор”</h1>
 * <h2>Описание:</h2>
 * <p>Создайте консольное приложение “Калькулятор”.
 * Приложение должно читать из консоли введенные пользователем
 * арифметические операции и выводить в консоль результат их выполнения.</p>
 * <h2>Требования:</h2>
 * <ol>
 *   <li>Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами:
 *   a + b, a - b, a * b, a / b.  <b> Данные передаются в одну строку (смотрите пример)! Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными. </b></li>
 *   <li>Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.</li>
 *   <li>Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.</li>
 *   <li>Калькулятор умеет работать только с целыми числами.</li>
 *   <li>Калькулятор умеет работать только с арабскими или римскими  цифрами одновременно, при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.</li>
 *   <li>При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно, при вводе арабских - ответ ожидается арабскими.</li>
 *   <li>При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.</li>
 *   <li>При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.</li>
 * </ol>
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        // Запуск калькулятора
        go();
    }
    /** Ввод данных (число) (оператор) (число) или (римское число) (оператор) (римское число) */
    public static void go(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Для выхода введите q");
            // Ввод операции
            String number;
            do{
                number = reader.readLine();
                // Проверяем ввод на валидность
                if(number.matches("^[IVX|0-9]{1,2}\\s[+*-/]\\s[IVX|0-9]{1,2}$")){
                    String[] operations = number.split("\\s");
                    Number wNum;
                    Calculateble calc;
                    int result;
                    // Проверка римские или арабские
                    if(!RomanArabicConverter.getNumber(operations[0]).equals(RomanArabicConverter.getNumber(operations[2]))){
                        throw new InputExpressionException();
                    }
                    switch (RomanArabicConverter.getNumber(operations[0])){
                        case ROMAN:
                            calc = new RoamCalculateImpl(operations);
                            wNum = Number.ROMAN;
                            Logger.getLogger(App.class.getName()).info("ROMAN NUMBER");
                            break;
                        case ARABIC:
                            calc = new ArabicCalculateImpl(operations);
                            wNum = Number.ARABIC;
                            Logger.getLogger(RomanArabicConverter.class.getName()).info("ARAB NUMBER");
                            break;
                        default: throw new InputExpressionException();
                    }
                    // Выполнение операции
                    switch (operations[1]){
                        case "+" : result = calc.add(); break;
                        case "-" : result = calc.sub(); break;
                        case "*" : result = calc.mult(); break;
                        case  "/" : result = calc.div(); break;
                        default: throw new InputExpressionException();
                    }
                    // Ввывод результата
                    switch (wNum){
                        case ROMAN:
                            System.out.println(RomanArabicConverter.arabicToRoman(result));
                            break;
                        case ARABIC:
                            System.out.println(result);
                            break;
                        default: throw new InputExpressionException();
                    }
                }else{
                    throw new InputExpressionException();
                }

            }while(!number.equals("q"));
        }catch (IOException | InputExpressionException ioe){
            ioe.printStackTrace();
            System.err.println("Не верная операция в терминале. (Маска ввода [1 + 1])");
        }

    }

}
