/**
 * Problem Description
Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.



Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the maximum value of K (sub array length).



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 10
Input 2:

A = [5, 17, 100, 11]
B = 130


Example Output
Output 1:

 2
Output 2:

 3
 */

public class Solution {
    public boolean hasAllSubArraySumUnderLimit(ArrayList<Integer> l, int maxSum, int subLen){
        int len = l.size();
        // prepare 1st subarray sum
        int curSum = 0;
        for(int i = 0; i < subLen; i++){
            curSum += l.get(i);
            if(curSum > maxSum) return false;
        }
        // check rest all subarray sums
        for(int i = subLen; i < len; i++){
            curSum -= l.get(i-subLen);
            curSum += l.get(i);
            if(curSum > maxSum) return false;
        }
        return true;
    }

    public int solve(ArrayList<Integer> l, int maxSum) {
        int min = 0;
        int max = l.size();
        int mid = min + ((max - min) / 2);
        int ans = 0;
        while(min <= max){
            boolean possibleWithMidLen = hasAllSubArraySumUnderLimit(l, maxSum, mid);
            if(possibleWithMidLen){
                min = mid+1;
                ans = mid;
            } else {
                max = mid-1;
            }
            mid = min + ((max - min) / 2);
        }
        return ans;
    }
}
