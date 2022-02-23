package webdatatool;


public class WebDataTool {

    public static void main(String[] args) {
        // 
    }
    
    public WebDataTool(){
        //
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
        
        private String lcw_link;
        
        public Coin(){
            
        }
        
        public void setLcwLink(String link)     { this.lcw_link = link; }
        
        public String getLcwLink()              { return lcw_link; }
        
        public void update(){
            super.setValue(WebScanner.lcw.getValue(lcw_link));
            super.setName(WebScanner.lcw.getName(lcw_link));
        }
        
        public String getData(){
            return super.getName()+"\t"+super.getValue();
        }
        
    }
    
}
