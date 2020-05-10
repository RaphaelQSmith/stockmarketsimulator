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
	
	public void updateShareNumber(int shares) {
		this.shares = shares;
	}
	public void updateSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
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
