package webdatatool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScanner {
    public class lcw{       
        // 
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
          // to be added  
          return null;
        }
    }
}
