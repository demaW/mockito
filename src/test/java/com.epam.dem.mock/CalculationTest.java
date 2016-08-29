package com.epam.dem.mock;

import static org.mockito.Mockito.*;

import com.epam.dem.mock.calculation.MathApplication;
import com.epam.dem.mock.services.CalculatorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculationTest {
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    @Mock
    CalculatorService calculatorService;

    @Test
    public void testAdd(){
        when(calculatorService.add(10.0, 20.00)).thenReturn(30.00);
        Assert.assertTrue(mathApplication.add(10, 20) == 30.00);

        verify(calculatorService).add(10.0, 20.0);

        verify(calculatorService, times(1)).add(10.0, 20.0);
        verify(calculatorService, atMost(1)).add(10.0, 20.0);

    }

    @Test(expected = RuntimeException.class)
    public void testException(){
        doThrow(new RuntimeException("dividing by zero do not allowed")).when(calculatorService).divide(20.0, 0.0);
        Assert.assertTrue(mathApplication.divide(20.0, 0.0) == 0.0);
    }
}
