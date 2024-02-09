/**
 * Problem Description
You are given an array A. You need to find the length of the Longest Increasing Subsequence in the array.

In other words, you need to find a subsequence of array A in which the elements are in sorted order, (strictly increasing) and as long as possible.



Problem Constraints
1 ≤ length(A), A[i] ≤ 105



Input Format
The first and only argument of the input is the array A.



Output Format
Output a single integer, the length of the longest increasing subsequence in array A.



Example Input
Input 1:

A: [2, 1, 4, 3]
Input 2:

A: [5, 6, 3, 7, 9]


Example Output
Output 1:

2
Output 2:

4

 */
public class Solution {

    public int getLB(List<Integer> l, int num){
        int min = 0;
        int max = l.size();
        int mid = min + ((max - min) / 2);
        int ans = 0;
        while(min <= max){
            if(l.get(mid) < num){
                ans = mid;
                min = mid + 1;
            }else{
                max = mid - 1;
            }
            mid = min + ((max - min) / 2);
        }
        // System.out.println(l);
        return ans;
    }

    public int findLIS(ArrayList<Integer> l) {
        int s = l.size();
        List<Integer> lb = new ArrayList<Integer>(Collections.nCopies(s+1, Integer.MAX_VALUE));
        lb.set(0, Integer.MIN_VALUE);
        for(int i = 0; i < s; i++){
            // this will give the index/length of longest subsequence that can end on ith element
            int curLB = l.get(i);
            int maxLenWithCurELement = getLB(lb, curLB)+1;
            // we get the existing element to end subsequence for same length and compare it with cur element.
            int prevLB = lb.get(maxLenWithCurELement);
            lb.set(maxLenWithCurELement, Math.min(curLB, prevLB));
        }
        for(int i = 0; i <= s; i++){
            if(lb.get(i) == Integer.MAX_VALUE) return i-1;
        }
        return 1;
    }
}
