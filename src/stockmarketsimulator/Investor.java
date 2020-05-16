package stockmarketsimulator;

import java.util.List;

public class Investor implements InvestorObserverInterface {

	private int investorID;
	private double budget;
	private int shares;

	public Investor(int investorID, double budget) {
		this.investorID = investorID;
		this.budget = budget;
	}
	
	@Override
	public List<Company> buyStock(List<Company> comp) {
		//	traverse company list passed by the StockMarket class
		for(int i=0; i<comp.size();i++) {
			// checks if company has share to sell and if this investor has the budget to buy it
			if(comp.get(i).getShares() > 0 && comp.get(i).getSharePrice() <= this.budget) {
				updateBudget(comp.get(i).getSharePrice());
				//	company object method to update share number and total sold shares count
				comp.get(i).updateShareNumber();
				comp.get(i).updateSoldShares();
				//	add 1 to total number of shares hold by this investor
				this.shares++;
				//	add 1 to total transaction number, store on the StockMarket object
				StockMarket.setTotalSales();
			}
		}
		//	return updated company list
		return comp;
	}
	//	subtract price of the share from the budget, after a transaction
	@Override
	public void updateBudget(double stockPrice) {
		this.budget =this.budget -  stockPrice;
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