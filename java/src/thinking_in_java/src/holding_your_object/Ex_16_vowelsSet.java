package holding_your_object;

//TIJ4 Chapter Holding, Exercise 16, page 419
/* Create a Set of the vowels. Working from UniqueWords.java, count and
* display the number of vowels in each input word, and also display the total
* number of vowels in the input file.
*/



import java.util.*;

public class Ex_16_vowelsSet {

	
	public static int countVowels (String text) {
		
		List<String> wordsFromText = new ArrayList<>();
		wordsFromText.addAll(Arrays.asList(text.split("\\W")));
		
		System.out.println(wordsFromText);
		
		Set<Character> vowels = new HashSet<Character>();		
		vowels.addAll(Arrays.asList(new Character[] {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'}));
		
		Map<String, Integer> mapVowels = new TreeMap<>();
		
		int countOfVoluwes = 0;
		for (String word : wordsFromText) {
			int count = 0;
			for (Character vol : word.toCharArray()) 
				if (vowels.contains(vol)) {
					count++;
					countOfVoluwes++;
				}
			mapVowels.put(word, count);
			System.out.println("In word " + word + " there are " + count + " vowuls");
		}
		
		System.out.println("Map : " + mapVowels);
		
		return countOfVoluwes;
		
	}
	
	public static void main(String[] args) {
	
		
		int vowelsInText = countVowels("testing this program");
		System.out.println("In text there are " + vowelsInText);

	}

}

