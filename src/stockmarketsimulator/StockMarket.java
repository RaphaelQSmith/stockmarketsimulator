package stockmarketsimulator;

import java.util.Random;
import java.util.*;  

public class StockMarket {
	
	private Map<Integer, Double> stocks = new HashMap<>();
	private List<Company> companyList = new ArrayList<>();
	private List<Investor> investorList = new ArrayList<>();
	
	private int totalShares;
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
	
	public int getTotalShares() {
		return totalShares;
	}
	public void setTotalShares(int totalShares) {
		this.totalShares = totalShares;
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
