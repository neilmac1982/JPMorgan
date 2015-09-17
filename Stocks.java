
public class Stocks {

	private String symbol;
	private String type;
	private int lastDividend;
	private int parValue;
	private double tickerPrice;
	
	
	public Stocks (String symbol,String type) {
		
		this.symbol=symbol;
		this.type=type;
		
		
	}
	
	
	public String getSymbol(){
		
		return symbol;
		
	}
	
	public String getType(){
		
		return type;
	}
	
	public int getLastDividend(){
		return lastDividend;
	}
	
	public void setLastDividend(int newLastDividend){
		newLastDividend = lastDividend;
	}
	
	public int getParValue(){
		return parValue;
	}
	
	public void setParValue(int newParValue){
		newParValue = parValue;
	}
	
	public double getTickerPrice(){
		return tickerPrice;
	}


	@Override
	public String toString() {
		return "Stocks [symbol=" + symbol + ", type=" + type + ", lastDividend=" + lastDividend + ", parValue="
				+ parValue + ", tickerPrice=" + tickerPrice + "]";
	}


	
	

	
	
	
	
	
	
}
