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
    
}
