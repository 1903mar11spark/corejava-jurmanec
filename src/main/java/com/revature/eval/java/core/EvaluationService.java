package com.revature.eval.java.core;

import java.util.*;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	
	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}
	

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) { 
		String capLettersString = Character.toString(phrase.charAt(0)); 
		for (int i = 0 ; i < phrase.length() ; i++ ) { 
			if (Character.isSpaceChar((Character)phrase.charAt(i)) || ((Character)phrase.charAt(i)).equals((Character)'-')) {
				//locates index of spaces 
				capLettersString = capLettersString.concat(Character.toString(phrase.charAt(i+1))); 
			}
		}
		return capLettersString.toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (sideOne == sideTwo && sideOne == sideThree && sideTwo == sideThree) {
				return true; 
			} else {
			return false;
			}
		}

		public boolean isIsosceles() {
			if (this.isEquilateral()) {
				return true; 
			} else if (!(this.isScalene())) {
				return true; 
			} else 
			return false;
		}

		public boolean isScalene() {
			if (sideOne != sideTwo && sideOne != sideThree && sideTwo != sideThree) {
				return true; 
			} else {
			return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		//local variables 
		int cumScore = 0; 
		int letterScore = 0; 
		//loop through letters, adding a letter score to the cumScore each time.
		for (int i = 0; i <string.length(); i++ ) {
			Character letter = string.toLowerCase().charAt(i); 
			switch(letter) {
				case 'a': 
					letterScore = 1; 
					break;
				case 'e': 
					letterScore = 1; 
					break; 
				case 'i': 
					letterScore = 1; 
					break; 
				case 'o': 
					letterScore = 1; 
					break; 
				case 'u': 
					letterScore = 1; 
					break; 
				case 'l': 
					letterScore = 1; 
					break;
				case 'n': 
					letterScore = 1; 
					break;
				case 'r': 
					letterScore = 1; 
					break;
				case 's': 
					letterScore = 1; 
					break;
				case 't': 
					letterScore = 1; 
					break;
				case 'd': 
					letterScore = 2; 
					break;
				case 'g': 
					letterScore = 2; 
					break;
				case 'b': 
					letterScore = 3; 
					break;
				case 'c': 
					letterScore = 3; 
					break;
				case 'm': 
					letterScore = 3; 
					break;
				case 'p': 
					letterScore = 3; 
					break; 
				case 'f': 
					letterScore = 4; 
					break;
				case 'h': 
					letterScore = 4; 
					break;
				case 'v': 
					letterScore = 4; 
					break;
				case 'w': 
					letterScore = 4; 
					break;
				case 'y': 
					letterScore = 4; 
					break; 
				case 'k': 
					letterScore = 5; 
					break;
				case 'j': 
					letterScore = 8; 
					break; 
				case 'x': 
					letterScore = 8; 
					break;
				case 'q': 
					letterScore = 10; 
					break; 
				case 'z': 
					letterScore = 10; 
					break;
				default: 
					break; 
			}
			//end of switch block 
			cumScore = cumScore + letterScore;  
		}
		//end of loop through letters 
		return cumScore; 
	}
	//end of getScrabbleScore method 

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException {
		String cleanNum = ""; 
		for(int i = 0; i < string.length(); i++ ) {
			//if statement for permitted characters to be excluded from cleanNUm
			if (Character.isSpaceChar((Character)string.charAt(i)) || ((Character)string.charAt(i)).equals((Character)'.') || ((Character)string.charAt(i)).equals((Character)'(') || ((Character)string.charAt(i)).equals((Character)')') || ((Character)string.charAt(i)).equals((Character)'-')) {
				continue; 
			} else if (Character.isLetter(string.charAt(i))) {
				throw new IllegalArgumentException("Letters and special characters are not permitted"); 
			} else if (!(Character.isDigit(string.charAt(i)))) {
				throw new IllegalArgumentException("Letters and special characters are not permitted"); 
			} else {
				//we catch the permitted characters and concatenate to cleanNum
				cleanNum = cleanNum.concat(Character.toString(string.charAt(i))); 
			}
		}
		if (cleanNum.length() > 10) {
			throw new IllegalArgumentException("Please enter a 10 digit number"); 
		}
		return cleanNum;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		//declare things
		Map<String, Integer> dictionary = new HashMap<>(); 
		int wordStartIndex = 0; 
		int wordEndIndex = 0;  
		//logic of method 
		if (string.contains("\n")) {
			for (int i = 0; i < string.length(); i++) {
				if (((Character)string.charAt(i)).equals((Character)',') || (i == (string.length()-1))) {
					//consider case of reaching end of string
					if (i == (string.length()-1)) {
						wordEndIndex = i+1; 
					} else  {	
						wordEndIndex = i; 
					}
					//get end of word index, generate substring, check if in dictionary, update dictionary, wordStartIndex 
					String subString = string.substring(wordStartIndex, wordEndIndex);
					if (!(dictionary.containsKey(subString))) {
						dictionary.put(subString, 1); 
					} else {
						dictionary.put(subString, dictionary.get(subString) + 1);
					}
					if (!(i == (string.length()-1))) {
						wordStartIndex = i + 2; 
					}
				}	
			}
		} else {
			for (int j = 0; j < string.length(); j++) {
				if (Character.isSpaceChar((Character)string.charAt(j)) || ((Character)string.charAt(j)).equals((Character)',') || (j == (string.length()-1))) { 
					if (j == (string.length()-1)) {
						wordEndIndex = j+1; 
					} else  {
						wordEndIndex = j; 
					}
					String subString = string.substring(wordStartIndex, wordEndIndex);
					if (!(dictionary.containsKey(subString))) {
						dictionary.put(subString, 1); 
					} else {
						dictionary.put(subString, dictionary.get(subString) + 1);
					}
					if (!(j == (string.length()-1))) {
						wordStartIndex = j + 1;
					}
				}
			}
		}
		return dictionary;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		
		private List<T> sortedList;
		
		public int indexOf(T t) {
			int highIndex = sortedList.size() - 1; 
			int lowIndex = 0;
			
			//return statement 
			return sortedList.indexOf(t);  
		}

		//I'm adding a helper here 
		public void searcherMethod (T high, T low, T t) {
		}

		//constructor for the class
		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}
		
		//getter for its sortedList field 
		public List<T> getSortedList() {
			return sortedList;
		}
		
		//setter for the sortedList field 
		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		int wordStartIndex = 0; 
		int wordEndIndex = 0;  
		String pigString = ""; 
		String pigSuffix = "ay"; 
		for (int i = 0; i < string.length(); i++) {
			if (Character.isSpaceChar((Character)string.charAt(i)) || (i == (string.length()-1))) {
				if (i == (string.length()-1)) {
					wordEndIndex = i+1; 
				} else  {
					wordEndIndex = i; 
				}
				String subString = string.substring(wordStartIndex, wordEndIndex);
				if (((Character)subString.charAt(0)).equals((Character)'a') || ((Character)subString.charAt(0)).equals((Character)'e') || ((Character)subString.charAt(0)).equals((Character)'i') || ((Character)subString.charAt(0)).equals((Character)'o') || ((Character)subString.charAt(0)).equals((Character)'o')) {
					String pigPrefix = subString; 
					String pigWord = pigPrefix.concat(pigSuffix); 
					pigString = pigString.concat(pigWord); 
				} else {
					for (int j = 0; j < subString.length(); j++) {
						if (((Character)subString.charAt(j)).equals((Character)'a') || ((Character)subString.charAt(j)).equals((Character)'e') || ((Character)subString.charAt(j)).equals((Character)'i') || ((Character)subString.charAt(j)).equals((Character)'o') || ((Character)subString.charAt(j)).equals((Character)'u')) {
							if (((Character)subString.charAt(j)).equals((Character)'u') && ((Character)subString.charAt(j+1)).equals((Character)'i')) {
								String pigEnd = subString.substring(0,j+1).concat(pigSuffix);
								String pigWord = subString.substring(j+1, subString.length()).concat(pigEnd);
								pigString = pigString.concat(pigWord); 
								break; 
							}
						String pigEnd = subString.substring(0,j).concat(pigSuffix);
						String pigWord = subString.substring(j, subString.length()).concat(pigEnd); 
						pigString = pigString.concat(pigWord); 
						break; 
						}
					}
				}
				if (!(i == (string.length()-1))) {
					wordStartIndex = i + 1;
					pigString = pigString.concat(" ");
				}	 
			}
		}
		
		return pigString; 
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		String numString = Integer.toString(input); 
		Integer sumCheck = 0; 
		for (int i = 0; i < numString.length(); i ++) {
			Integer digit = Integer.parseInt(numString.substring(i,i+1)); 
			sumCheck = (int) (sumCheck + Math.pow(digit, (numString.length()))); 
		}
		return (sumCheck.equals((Integer)input)); 
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		
		int[] primesOnetoFifty = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463};  
		List<Long> primeFactors = new ArrayList<Long>(); 
			
		for (int i = 0;i < primesOnetoFifty.length; i++  ) { 	
			int count = 0; 
			int remainder = 0; 
			int quotient = (int) l;
			//case where number is divisible by the prime 
			while (remainder == 0 ) {
					int quotientOld = quotient; 
					int quotientNew = quotientOld/primesOnetoFifty[i]; 
					remainder = quotient%primesOnetoFifty[i]; 
					if (remainder == 0) {
						count = count + 1; 
					} 
					quotient = quotientNew; 
			}
			//System.out.println("Count: "+count);
			if (count == 0) {
				continue; 
			} 
			for (int j = 1; j <= count; j++) {
				primeFactors.add((long) primesOnetoFifty[i]); 
			} 
		}
		return primeFactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		
		private int key;
		
		List<Character> alphabet = new ArrayList<>(); 

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			alphabet.add('a'); alphabet.add('b'); alphabet.add('c');alphabet.add('d');  
			alphabet.add('e'); alphabet.add('f'); alphabet.add('g');alphabet.add('h'); 
			alphabet.add('i'); alphabet.add('j'); alphabet.add('k');alphabet.add('l'); 
			alphabet.add('m'); alphabet.add('n'); alphabet.add('o');alphabet.add('p'); 
			alphabet.add('q'); alphabet.add('r'); alphabet.add('s');alphabet.add('t'); 
			alphabet.add('u'); alphabet.add('v'); alphabet.add('w');alphabet.add('x'); 
			alphabet.add('y'); alphabet.add('z'); 
			
			int wordStartIndex = 0; 
			int wordEndIndex = 0;  
			String cipherString = ""; 
			for (int i = 0; i < string.length(); i++) {
				//checks if end of word is reached 
				if (Character.isSpaceChar((Character)string.charAt(i)) || ((Character)string.charAt(i)).equals((Character)',') || ((Character)string.charAt(i)).equals((Character)'!') || ((Character)string.charAt(i)).equals((Character)'.') || (i == (string.length()-1))) { 
					//checks if at end of string 
					if (i == (string.length()-1)) {
						wordEndIndex = i+1; 
					} else  {
						wordEndIndex = i; 
					}
					
					//constructs substring containing one word 
					String subString = string.substring(wordStartIndex, wordEndIndex);
					
					// --- new logic here ---
					String cipherWord = ""; 
					
					//only make replacement with words(substrings) that start with letters
					if (Character.isLetter(string.charAt(wordStartIndex))) {
						
						for (int j = 0; j < subString.length(); j++) { 	
						
							int retrieveIndex; 
							Character currentCharacter =  subString.charAt(j); 
							if (((currentCharacter).equals((Character)'!'))) {
								String charToAppend = "!"; 
								cipherWord  = cipherWord.concat(charToAppend); 
								continue; 
							}
							if (((currentCharacter).equals((Character)'\''))) {
								String charToAppend = "\'"; 
								cipherWord  = cipherWord.concat(charToAppend); 
								continue; 
							}
							if (((currentCharacter).equals((Character)'.'))) {
								String charToAppend = "."; 
								cipherWord  = cipherWord.concat(charToAppend); 
								continue; 
							}
							if (Character.isUpperCase(currentCharacter)) {
								currentCharacter = Character.toLowerCase(currentCharacter);
							}
							int currentCharacterIndexInAlphabet = alphabet.indexOf(currentCharacter); 
							if ((currentCharacterIndexInAlphabet + key > 25)) {
								retrieveIndex = (currentCharacterIndexInAlphabet + key) - 26; 
							} else {
								retrieveIndex = currentCharacterIndexInAlphabet + key; 
							}
							if (Character.isUpperCase(subString.charAt(j))) {
								String newLetter = Character.toString(alphabet.get(retrieveIndex)).toUpperCase(); 
								cipherWord = cipherWord.concat(newLetter); 
							} else {
								String newLetter = Character.toString(alphabet.get(retrieveIndex)); 
								cipherWord = cipherWord.concat(newLetter); 
							}
						}
						//adds the cipherWord to the output String 
						cipherString = cipherString.concat(cipherWord); 
						
					} else {
						
						cipherString = cipherString.concat(subString); 
					}
	
					if (((Character)string.charAt(i)).equals((Character)',')) {
						cipherString = cipherString.concat(","); 
					}
					
					//reassigns wordStartIndex to start of next word and adds a space to end of output
					//string if not at the end of the input string
					
					if (!(i == (string.length()-1))) {
						wordStartIndex = i + 1;
						if (!(((Character)string.charAt(i)).equals((Character)','))) {
							cipherString = cipherString.concat(" ");
						}
					}
				}
			}
			return cipherString;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		
		if (i == 1) {return 2;} 
		if (i == 2) {return 3;}
		
		//calculate primes up to the nth for n greater than 2
		
		List<Integer> primeList = new ArrayList<>(); 
		primeList.add(2); 
		primeList.add(3); 
	
		//Initialize some variables 
		int primeChecker = 5; 
		int primeCounter = 2; 
		int lastPrimeIndex = 1;
		int lastPrime = 3; 
		
		//while we have not filled the list up to what is asked for 
		
		
		while (primeCounter <= i) {
			
			int remainder = 0; 
			
			// starting at 3 then counting down if we can add the next possible number up from 3
			
			for (int j = lastPrimeIndex; j >= 0; j-- ) {
			
				remainder = primeChecker%(primeList.get(j)); 
				
				System.out.println(primeChecker%(primeList.get(j))); 
				
				if (remainder == 0 ) {
					//if divisible by a prime, it is not prime
					
					primeChecker = lastPrime + 2;  
				}
			} 
			if (remainder != 0 )  {
			primeList.add(primeChecker); 
			primeCounter = primeCounter + 1; 
			lastPrimeIndex = lastPrimeIndex + 1;
			lastPrime = primeChecker; 
			primeChecker = lastPrime + 2; 
			}
		}
		
		return primeList.get(i-1);
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		static List<Character> alphabet = new ArrayList<>(); 
		static List<Character> atbashAlphabet = new ArrayList<>(); 
		
		public static String encode(String string) {
			
			alphabet.add('a'); alphabet.add('b'); alphabet.add('c');alphabet.add('d');  
			alphabet.add('e'); alphabet.add('f'); alphabet.add('g');alphabet.add('h'); 
			alphabet.add('i'); alphabet.add('j'); alphabet.add('k');alphabet.add('l'); 
			alphabet.add('m'); alphabet.add('n'); alphabet.add('o');alphabet.add('p'); 
			alphabet.add('q'); alphabet.add('r'); alphabet.add('s');alphabet.add('t'); 
			alphabet.add('u'); alphabet.add('v'); alphabet.add('w');alphabet.add('x'); 
			alphabet.add('y'); alphabet.add('z'); 
			
			atbashAlphabet.add('z'); atbashAlphabet.add('y'); atbashAlphabet.add('x'); 
			atbashAlphabet.add('w'); atbashAlphabet.add('v'); atbashAlphabet.add('u'); 
			atbashAlphabet.add('t'); atbashAlphabet.add('s'); atbashAlphabet.add('r');
			atbashAlphabet.add('q'); atbashAlphabet.add('p'); atbashAlphabet.add('o'); 
			atbashAlphabet.add('n'); atbashAlphabet.add('m'); atbashAlphabet.add('l'); 
			atbashAlphabet.add('k'); atbashAlphabet.add('j'); atbashAlphabet.add('i'); 
			atbashAlphabet.add('h'); atbashAlphabet.add('g'); atbashAlphabet.add('f'); 
			atbashAlphabet.add('e'); atbashAlphabet.add('d'); atbashAlphabet.add('c'); 
			atbashAlphabet.add('b'); atbashAlphabet.add('a');   
			
			
			int wordStartIndex = 0; 
			int wordEndIndex = 0;  
			String englishString = ""; 
			String lowerEnglishString =""; 
			String atbashString = ""; 
			
			for (int i = 0; i < string.length(); i++) {
				//checks if end of word is reached 
				if (Character.isSpaceChar((Character)string.charAt(i)) || ((Character)string.charAt(i)).equals((Character)',') || ((Character)string.charAt(i)).equals((Character)'.') || (i == (string.length()-1))) { 
					//checks if at end of string 
					if (i == (string.length()-1)) {
						wordEndIndex = i+1; 
					} else  {
						wordEndIndex = i; 
					}
					
					//constructs substring containing one word 
					String subString = string.substring(wordStartIndex, wordEndIndex);
					
					//concatenate into an eglishString 
					if (subString.contains(".")) {
						englishString = englishString.concat(subString.substring(0, (subString.length())-1)); 
					} else {
						englishString = englishString.concat(subString); 
					}
					
					// reset startIndex variable if not at end of string
					if (!(i == (string.length()-1))) {
						wordStartIndex = i + 1;
					}
				}
				//end of code that creates an english string with no spaces or puncutaion
			}
			//now working with englishString
			for (int j = 0; j < englishString.length(); j++ ) {
				
				lowerEnglishString = englishString.toLowerCase();
				
				//create the atbashString
				
				Character currentCharacter = lowerEnglishString.charAt(j); 
				int indexInAlphabet = alphabet.indexOf(currentCharacter); 
				
				if (Character.isLetter(currentCharacter)) {
					atbashString = atbashString.concat(Character.toString(atbashAlphabet.get(indexInAlphabet)));
				//case of numbers 
				} else {
					atbashString = atbashString.concat(Character.toString(currentCharacter));
				}
				//break into segments of five characters
				if ((((j+1)%5 == 0) && (j != 0)) && ((!(j == (englishString.length()-1))))) {
					
					atbashString = atbashString.concat(" ");   
				}
				
			}			
			System.out.println("lowerEnglishString: "+lowerEnglishString);
			return atbashString;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			return null;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

}
