package stockmarketsimulator;

import java.util.Random;
import java.util.*;
import java.util.Map.Entry;  

public class StockMarket {
	
	private List<Company> companyList = new ArrayList<>();
	private List<Investor> investorList = new ArrayList<>();
	private static int totalSales;
	
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
			return true;
		}else {
			return false;
		}
	}
	
	
	
	public int getTotalSales() {
		return totalSales;
	}
	public static void setTotalSales() {
		totalSales++;
	}
	// get largest and smallest capital
	public void  lowestOrHighest(int a) {
		HashMap<Integer, Double> priceList = new HashMap<Integer, Double>();
		
		for(Company c: companyList) {
			priceList.put(c.getCompanyID(), (c.getSharePrice() * c.getShares()));
		}
		double maxValue = (Collections.max(priceList.values()));
		double minValue = (Collections.min(priceList.values()));
		// if input is 1 returns highest, if 2 returns lowest	
		if(a==1){
				System.out.println("Highest capital: " + maxValue);
				System.out.println("Companies with highest capital: ");
		
				for(Entry<Integer, Double> entry : priceList.entrySet()) {
				if(entry.getValue()==maxValue) {
				System.out.println("ID " + entry.getKey());
				}
			}		
		}else if(a==2) {
			System.out.println("Lowest capital: " + minValue);
			System.out.println("Companies with lowest capital: ");
			for(Entry<Integer, Double> entry : priceList.entrySet()) {
				if(entry.getValue()==minValue) {
				System.out.println("ID " + entry.getKey());
				}
			}	
		}
		
	}
	//	get richer and poorest
	public void  richestOrPoorest(int a) {
		HashMap<Integer, Integer> shareholderList = new HashMap<Integer, Integer>();
		
		for(Investor inv: investorList) {
			shareholderList.put(inv.getInvestorID(), inv.getShares());
		}
		double maxValue = (Collections.max(shareholderList.values()));
		double minValue = (Collections.min(shareholderList.values()));
		
		if(a==1) {
			System.out.println("Highest share count: " + maxValue);
			System.out.println("Investor with highest share count: ");
			for(Entry<Integer, Integer> entry : shareholderList.entrySet()) {
					if(entry.getValue()==maxValue) {
					System.out.println("ID " + entry.getKey());
					}
				}
		}else if(a==2) {
			System.out.println("Lowest share count: " + minValue);
			System.out.println("Investor with lowest share count: ");
			for(Entry<Integer, Integer> entry : shareholderList.entrySet()) {
					if(entry.getValue()==minValue) {
					System.out.println("ID " + entry.getKey());
					}
				}
		}
	}
}
