package com.epam.dem.mock;

import static org.mockito.Mockito.*;

import com.epam.dem.mock.calculation.MathApplication;
import com.epam.dem.mock.services.CalculatorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InOrder;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {
    public MathApplication mathApplication;
    public CalculatorService calculatorService;

    @Before
    public void beforeMethod(){
        mathApplication = new MathApplication();
        calculatorService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calculatorService);
    }

    @Test
    public void mockTest(){
        when(mathApplication.add(10.0, 20.0)).thenReturn(30.0);
        when(mathApplication.subtract(10.0, 10.0)).thenReturn(0.0);

        Assert.assertTrue(mathApplication.add(10.0,20.0) == 30);
        Assert.assertTrue(mathApplication.subtract(10.0, 10.0) == 0.0);

        InOrder inOrder = inOrder(calculatorService);

        //following will make sure that add is first called then subtract is called.
        inOrder.verify(calculatorService).add(10.0,20.0);
        inOrder.verify(calculatorService).subtract(10.0,10.0);
    }
}
