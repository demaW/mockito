package com.epam.dem.mock;

import com.epam.dem.mock.calculation.MathApplication;
import com.epam.dem.mock.services.CalculatorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GenericTest {
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
        when(mathApplication.add(10.0, 20.0)).thenAnswer(new Answer<Double>()  {
            @Override
            public Double answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object [] args = invocationOnMock.getArguments();
                Object mock = invocationOnMock.getMock();

                return 30.0;
            }
        });

        Assert.assertTrue(mathApplication.add(10.0,20.0) == 30);
    }
}
