package stockmarketsimulator;

import java.util.*;
import java.util.Map.Entry;  

public class StockMarket {
	//	create two instance of List class where companies and investors objects will be store 
	private List<Company> companyList = new ArrayList<>();
	private List<Investor> investorList = new ArrayList<>();
	//	store total trades of the day
	private static int totalSales;
	
	public StockMarket(){
		int companyID = 1;
		int invID = 1;
		//	instantiate random number class 
		Random r = new Random();
		// populate an array with companies objects and generate random number of shares and share price
		for(int i=1; i<=100; i++) {
			// generate random numbers within a range
		    int shareN = r.nextInt((1000 - 500) + 1 ) + 500;
			int sharePrice = r.nextInt((100 - 10) + 1 ) + 10;
		    //  create company object
			Company c = new Company(companyID, shareN, sharePrice);
			//	add company to correspondent list
			companyList.add(c);
			companyID++;
		}
		//	populate an array with investor objects with a random budget
		for(int i=1; i<=100; i++) {
			int investBudget = r.nextInt((10000 - 1000) + 1 ) + 1000;
			Investor inv = new Investor(invID, investBudget);
			//	add investor to correspondent list
			investorList.add(inv);
			invID++;
		}
		// call simulation method
		updateMarket();
	}
	
	public void updateMarket() {
		while(keepGoing() == true){
			// traverse list of investors
			for(int i=0; i<investorList.size();i++) {
				// if company didn't sell any stock in a 10-sale cycle price will drop 2%
				if(totalSales % 10 == 0 && totalSales !=0) {
					for(int j=0; j<companyList.size();j++) {
						if(companyList.get(j).getSoldShares()==0) {
							companyList.get(j).shareDiscount();
						}
					}
				}
				// calls the buyStock method and return updated list of companies
				companyList = investorList.get(i).buyStock(companyList);
			}
		};
	}

	// This method uses an Iterator design pattern that will help it traverse both list as long as there is a next element
	public boolean keepGoing() {
		// Iterator 1 - populate a list with all budgets
		List<Double> sorted = new ArrayList<>();		
		Iterator<Investor> it = investorList.iterator();
		while(it.hasNext()) {
			double budget = ((Investor) it.next()).getBudget();
			sorted.add(budget);			
		}
		//return highest budget
		double max = Collections.max(sorted);

		// Iterator 2 - populate a list with all companies share prices
		List<Double> sortedPrice = new ArrayList<>();
		Iterator<Company> companyIt = companyList.iterator();
		while(companyIt.hasNext()) {
			double shareNumber = ((Company)companyIt.next()).getShares();
			if(shareNumber > 0) {
				sortedPrice.add(((Company)companyIt.next()).getSharePrice());
			}
		}
		// return cheapest share price
		double min = Collections.min(sortedPrice);
		// Test if the cheapest share is lower or equal to the highest budget
		if(min <= max) {
			return true;
		}else {
			return false;
		}
	}
	
	// get largest and smallest capital
	public void  lowestOrHighest(int a) {
		// create a map to be populate with ID/capital for each company
		HashMap<Integer, Double> priceList = new HashMap<Integer, Double>();
		// traverse company list and generate capital (shares x share price)
		for(Company c: companyList) {
			priceList.put(c.getCompanyID(), (c.getSharePrice() * c.getShares()));
		}
		// store max and min value
		double maxValue = (Collections.max(priceList.values()));
		double minValue = (Collections.min(priceList.values()));
		// if input from user is 1 returns highest, if 2 returns lowest	
		if(a==1){
			System.out.println("Highest capital: " + maxValue);
			System.out.println("Companies with highest capital: ");
			//  store the values on each priceList element and return the highest
			for(Entry<Integer, Double> entry : priceList.entrySet()) {
			if(entry.getValue()==maxValue) {
				// print which company has this capital
				System.out.println("ID " + entry.getKey());
				}
			}		
		}else if(a==2) {
			System.out.println("Lowest capital: " + minValue);
			System.out.println("Companies with lowest capital: ");
			//  store the values on each priceList element and return the lowest
			for(Entry<Integer, Double> entry : priceList.entrySet()) {
				if(entry.getValue()==minValue) {
				// print which company has this capital
				System.out.println("ID " + entry.getKey());
				}
			}	
		}
		
	}
	//	get richer and poorest
	public void  richestOrPoorest(int a) {
		// create a map to be populate with ID/shares for each investor
		HashMap<Integer, Integer> shareholderList = new HashMap<Integer, Integer>();
		// traverse the list of investors and add id and share count to the hashmap
		for(Investor inv: investorList) {
			shareholderList.put(inv.getInvestorID(), inv.getShares());
		}
		//  get max and min number of share store on hashmap
		double maxValue = (Collections.max(shareholderList.values()));
		double minValue = (Collections.min(shareholderList.values()));
		// if input from user is 1 returns highest, if 2 returns lowest	
		if(a==1) {
			System.out.println("Highest share count: " + maxValue);
			System.out.println("Investor with highest share count: ");
			//  store the values on each shareholder list element and return the highest
			for(Entry<Integer, Integer> entry : shareholderList.entrySet()) {
					if(entry.getValue()==maxValue) {
						// print which investor has this number of shares
						System.out.println("ID " + entry.getKey());
					}
				}
		}else if(a==2) {
			System.out.println("Lowest share count: " + minValue);
			System.out.println("Investor with lowest share count: ");
			//  store the values on each shareholder list element and return the highest
			for(Entry<Integer, Integer> entry : shareholderList.entrySet()) {
					if(entry.getValue()==minValue) {
						// print which investor has this number of shares
						System.out.println("ID " + entry.getKey());
					}
				}
		}
	}
	//	return total number of transactions
	public int getTotalSales() {
		return totalSales;
	}
	// adds 1 to the total number of transactions
	public static void setTotalSales() {
		totalSales++;
	}
}
