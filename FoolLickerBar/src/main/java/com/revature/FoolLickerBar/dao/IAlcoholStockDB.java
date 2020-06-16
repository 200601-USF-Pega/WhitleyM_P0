package com.revature.FoolLickerBar.dao;

import java.util.List;

import com.revature.FoolLickerBar.models.Stock;

public interface IAlcoholStockDB {
	public List<Stock> getAllItems();
	public List<Stock> getSomeItems(String type);
}
