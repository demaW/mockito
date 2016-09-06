package com.epam.dem.mock;

import com.epam.dem.mock.calculation.MathApplication;
import com.epam.dem.mock.services.CalculatorService;
import com.epam.dem.mock.spy.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class SpyTest {
    MathApplication mathApplication;
    CalculatorService calculatorService;

    @Before
    public void setUp(){
        mathApplication = new MathApplication();
        Calculator calculator = new Calculator();
        calculatorService = Mockito.spy(calculator);
        mathApplication.setCalculatorService(calculatorService);
    }

    @Test
    public void addTest(){
        Assert.assertTrue(mathApplication.add(30,20) == 50.0);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void subtracTest(){
        Assert.assertTrue(mathApplication.subtract(3,4) == -1);
    }
}
