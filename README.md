# LongestCompoundedWords
Logic: To use HashSet to store the data and then using general methods to iterate and find the solution.

The code read the list of word from the input file and store it in the HashSet.

We can take input 01 and 02 by providing the exact path to the file .

I used Hashset for Uniqueness.

Further the findLargestAndSecondLargestCompoundedWords method iterate and finds the largest words.

I used **Pruning** method to improve its efficiency , whenever there will be any shorter word present in the input than that of the longest and second longest compounded words , then we will break the loop of iteration 

Used iteration over recursion to make it more efficient.

Trie method was available on internet and i didnt use that method to provide a new solution to this problem .

It is very easy to understand and implement as this code simply just takes the input and put it in HashSet for finding the prefixes and then using two methods we can eaisly get the longest and second longest compounded words.

Overall complexity of this code is about O(N*logN).
