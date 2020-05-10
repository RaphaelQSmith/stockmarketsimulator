package stockmarketsimulator;

public class Company {

	private int companyID;
	private int shares;
	private double sharePrice;
	private int soldShares;
	
	public Company(int companyID, int shares, double sharePrice) {
		this.companyID = companyID;
		this.shares = shares;
		this.sharePrice = sharePrice;
	}
	
	public void update() {
		// sells one stock and adds 1 to sales count
		updateShareNumber();
		updateSoldShares();
		//checks if company sold 10 stock and then doubles price
		if(soldShares % 10 == 0) {
			doublePrice();			
		}
	}
	// subtracts 1 from total numbers of shares available
	public void updateShareNumber() {
		this.shares =- shares;
	}
	// doubles stock price
	public void doublePrice() {
		this.sharePrice = sharePrice * 2;
	}
	// decrease stock price by 2%
	public void shareDiscount() {
		this.sharePrice = sharePrice * 1.02;
	}
	// updates number of sold shares
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
