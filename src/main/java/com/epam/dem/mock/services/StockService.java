package com.epam.dem.mock.services;

import com.epam.dem.mock.object.Stock;

public interface StockService {
    double getPrice(Stock stock);
    double returnTwo(Stock stock);
}
