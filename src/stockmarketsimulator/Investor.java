package stockmarketsimulator;

public class Investor {

	int investorID;
	double budget;
	
	public Investor(int investorID, double budget) {
		this.investorID = investorID;
		this.budget = budget;
	}
	
	public void updateBudget(double stockPrice) {
		this.budget =- stockPrice;
	}
	
	// getters
	public int getInvestorID() {
		return investorID;
	}

	public double getBudget() {
		return budget;
	}
	
}