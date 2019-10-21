package leetcode;

public class UberStringAndPartDivisionWithSquareBrackets {
	
	 private static String findSubstring(String word, String[] parts) {
		 
		 int maxLength = 0;
		 int maxIndex = 0;
		 String maxPart = "";
		 boolean matchFound = false;
		 
		 for(String part:parts) {
			 
			 int index = word.indexOf(part);
			 if(index >= 0) {
				 
				 int l = part.length();
				 
				 if(maxLength<l) {
					 maxLength = l;
					 maxPart = part;
					 maxIndex = index;
					 matchFound = true;
				 }
			 }
		 }
		 
		 if(matchFound) {
			 String first = word.substring(0,maxIndex);
			 String part = word.substring(maxIndex,maxIndex+maxPart.length());
			 String last = word.substring(maxIndex + maxPart.length(),word.length());
			
			 return first+"["+part+"]"+last;
		 }
		 return word;
		
	 }
	
	 private static String[] findSubstrings(String[] words, String[] parts) {
	        String[] newWords = new String[words.length];
	        
	        int i = 0;
	        
	        for(String word : words) {
	            newWords[i++] = findSubstring(word, parts);
	        }
	        return newWords;
	 }

	public static void main(String[] args) {
		
		String[] words = {"Apple", "Melon", "Orange", "Watermelon"};
		String[] parts = {"a", "mel", "lon", "el", "An"};
		
		String[] final_words = findSubstrings(words,parts);
		for (String word: final_words ) {
            System.out.println(word);
        }

	}

}
