package org.modernjava.e01;

/**
 * 객체지향을 적용한 Calculator Application
 * ㅁ 코드가 변경에 용의하고 테스트코드 작성할때 편리하다.
 *
 * First-Class Citizen
 * 조건1.Element를 메소드 인자로 넘겨줄 수 있다.
 * ex) Element el = new ~
 * callMethod(Element el)
 *
 * 조건2.메소드 결과값으로 Element를 받을 수 있다.
 * ex) Element result =
 * callMethod(Element el)
 *
 * 조건3.DataStructure 안에 Element를 저장할 수 있어야한다.
 * ex) List<Element> list = Arrays.asList(el,result);
 *
 * 자바에서는 Object가 First-Class Citizen인데 java8부터 Method도 First-Class Method를 지원함
 * @author VitaminDraogn
 * @since 2023-07-17
 */
public class OopAndFpExamples {

    public static void main(final String[] args) {
        final CalculatorService calculatorService =
                new CalculatorService(new Addition(), new Subtraction(), new Multiplication(), new Division());

        final int additionResult = calculatorService.add(11, 4);
        System.out.println(additionResult);

        final int subtractionResult = calculatorService.subtract(11, 1);
        System.out.println(subtractionResult);

        final int multiplicationResult = calculatorService.multiply(11, 2);
        System.out.println(multiplicationResult);

        final int divisionResult = calculatorService.divide(20, 4);
        System.out.println(divisionResult);


        final FpCalculatorService fpCalculatorService = new FpCalculatorService();
        final Calculation addition = (i1, i2) -> i1 + i2;
        System.out.println("additon: " + fpCalculatorService.calculate(addition, 11, 4));
        System.out.println("subtraction: " + fpCalculatorService.calculate((i1, i2) -> i1 - i2, 11, 1));
        System.out.println("multiplication: " + fpCalculatorService.calculate((i1, i2) -> i1 * i2, 11, 2));
        System.out.println("division: " + fpCalculatorService.calculate((i1, i2) -> i1 / i2, 20, 4));
        System.out.println("custom calc: " + fpCalculatorService.calculate((i1, i2) -> ((i1 + i2) * 2) / i2, 20, 4));
        System.out.println("custom calc2: "+ fpCalculatorService.calculate((i1,i2) -> i1+i2, 20, 4));
    }
}

interface Calculation {
    int calculate(final int num1, final int num2);
}

class Addition implements Calculation {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 + num2;
    }
}

class Subtraction implements Calculation {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 - num2;
    }
}

class Multiplication implements Calculation {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 * num2;
    }
}

class Division implements Calculation {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 / num2;
    }
}

class CalculatorService {
    private final Calculation addition;
    private final Calculation subtraction;
    private final Calculation multiplication;
    private final Calculation division;

    public CalculatorService(final Calculation addition, final Calculation subtraction, final Calculation multiplication, final Calculation division) {
        this.addition = addition;
        this.subtraction = subtraction;
        this.multiplication = multiplication;
        this.division = division;
    }

    public int add(final int num1, final int num2) {
        if (num1 > 10 && num2 < num1) { // boilerplate code
            return addition.calculate(num1, num2);
        } else { // boilerplate code
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2); // boilerplate code
        } // boilerplate code
    }

    public int subtract(final int num1, final int num2) {
        if (num1 > 10 && num2 < num1) { // boilerplate code
            return subtraction.calculate(num1, num2);
        } else { // boilerplate code
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2); // boilerplate code
        } // boilerplate code
    }

    public int multiply(final int num1, final int num2) {
        if (num1 > 10 && num2 < num1) { // boilerplate code
            return multiplication.calculate(num1, num2);
        } else { // boilerplate code
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2); // boilerplate code
        } // boilerplate code
    }

    public int divide(final int num1, final int num2) {
        if (num1 > 10 && num2 < num1) { // boilerplate code
            return division.calculate(num1, num2);
        } else { // boilerplate code
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2); // boilerplate code
        } // boilerplate code
    }
}

class FpCalculatorService {
    public int calculate(final Calculation calculation, final int num1, final int num2) {
        if (num1 > 10 && num2 < num1) {
            return calculation.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);
        }
    }

}