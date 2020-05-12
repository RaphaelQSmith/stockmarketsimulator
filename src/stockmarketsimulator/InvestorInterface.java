package stockmarketsimulator;

import java.util.List;

public interface InvestorInterface {

	List<Company> buyStock(List<Company> comp);

	void updateBudget(double stockPrice);

}