package stockmarketsimulator;

import java.util.Random;
import java.util.*;  

public class StockMarket {
	
	private List<Company> companyList = new ArrayList<>();
	private List<Investor> investorList = new ArrayList<>();
	
	private static int totalSales;
	private Company higher, lower;
	private Investor richer, poorest;
	
	public StockMarket(){
		int companyID = 1;
		int invID = 1;
		
		Random r = new Random();
		// populate an array with companies objects
		for(int i=1; i<=100; i++) {
			// generate random numbers within a range
		    int shareN = r.nextInt((1000 - 500) + 1 ) + 500;
			int sharePrice = r.nextInt((100 - 10) + 1 ) + 10;
		    
			Company c = new Company(companyID, shareN, sharePrice);
			companyList.add(c);
			companyID++;
		}
		for(int i=1; i<=100; i++) {
			int investBudget = r.nextInt((10000 - 1000) + 1 ) + 1000;
			Investor inv = new Investor(invID, investBudget);
			investorList.add(inv);
			invID++;
		}
		updateMarket();
	}
	
	public void updateMarket() {
		// if company didn't sell any stock in a 10-sale cycle price will drop 2%
		while(keepGoing() == true){
			for(int i=0; i<investorList.size();i++) {
				if(totalSales % 10 == 0 && totalSales !=0) {
					for(int j=0; j<companyList.size();j++) {
						if(companyList.get(j).getSoldShares()==0) {
							companyList.get(j).shareDiscount();
						}
					}
				}
				companyList = investorList.get(i).buyStock(companyList);
			}
		};
	}

	public boolean keepGoing() {
		List<Double> sorted = new ArrayList<>();		
		for(int i = 0; i<investorList.size();i++) {
			sorted.add(investorList.get(i).getBudget());
		}
		double max = Collections.max(sorted);

		List<Double> sortedPrice = new ArrayList<>();
		
		for(int j = 0; j<companyList.size(); j++) {
			if(companyList.get(j).getShares() > 0) {
			sortedPrice.add(companyList.get(j).getSharePrice());
			}
		}
		double min = Collections.min(sortedPrice);
		
		if(min <= max) {
			System.out.println("TRUE TRUE TRUE TRUE");
			return true;
		}else {
			System.out.println("FALSE FALSE FALSE FALSE");
			return false;
		}
	}
	
	
	
	public int getTotalSales() {
		return totalSales;
	}
	public static void setTotalSales() {
		totalSales++;
	}
	public Company getHigher() {
		return higher;
	}
	public void setHigher(Company higher) {
		this.higher = higher;
	}
	public Company getLower() {
		return lower;
	}
	public void setLower(Company lower) {
		this.lower = lower;
	}
	
	public void setRicher(Investor richer) {
		this.richer = richer;
	}
	public Investor getPoorest() {
		return poorest;
	}
	public void setPoorest(Investor poorest) {
		this.poorest = poorest;
	}
	
	
}
