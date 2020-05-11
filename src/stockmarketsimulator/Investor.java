package stockmarketsimulator;

import java.util.List;

public class Investor {

	int investorID;
	double budget;
	int counter = 0;
	
	public Investor(int investorID, double budget) {
		this.investorID = investorID;
		this.budget = budget;
	}
	
	public void buyStock(List<Company> comp) {
		for(Company c : comp) {
			if(c.getShares() > 0 && c.getSharePrice() < budget) {
				// update company values
				this.counter++;
				System.out.println(budget);
				this.budget =- c.getSharePrice();
				c.update();
			}
		}
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