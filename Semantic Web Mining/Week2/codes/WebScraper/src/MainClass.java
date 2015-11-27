
import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class MainClass {
	public static void main(String[] args)
	{
		File input = new File("Class Search _ Course Catalog.htm");
		Document doc;
		try {
			doc = Jsoup.parse(input, "UTF-8");
			
			Elements links = doc.select("a[href]"); //select all anchor tags with an href attribute
			Elements jpgs = doc.select("img[src$=.jpg]"); // select all image tag that  a url of jpg image type
			Elements instructors = doc.select("a[title*=Instructor] span");  // select all span that a descendant (not necessarily a direct child) 
			//of an anchor tag with  attribute title contains "Instructor"  
			
			// print links
			for(Element e:links)
			{
				String href = e.attr("href").trim();
				System.out.println("url: "+href);
				
			}
			
			//print jpg image src
			for(Element e:jpgs)
			{
				String href = e.attr("src").trim();
				System.out.println("image: "+href);
				
			}
			
			// print instructors names 
			for(Element e : instructors)
			{
				String cont = e.html();
				System.out.println("Instructor name: "+cont);
			
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
