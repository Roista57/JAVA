package Crawling;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupCrawlingEexample {
	public JsoupCrawlingEexample(){
		String url = "https://finance.naver.com/item/sise_day.naver?code=000020&page1";
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> close = new ArrayList<String>();
		Document doc = null;
	    try{
	    	doc = Jsoup.connect(url).get();
	    	Elements elementDate = doc.select("td:nth-child(1) > span");
	    	Elements elementClose = doc.select("td:nth-child(2) > span");
	    	for(Element ele : elementDate) {
	    		date.add(ele.text());
	    	}
	    	for(Element ele : elementClose) {
	    		close.add(ele.text());
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    System.out.println("date size : "+date.size()+" close size : "+close.size());
	}

	public static void main(String[] args) {
		new JsoupCrawlingEexample();
	}
}
