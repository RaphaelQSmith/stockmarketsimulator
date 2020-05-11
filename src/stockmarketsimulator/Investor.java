package stockmarketsimulator;

import java.util.List;

public class Investor {

	int investorID;
	double budget;
	
	public Investor(int investorID, double budget) {
		this.investorID = investorID;
		this.budget = budget;
	}
	
	public List<Company> buyStock(List<Company> comp) {
		
		for(int i=0; i<comp.size();i++) {
			if(comp.get(i).getShares() > 0 && comp.get(i).getSharePrice() <= this.budget) {
				System.out.println(investorID);
				this.budget = this.budget - comp.get(i).getSharePrice();
				comp.get(i).updateShareNumber();
				comp.get(i).updateSoldShares();
				StockMarket.setTotalSales();
			}
		}
		return comp;
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