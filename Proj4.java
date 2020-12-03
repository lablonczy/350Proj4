import java.util.LinkedList;

public class Proj4 {

	public static void main(String[] args) {
		String word = "michelangelo";
		String palindrome = listToString(palindrome(stringToList(word), 0));

		System.out.println(palindrome);
	}

	private static String listToString(LinkedList<Character> charsList){
		String outputString = "";

		for(Character c : charsList)
			outputString += c;

		return outputString;
	}

	private static LinkedList<Character> stringToList(String word){
		char[] chars = word.toCharArray();
		LinkedList<Character> baseWord = new LinkedList<>();

		for(int i=0;i<chars.length;i++)
			baseWord.add(chars[i]);

		return baseWord;
	}

	private static LinkedList<Character> palindrome(LinkedList<Character> current, int lowerBound){
		int upperBound = (current.size()-1) - lowerBound;
		LinkedList<Character> substring = subList(current, lowerBound, upperBound);

		//base cases, for odd and even sized lists
		if(substring == null)
			return current;

		//only do work if chars r not already mirrored
		char first = substring.getFirst(), last = substring.getLast();
		if(Character.toLowerCase(first) != Character.toLowerCase(last)){
			//insert uppercase char to left of substring
			LinkedList<Character> firstOption = new LinkedList<>(current);
			firstOption.add(lowerBound, Character.toUpperCase(last));
			firstOption = palindrome(firstOption, lowerBound+1);

			LinkedList<Character> secOption = new LinkedList<>(current);
			secOption.add(upperBound+1, Character.toUpperCase(first));
			secOption = palindrome(secOption, lowerBound+1);

			if(firstOption.size() <= secOption.size())
				return firstOption;
			else
				return secOption;


		} else {
			return palindrome(current, lowerBound+1);
		}

	}

	private static LinkedList<Character> subList(LinkedList<Character> chars, int lowerBound, int upperBound){
		if(lowerBound >= upperBound)
			return null;

		LinkedList<Character> sublist = new LinkedList<>();
		for(int i=lowerBound;i<=upperBound;i++)
			sublist.add(chars.get(i));

		return sublist;
	}


}