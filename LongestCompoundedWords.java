import java.io.*;
import java.util.*;

public class LongestCompoundedWords {
    public static void main(String[] args) {
        String filename = "Input_01.txt"; // Path of the input file

        try {
            Set<String> wordSet = new HashSet<>(); // Creating a HashSet to store unique words
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            // here we are reading the input words and putting it in the hash set.
            while ((line = reader.readLine()) != null) {
                wordSet.add(line);
            }

            // Finding the longest and second longest compounded words
            String[] result = findLargestAndSecondLargestCompoundedWords(wordSet);

            // Printing the results
            System.out.println("Longest Compounded Word: " + result[0]);
            System.out.println("Second Longest Compounded Word: " + result[1]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] findLargestAndSecondLargestCompoundedWords(Set<String> wordSet) {
        String longest = "";
        String secondLongest = "";

        // Iterating each word in the wordSet
        for (String word : wordSet) {
            // Pruning: Skip this word if it's shorter than both the longest and second
            // longest
            if (word.length() < longest.length() && word.length() < secondLongest.length()) {
                continue;
            }

            // Checking if the word is a compounded word
            if (isCompoundedWord(word, wordSet)) {
                if (word.length() > longest.length()) {

                    // Updating the second longest and longest words
                    secondLongest = longest;
                    longest = word;
                } else if (word.length() > secondLongest.length()) {
                    secondLongest = word;
                }
            }
        }

        return new String[] { longest, secondLongest };
    }

    private static boolean isCompoundedWord(String word, Set<String> wordSet) {
        if (word.length() == 0) {
            return false;
        }

        // Splitting the word into prefix and suffix
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            // Checking if both prefix and suffix are in the wordSet or if suffix is a
            // compounded word
            if (wordSet.contains(prefix) && (wordSet.contains(suffix) || isCompoundedWord(suffix, wordSet))) {
                return true;
            }
        }

        return false;
    }
}
