package org.modernjava.e01;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OopAndFpExamplesTest {

    @Test
    public void testCalculateAddition() throws Exception{
        Calculation calculation = new Addition();
        int calculate = calculation.calculate(10, 20);
        Assertions.assertThat(calculate).isEqualTo(30);
    }



    @Test
    public void testCalculateSubtraction() throws Exception{
        Calculation calculation = new Subtraction();
        int calculate = calculation.calculate(10, 20);
        Assertions.assertThat(calculate).isEqualTo(-10);
    }



    @Test
    public void testCalculateMultiplication() throws Exception{
        Calculation calculation = new Multiplication();
        int calculate = calculation.calculate(10, 20);
        Assertions.assertThat(calculate).isEqualTo(200);
    }



    @Test
    public void testCalculateDivision() throws Exception{
        Calculation calculation = new Division();
        int calculate = calculation.calculate(20, 10);
        Assertions.assertThat(calculate).isEqualTo(2);
    }

}