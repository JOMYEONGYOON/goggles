package task1;
import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class JsoupParserHandler {
	public static void main(String[] args){
		Document doc = null;
		File f = new File("test.xml");
		try {
			doc = Jsoup.connect("https://www.youtube.com/feeds/videos.xml?playlist_id=PL4fGSI1pDJn6jXS_Tv_N9B8Z0HTRVJE0m").postDataCharset("utf-8").get();
//			doc = Jsoup.parse(f,"utf-8");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
