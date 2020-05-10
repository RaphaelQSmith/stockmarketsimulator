package stockmarketsimulator;

public class StockMarket {

	private int totalShares;
	private Company higher, lower;
	private Investor richer, poorest;
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
