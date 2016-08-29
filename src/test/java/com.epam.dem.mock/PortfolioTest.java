package com.epam.dem.mock;

import com.epam.dem.mock.object.Portfolio;
import com.epam.dem.mock.object.Stock;
import com.epam.dem.mock.services.StockService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PortfolioTest {
    Portfolio portfolio;
    StockService stockService;

    @Before
    public void beforeTest(){
        portfolio = new Portfolio();
        stockService = Mockito.mock(StockService.class);
        portfolio.setStockService(stockService);
    }

    @Test
    public void portfolioTest(){
        List<Stock> stocks = new ArrayList<>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock microsoftStock = new Stock("2", "Microsoft", 9);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        portfolio.setStocks(stocks);

        Mockito.when(stockService.getPrice(googleStock)).thenReturn(50.00);
        Mockito.when(stockService.getPrice(microsoftStock)).thenReturn(45.00);

        double marketValue = portfolio.getMarketValue();
        Assert.assertTrue("Value do not match", marketValue == 905.00);

        Mockito.when(stockService.returnTwo(googleStock)).thenReturn(2.00);

        System.out.println(stockService.returnTwo(googleStock));
    }
}
