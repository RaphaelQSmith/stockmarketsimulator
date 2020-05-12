package stockmarketsimulator;

import java.util.List;

public class Investor implements InvestorInterface {

	private int investorID;
	private double budget;
	private int shares;

	public Investor(int investorID, double budget) {
		this.investorID = investorID;
		this.budget = budget;
	}
	
	@Override
	public List<Company> buyStock(List<Company> comp) {
		
		for(int i=0; i<comp.size();i++) {
			if(comp.get(i).getShares() > 0 && comp.get(i).getSharePrice() <= this.budget) {
				this.budget = this.budget - comp.get(i).getSharePrice();
				comp.get(i).updateShareNumber();
				comp.get(i).updateSoldShares();
				this.shares++;
				StockMarket.setTotalSales();
			}
		}
		return comp;
	}
	
	@Override
	public void updateBudget(double stockPrice) {
		this.budget =- stockPrice;
	}
	// getters
	public int getShares() {
		return shares;
	}

	public int getInvestorID() {
		return investorID;
	}

	public double getBudget() {
		return budget;
	}
	
}