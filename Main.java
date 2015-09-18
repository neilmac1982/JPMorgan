import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Main {
	
	public static void main (String [] args) {
		
		//The date of each trade is the current date
		Date date = new Date();
		
		//set up an array of trade objects
		Trade [] tradeArray;
		tradeArray = new Trade[10];
		
		/*
		 *Assumptions 
		 * trade prices and volumes are taken from London Stock Exchange last 5 trades for companies
		 * each stock will have multiple trades
		 */
		tradeArray[0] =new Trade("TEA","Common",date,168,230.00);
		tradeArray[1] =new Trade("TEA","Common",date,1250,158.50);
		tradeArray[2] =new Trade("POP","Common",date,732,846.40);
		tradeArray[3] =new Trade("POP","Common",date,7579,149.17);
		tradeArray[4] =new Trade("POP","Common",date,2000,115.00);
		tradeArray[5] =new Trade("GIN","Preferred",date,100,115.00);
		tradeArray[6] =new Trade("GIN","Preferred",date,928,115.00);
		tradeArray[7] =new Trade("ALE","Preferred",date,8000,148.69);
		tradeArray[8] =new Trade("ALE","Common",date,967,846.50);
		tradeArray[9] =new Trade("JOE","Common",date,1050,158.50);
		double tTotalTradePrice = 0.0;
		int tTotalVolume = 0;
		double pTotalTradePrice = 0.0;
		int pTotalVolume = 0;
		for (int i = 0; i < tradeArray.length;i++) {
			
			int volume = tradeArray[i].getVolume();
			tradeArray[i].setBSI(volume);
			double Tprice = tradeArray[i].getPrice();
			int Tvolume = tradeArray[i].getVolume();
			tradeArray[i].setTransactionTotal(Tprice,Tvolume);
			System.out.println(tradeArray[i].toString());
			
			
			/*
			 * Assumption
			 * Ticker Price is the price of Stock on stock exchange ticker
			 */
			String symbol = tradeArray[i].getSymbol();
			int lastDividend = 0;
			int parValue = 0;
			double tickerPrice = 0.0;
			
			/*the last dividend, parValue and ticker price will be different for each stock so the below switch statement
			*will assign a different value depending on the symbol of the stock
			*/
			switch (symbol){
			case "TEA":
				lastDividend = 0;
				parValue = 100;
				tickerPrice = 130.00;
				//totalTradePrice = tradeArray[i].getTransactionTotal();
			break;
			case "POP":
				lastDividend = 8;
				parValue = 100;
				tickerPrice = 500.00;
				//totalTradePrice = tradeArray[i].getTransactionTotal();
				
			break;
			case "ALE":
				lastDividend = 23;
				parValue = 60;
				tickerPrice = 1200.00;
				//totalTradePrice = tradeArray[i].getTransactionTotal();
			break;
			case "GIN":
				lastDividend = 8;
				parValue = 100;
				tickerPrice = 825.00;
				//totalTradePrice = tradeArray[i].getTransactionTotal();
				
			break;
			case "JOE":
				lastDividend = 13;
				parValue = 200;
				tickerPrice = 2500;
				//totalTradePrice = tradeArray[i].getTransactionTotal();
			break;
			
			}
			
			// calculating the dividend yield depending on what the type of Stock is
			double dividendYield = 0.0;
			String stockType = tradeArray[i].getType();
			
			if (stockType != null) {
				if (stockType == "Common"){
					
					dividendYield = lastDividend / tickerPrice;
					
				}else {
					
					double fixedDividend = 0.02 * tradeArray[i].getPrice();
					dividendYield = (fixedDividend * parValue) / tickerPrice;   
					
				}
				
				System.out.println("Stock : "+ tradeArray[i].getSymbol());
				System.out.println("Dividend Yield: "+ dividendYield);
			}
			
			
			double PERatio = 0.0;
			PERatio = lastDividend / tradeArray[i].getPrice();
			System.out.println("P/E Ratio: "+ PERatio);
			
			
			//System.out.println("Stock is:"+symbol+ "& Total TradePrice is: "+totalTradePrice);
			
			
				
		
		}
		/* In order to calculate the Stock Price we need to add up all the trade prices and volumes for each stock and
		* and then divide them by the quantity of each stock traded.
		*/
		for (int j=0; j<2 ;j++){
			ArrayList<Double> transTotal = new ArrayList<Double>();
			transTotal.add(tradeArray[j].getTransactionTotal());
			System.out.println("Totals: "+transTotal);
			double [] arr = new double [transTotal.size()];
			for (int k =0;k<transTotal.size();k++){
				arr[k] = transTotal.get(k);
				
			}
			for (double l:arr){
				
				System.out.println(l);
				tTotalTradePrice += l;
			}

			
		
		
		
		}
		
		System.out.println("Total TEA Price "+tTotalTradePrice);
		
		for (int j = 0;j<2;j++){
			ArrayList<Integer> quantity = new ArrayList<Integer>();
			quantity.add(tradeArray[j].getVolume());
			//System.out.println("Volume: "+volume);
			int [] volArr = new int [quantity.size()];
			for (int k =0;k<quantity.size();k++){
				volArr[k] = quantity.get(k);
			}
			for (int l:volArr){
				System.out.println(l);
				tTotalVolume +=l;
			}
			
			
			
		}
		
		System.out.println("Total TEA Volume: "+tTotalVolume);
		
		double tStockPrice =  tTotalTradePrice/ tTotalVolume;
		System.out.println("POP Stock Price: "+tStockPrice);
		
		for (int j=2; j<4 ;j++){
			ArrayList<Double> transTotal = new ArrayList<Double>();
			transTotal.add(tradeArray[j].getTransactionTotal());
			System.out.println("Totals: "+transTotal);
			double [] arr = new double [transTotal.size()];
			for (int k =0;k<transTotal.size();k++){
				arr[k] = transTotal.get(k);
				
			}
			for (double l:arr){
				
				System.out.println(l);
				pTotalTradePrice += l;
			}

			
		
		
		
		}
		
		System.out.println("Total POP Price "+pTotalTradePrice);
		
		for (int j = 0;j<2;j++){
			ArrayList<Integer> quantity = new ArrayList<Integer>();
			quantity.add(tradeArray[j].getVolume());
			//System.out.println("Volume: "+volume);
			int [] volArr = new int [quantity.size()];
			for (int k =0;k<quantity.size();k++){
				volArr[k] = quantity.get(k);
			}
			for (int l:volArr){
				System.out.println(l);
				pTotalVolume +=l;
			}
			
			
			
		}
		
		System.out.println("Total POP Volume "+pTotalVolume);
			
		double pStockPrice =  pTotalTradePrice/ pTotalVolume;
		System.out.println("POP Stock Price: "+pStockPrice);
		
		double geoMean = (tStockPrice + pStockPrice) / 2;
		System.out.println("GCBE All Share Index: "+geoMean);
	
	}
			
			
		
}
		

	
	

			
			
		
			
	
	
	


			
	
		
		
		
		
	
		
	
	
	
	

	
	

