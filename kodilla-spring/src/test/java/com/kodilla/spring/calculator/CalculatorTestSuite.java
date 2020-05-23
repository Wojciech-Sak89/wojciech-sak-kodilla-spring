package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        int a = 9;
        int b = 3;
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double adding = calculator.add(a, b);
        double subtracting = calculator.sub(a, b);
        double multiplying = calculator.mul(a, b);
        double dividing = calculator.div(a, b);
        //Then
        Assert.assertEquals(12, adding, 0.0001);
        Assert.assertEquals(6, subtracting, 0.0001);
        Assert.assertEquals(27, multiplying, 0.0001);
        Assert.assertEquals(3, dividing, 0.0001);
    }

}
