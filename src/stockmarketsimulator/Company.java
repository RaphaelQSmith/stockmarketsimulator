package stockmarketsimulator;

public class Company implements CompanyObserverInterface {

	private int companyID;
	private int shares;
	private double sharePrice;
	private int soldShares;
	
	public Company(int companyID, int shares, double sharePrice) {
		this.companyID = companyID;
		this.shares = shares;
		this.sharePrice = sharePrice;
	}
	@Override
	public void update() {
		//checks if company sold 10 stock and then doubles price
		if(soldShares % 10 == 0 || soldShares != 0) {
			doublePrice();			 	
		}
	}
	// subtracts 1 from total numbers of shares available
	@Override
	public void updateShareNumber() {
		this.shares--;
	}
	// doubles stock price
	@Override
	public void doublePrice() {
		this.sharePrice = sharePrice * 2;
	}
	// decrease stock price by 2%
	@Override
	public void shareDiscount() {
		this.sharePrice = sharePrice * 1.02;
	}
	// updates number of sold shares
	@Override
	public void updateSoldShares() {
		 this.soldShares++;
	}
	
	// getters
	public int getSoldShares() {
		return soldShares;
	}
	
	public int getCompanyID() {
		return companyID;
	}

	public int getShares() {
		return shares;
	}

	public double getSharePrice() {
		return sharePrice;
	}
	
}
