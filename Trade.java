import java.util.Date;

public class Trade extends Stocks {
	
	private Date tradeDate;
	private int volume;
	private String BSI;
	private double price;
	private double transactionTotal;
	
	
	public Trade (String symbol,String type,Date tradeDate,int volume,double price){
		
		super(symbol,type);
		this.tradeDate=tradeDate;
		this.volume=volume;
		this.price=price;
	}
	
	public Date getTradeDate(){
		
		return tradeDate;
	}
	
	public void setDate(Date newDate){
		
		tradeDate = newDate;
		
		
	}
	
	public int getVolume(){
		
		return volume;
	}

	public String getBSI(){
	
	return BSI;
	}
	
	public void setBSI(int volume){
		/*
		 * Assumption
		 * If the stock sells high then it is an indication to buy and vice-versa
		 */
		volume = this.getVolume();
		if (volume > 199){
			BSI = "Buy";
		}else {
			BSI = "Sell";
		}
		
	}


	public double getPrice(){
	
	return price;
	}
	
	public double getTransactionTotal(){
		return transactionTotal;
	}
	
	public void setTransactionTotal(double price,int volume){
		transactionTotal = price * volume;
		
	}
	
	

	@Override
	public String toString() {
		return "Trade [tradeDate=" + tradeDate + ", volume=" + volume + ", BSI=" + BSI + ", price=" + price + "]";
	}

	
	
	
	
	
	

}
