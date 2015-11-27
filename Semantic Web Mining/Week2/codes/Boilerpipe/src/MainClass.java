import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.xml.sax.InputSource;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.extractors.KeepEverythingExtractor;
import de.l3s.boilerpipe.extractors.LargestContentExtractor;


public class MainClass {
	public static void main(String args[])
	{
		try {

			URL url = new URL("http://cidse.engineering.asu.edu/seminar-social-bootstrapping-and-content-curation-may-16/");


			InputSource is = new InputSource();
			is.setEncoding("UTF-8");
			is.setByteStream(url.openStream());
			//instead of is variable, html content as a string can be passed to getText 
			String text = LargestContentExtractor.INSTANCE.getText(is); // ArticleExtractor, KeepEverythingExtractor , DefaultExtractor
			System.out.println(text);
		} catch (BoilerpipeProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	public static String readHTMLToString(String fileName)
	{
		StringBuilder contentBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String str;
			while ((str = in.readLine()) != null) {
				contentBuilder.append(str);
			}
			in.close();
		} catch (IOException e) {
		}
		String content = contentBuilder.toString();
		return content;
	}*/
}
