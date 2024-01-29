
### 1. SENTENCE REVERSE
    Sentence Reverse
    You are given an array of characters arr that consists of sequences of characters separated by space characters. Each space-delimited sequence of characters defines a word.

    Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.

    Explain your solution and analyze its time and space complexities.

    Example:

    input:  arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ',
                    'm', 'a', 'k', 'e', 's', '  ',
                    'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]

    output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ',
            'm', 'a', 'k', 'e', 's', '  ',
            'p', 'e', 'r', 'f', 'e', 'c', 't' ]

### 2. ways to decode 
    num to abc...

### 3. sortKMessedArray
    import java.io.*;
    import java.util.PriorityQueue;

    class Solution {
    // (k+n)logk
    static int[] sortKMessedArray(int[] arr, int k) {
        // your code goes here
        int n = arr.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(int i = 0; i <= k; i++){
        minHeap.offer(arr[i]);
        }
        
        int idx = 0;
        
        for(int i = k+1; i < n; i++){
        arr[idx] = minHeap.poll();
        idx++;
        minHeap.offer(arr[i]);
        }
        
        while(!minHeap.isEmpty()){
        arr[idx++] = minHeap.poll();
        }
        
        return arr;
    }
    public static void main(String[] args) {
    }
    }

QUESTION
### 4. Array Quadruplet
    Given an unsorted array of integers arr and a number s, write a function findArrayQuadruplet that finds four numbers (quadruplet) in arr that sum up to s. Your function should return an array of these numbers in an ascending order. If such a quadruplet doesn’t exist, return an empty array.
    Note that there may be more than one quadruplet in arr whose sum is s. You’re asked to return the first one you encounter (considering the results are sorted).
    Explain and code the most efficient solution possible, and analyze its time and space complexities.
    Example:
    input:  arr = [2, 7, 4, 0, 9, 5, 1, 3], s = 20
    output: [0, 4, 7, 9] # The ordered quadruplet of (7, 4, 0, 9)
                        # whose sum is 20. Notice that there
                        # are two other quadruplets whose sum is 20:
                        # (7, 9, 1, 3) and (2, 4, 9, 5), but again you’re
                        # asked to return the just one quadruplet (in an
                        # ascending order)
### 5. Bracket Match
    import java.io.*;
    import java.util.*;
    class Solution {    
    static int bracketMatch(String text) {
        int openBrackets = 0;
        int extraClosedBrackets = 0;
        for(int i = 0; i < text.length(); i++){
        if(text.charAt(i) == '('){
            openBrackets++;
        }
        else{
            if(openBrackets > 0) openBrackets--;
            else extraClosedBrackets++;
        }
        }
        return openBrackets + extraClosedBrackets;
    }
    public static void main(String[] args) {
    }
    }

### 6. Buy Sell Stocks
    given daily price array:
    1. buy sell only 1 time
        maintain prev min and update min or profit for each element
    2. buy sell any number of times
        check for adjecent profits
    3. buy max k times
        dp 
        rows = day 1 to day n
        cols = 0 time to k times 
        dp[i][j] = max(
                dp[i][j-1] i.e. nothing today, 
                dp[i-1][m] + maxdiff
            )
            where maxdiff = max of (dp[i][k] - arr[k]) 
                and k in [0,j-1]
