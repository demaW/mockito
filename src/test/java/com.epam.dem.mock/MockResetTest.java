package com.epam.dem.mock;

import com.epam.dem.mock.calculation.MathApplication;
import com.epam.dem.mock.services.CalculatorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockResetTest {
    private MathApplication mathApplication;
    private CalculatorService calculatorService;

    @Before
    public void beforeMethod(){
        mathApplication = new MathApplication();
        calculatorService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calculatorService);
    }

    @Test
    public void mockResetTest(){
        when(calculatorService.add(10.0, 20.00)).thenReturn(30.00);
        Assert.assertTrue(mathApplication.add(10.0, 20.0) == 30.00);

        reset(calculatorService);
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
    }
}
