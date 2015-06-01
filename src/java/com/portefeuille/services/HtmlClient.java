package com.portefeuille.services;

import com.portefeuille.model.Company;

public interface HtmlClient {
	
	public Company getCompanyDetails(String ticker);

}
