package stockmarketsimulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
	
			StockMarket sm = new StockMarket();
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
			
			System.out.println("\nTotal sales of the day: " + sm.getTotalSales());
	
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String input;
		boolean close = false; 
		try{
		   do {
			//	Prints menu on console
			System.out.println("\nSelect one option to be shown: \n"
					+ "\n(1) Company with highest capital\n"
					+ "(2) Company with lowest capital\n"
					+ "(3) Investor with highest number of shares\n" 
					+ "(4) Investor with lowest number of shares\n"
					+ "(5) Exit\n"
					);
			input = br.readLine();
			
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
			
			}while(close==false);
			
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
