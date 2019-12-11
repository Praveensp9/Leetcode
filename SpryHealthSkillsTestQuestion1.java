/**
 * 	 @author Praveen Patil
 *  
 *   To run the below program, please use the following command.
    
 *   javac SpryHealthSkillsTestQuestion1.java
 *   java SpryHealthSkillsTestQuestion1 <Your Input FileName>
 *   
 *   eg:  javac SpryHealthSkillsTestQuestion1.java
 *   	  java SpryHealthSkillsTestQuestion1 input.txt
 */

package leetcode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SpryHealthSkillsTestQuestion1 {
	private static LinkedHashMap<String,Integer> result = new LinkedHashMap<>();
	
	
	private static HashMap<String,Integer> spryCountWordsInQuotations(String filepath) throws IOException{
		HashMap<String,Integer> map = new HashMap<>();
		try {
			BufferedReader buf  = new BufferedReader(new FileReader(filepath));
			String line;
			Pattern pattern = Pattern.compile("\"[^\"]*\"");
			String file = "";
			while((line = buf.readLine()) != null) {

				file = file + line;
				
			}
			buf.close();

			Matcher match = pattern.matcher(file);
			
			while(match.find()) {
				String s = match.group();
				s = s.substring(1,s.length()-1);
				String[] output = s.split(" ");
				for(String str:output) {
					Pattern p = Pattern.compile("^[A-Za-z'-]+");
					Matcher match1 = p.matcher(str);
					if(match1.find()) {
						map.put(str.toLowerCase(), map.getOrDefault(str.toLowerCase(), 0)+1);
					}
						
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Inside catch block :" + e);
			e.printStackTrace();
		}
	
	   return map;
	}

	public static void main(String[] args) {
		
		try {
			String file = args[0];
			System.out.println("Your Input Filename : " + file);
			HashMap<String,Integer> map = spryCountWordsInQuotations(file);
			map.entrySet()
			   .stream()
			   .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
			   .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
		
			
			for(Map.Entry<String,Integer> entry:result.entrySet()){
				String key = entry.getKey();
				Integer value = entry.getValue();
				System.out.print(key + "->"+ value);
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
