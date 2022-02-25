package webdatatool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScanner {
    
    public class mm{
        // gets data from www.moneymetals.com            
        public static double getGoldValue(){
            return getValue("https://www.moneymetals.com/gold-price");
        }
        
        public static double getSilverValue(){
            return getValue("https://www.moneymetals.com/silver-price");
        }
        
        public static double getPlatinumValue(){
            return getValue("https://www.moneymetals.com/platinum-price");
        }
        
        public static double getCopperValue(){
            return getValue("https://www.moneymetals.com/copper-prices");
        }
                
        private static double getValue(String url){
            try{
                Document doc = Jsoup.connect(url).get();  
                Elements header = doc.select("[class=col-sm-7 col-sm-push-5 live-price-panel]");
                Elements body = header.select("tr");
                Element data = body.select("td").get(1);
                return Double.parseDouble(data.text().replace("$", "").replace(",",""));
            } catch (Exception e ) { 
                e.printStackTrace();
                return -1;
            }
        }
    }
    
    
    public class lcw{       
        // gets data from www.livecoinwatch.com      
        public static double getValue(String url){
            try{
                Document doc = Jsoup.connect(url).get();  
                Elements header = doc.select("[class=cion-item coin-price-large]");
                Element price = header.select("[class=price]").first();
                return Double.parseDouble(price.text().replace("$", ""));
            } catch (Exception e ) { 
                e.printStackTrace();
                return -1;
            }
        }
        
        public static String getMarketCap(String url){
            try{
                Document doc = Jsoup.connect(url).get();  
                Elements cap = doc.select("[class=cion-item text-left text-sm-center text-lg-left first-row-col]");
                return cap.select("[class=price no-grow]").first().text();
            } catch (Exception e ) { 
                e.printStackTrace();
                return null;
            }
        }
        
        public static String getName(String url){
            try{
                Document doc = Jsoup.connect(url).get();  
                Elements cap = doc.select("[class=coin-name]");
                return cap.first().text();
            } catch (Exception e ) { 
                e.printStackTrace();
                return null;
            }
        }
        
         public static String[] getData(String url){
            String[] data = new String[10];
            try{
                Elements e1;
                Document doc = Jsoup.connect(url).get();  
                // 0: name
                String temp = url.replace("https://www.livecoinwatch.com/price/", "");
                data[0] = temp.substring(0, temp.indexOf('-'));
                // 1: sign
                data[1] = temp.substring(temp.indexOf('-')+1);
                // 2: value
                e1 = doc.select("[class=cion-item coin-price-large]");
                data[2] = e1.select("[class=price]").first().text().replace("$","");
                // 3: market cap
                e1 = doc.select("[class=cion-item text-left text-sm-center text-lg-left first-row-col]");
                data[3] = e1.select("span").text().replace("$","");
                // 4: volume
                e1 = doc.select("[class=cion-item text-center text-lg-left first-row-col]");
                data[4] = e1.select("span").text().replace("$","");                
                // 5: circulation
                e1 = doc.select("[class=cion-item col-md-4 col-lg-3 px-1 py-1 py-md-0 text-left text-sm-center text-md-right]");
                data[5] = e1.select("span").text();  
                // 6: total supply 
                e1 = doc.select("[class=cion-item col-md-4 col-lg-3 px-1 py-1 py-md-0 text-center text-md-right]");
                data[6] = e1.select("span").text(); 
                // 7: liquidity
                e1 = doc.select("[class=cion-item col-md-4 col-xl-3 px-1 py-1 py-md-0 text-left text-sm-center text-md-right]");
                data[7] = e1.select("span").get(1).text();    
                // 8: Bids
                e1 = doc.select("[class=cion-item px-1 py-1 py-md-0 text-center col-md-4 col-xl-3 text-md-right]");
                data[8] = e1.select("span").text();    
                // 9: Asks
                e1 = doc.select("[class=cion-item px-1 py-1 py-md-0 text-right text-sm-center col-md-4 col-xl-3 text-md-right]");
                data[9] = e1.select("span").text();
            } catch (Exception e){
                e.printStackTrace();
            }
            return data;
        }
    }
}
