package stockmarketsimulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
	
		//  Creates an Instance of the StockMarket class which runs a trading day simulation
			StockMarket sm = new StockMarket();
		// Prints a fake loading screen for design purpose
			System.out.print("Running sales");
			for(int i=0;i<5;i++) {
				System.out.print(".");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// return total number of trades performed during simulation
			System.out.println("\nTotal trades of the day: " + sm.getTotalSales());
	
		// Create input reader instance
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String input;
		// prints a menu on screen while close variable == false
		boolean close = false; 
		try{
		   do {
			   System.out.println("\nSelect one option to be shown: \n"
					+ "\n(1) Company with highest capital\n"
					+ "(2) Company with lowest capital\n"
					+ "(3) Investor with highest number of shares\n" 
					+ "(4) Investor with lowest number of shares\n"
					+ "(5) Exit\n"
					);
			   // reads keyboard input
				input = br.readLine();
			   // check input and run corresponding method
				if(input.equals("1")) {
					sm.lowestOrHighest(1);
				}else if(input.equals("2")) {
					sm.lowestOrHighest(2);
				}else if(input.equals("3")) {
					sm.richestOrPoorest(1);
				}else if(input.equals("4")) {
					sm.richestOrPoorest(2);
				}else if(input.equals("5")){
					close = true;
				}
				// check if program should be closed
				}while(close==false);
				
			}catch (IOException e) {
					e.printStackTrace();
				}
			
		}

}
