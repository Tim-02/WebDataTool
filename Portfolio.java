package webdatatool;

import java.util.HashMap;

public class Portfolio {
    
    private double totalValue;
    private HashMap<String,Asset> Assets;
    private HashMap<String,Stock> Stocks;
    private HashMap<String,Coin> Coins;
    private String[] AssetList;
    private String[] StockList;
    private String[] CoinList;
    
    public Portfolio(){
        totalValue = 0;
    }
    
    public double getTotalValue(){
        totalValue = 0;
        if(Assets.size()>0){
            AssetList = (String[]) Assets.keySet().toArray();
            for(int i=0;i<Assets.size();i++)
                totalValue+=Assets.get(AssetList[i]).getValue();
        }
        if(Coins.size()>0){
            CoinList  = (String[]) Coins.keySet().toArray();
            for(int i=0;i<Coins.size();i++) 
                totalValue+=Coins.get(CoinList[i]).getValue();
        }
        if(Stocks.size()>0){
            StockList = (String[]) Stocks.keySet().toArray();
            for(int i=0;i<Stocks.size();i++)
                totalValue+=Stocks.get(StockList[i]).getValue();
        }
        return totalValue;
    }
    
    public class Asset{
        private String name;
        private double amount;
        private double price;
        
        public Asset(){
            
        }
        
        public void setAmount(double amount)    { this.amount = amount; }
        
        public void setValue(double price)      { this.price = price; }
        
        public void setName(String name)        { this.name = name; }
        
        public String getName()                 { return name; }
        
        public double getValue()                { return amount*price; }
        
    }
    
    public class Coin extends Asset{
        
        private String lcw_name;
        private String lcw_abr;
        private String lcw_link;
        
        public Coin(){
            
        }
        
        public void setLcw(String name,String abr){
            lcw_name = name;
            lcw_abr = abr;
            setLcwLink("https://www.livecoinwatch.com/price/"+name+"-"+abr);
            update();
        }
        
        public void setLcwLink(String link)     { this.lcw_link = link; }
        
        public String getLcwLink()              { return lcw_link; }
        
        public void update(){
            String[] temp = WebScanner.lcw.getData(lcw_link);
            super.name  = temp[0];
            super.price = Double.parseDouble(temp[2]);
        }
        
        public String getData(){
            return super.getName()+"\t"+super.getValue();
        }
        
    }
    
    public class Stock extends Asset{
        
    }
}
