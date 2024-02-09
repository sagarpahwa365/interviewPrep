/**
 * Problem Description
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

NOTE:

It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.


Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100

 */
public class Solution {
    public int solve(ArrayList<Integer> l) {
        // we will rule out
        int min = 1;
        int max = l.size() - 1;
        if(max == 0) return l.get(0);
        if(l.get(0) > l.get(1)) return l.get(0);
        if(l.get(max) > l.get(max-1)) return l.get(max);
        int mid = min + ((max - min) / 2);
        while(min <= max){
            int cur = l.get(mid);
            int prev = l.get(mid-1);
            int next = l.get(mid+1);
            if(cur >= prev && cur >= next) return cur;
            if(cur >= prev && next >= cur){
                // we are going up
                min = mid + 1;
            }else if(prev >= cur && cur >= next){
                // we are going down
                max = mid - 1;
            }
            mid = min + ((max - min) / 2);
        }
        return -1;
    }
}
