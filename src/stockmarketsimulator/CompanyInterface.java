package stockmarketsimulator;

public interface CompanyInterface {

	void update();

	// subtracts 1 from total numbers of shares available
	void updateShareNumber();

	// doubles stock price
	void doublePrice();

	// decrease stock price by 2%
	void shareDiscount();

	// updates number of sold shares
	void updateSoldShares();

}