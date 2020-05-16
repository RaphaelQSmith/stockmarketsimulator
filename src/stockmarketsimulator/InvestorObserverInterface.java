package stockmarketsimulator;

import java.util.List;

public interface InvestorObserverInterface {

	// execute transaction and updates variables accordingly
	List<Company> buyStock(List<Company> comp);

	//	subtract price of the share from the budget, after a transaction
	void updateBudget(double stockPrice);

}