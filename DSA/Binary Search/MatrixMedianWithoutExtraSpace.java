/**
 * Problem Description
Given a matrix of integers A of size N x M in which each row is sorted.

Find and return the overall median of matrix A.

NOTE: No extra memory is allowed.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 10^5

1 <= N*M <= 10^6

1 <= A[i] <= 10^9

N*M is odd



Input Format
The first and only argument given is the integer matrix A.



Output Format
Return the overall median of matrix A.



Example Input
Input 1:

A = [   [1, 3, 5],
        [2, 6, 9],
        [3, 6, 9]   ] 
Input 2:

A = [   [5, 17, 100]    ]


Example Output
Output 1:

 5 
Output 2:

 17


Example Explanation
Explanation 1:

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
Median is 5. So, we return 5. 
Explanation 2:

Median is 17.

 */
public class Solution {
    public int findLowerBound(ArrayList<Integer> l, int num){
        int min = 0;
        int max = l.size() - 1;
        // no element less than num => -1 +1 = 0. (will do calculation on 0 index based and will return ans + 1)
        int ans = -1;
        int mid = min + ((max - min) / 2);
        while(min <= max){
            if(l.get(mid) > num){
                max = mid-1;
            }else{
                ans = mid;
                min = mid+1;
            }
            mid = min + ((max - min) / 2);
        }
        return ans + 1;
    }

    public int findMedian(ArrayList<ArrayList<Integer>> l) {
        int min = 0;
        int max = 1000000000;
        int mid = min + ((max - min) / 2);
        int ans = min;
        int n = l.size();
        int m = l.get(0).size();
        int target = (n * m) / 2;
        while(min <= max){
            int cur = 0;
            for(int i=0; i<n; i++){
                cur += findLowerBound(l.get(i), mid);
            }
            if(cur > target){
                ans = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
            mid = min + ((max - min) / 2);
        }
        return ans;
    }
}
