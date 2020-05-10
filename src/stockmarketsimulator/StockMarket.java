package stockmarketsimulator;

import java.util.Random;
import java.util.*;  

public class StockMarket {
	
	private Map<Integer, Double> stocks = new HashMap<>();
	private List<Company> companyList = new ArrayList<>();
	private List<Investor> investorList = new ArrayList<>();
	
	private int totalSales;
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
		}
	}
	
	public void updateMarket(List<Company> comp, List<Investor> inv) {
		for(Investor investor : inv) {
			if(totalSales % 10 == 0) {
				for(Company c : comp) {
					if(c.getSoldShares()==0) {
						c.shareDiscount();
					}
				}
			}
			investor.buyStock(comp);
		}
	}
		
	public int getTotalShares() {
		return totalSales;
	}
	public void setTotalShares(int totalShares) {
		this.totalSales = totalShares;
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
	public Investor getRicher() {
		return richer;
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
