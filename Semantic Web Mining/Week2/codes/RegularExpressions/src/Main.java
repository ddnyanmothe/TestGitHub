import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * Simple example of reading text file containing addresses and fitching only the ones that match 
 * the regular expression.
 * 
 */

public class Main {

	public static void main(String[] args)
	{
		//read a text file that contains address list
		String str =  readFileToStr("data/addresses.txt");
		
		// regular expression for an address followed by a newline. You may test different regular expressions on any
		// online test tool.
		Pattern p = Pattern.compile("(\\d{1,5}\\s\\w\\s\\w+\\s\\w+\\.?\\s\\w+(\\s\\w+)?,?\\s\\w+\\s\\d{5})\\s");
		Matcher m = p.matcher(str);
		
		
		List<String> allMatches = new ArrayList<String>();
		
		 while (m.find()) {
			   allMatches.add(m.group());
			 }
		 int i=0;
		 for(String str_i:allMatches)
		 {
			 System.out.println((++i)+">>> "+str_i);
		 }
		

	}

	public static String readFileToStr(String fileName)
	{
		String returnedValue = "";
		try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
		{
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				returnedValue += sCurrentLine+"\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return returnedValue;

	}
}
