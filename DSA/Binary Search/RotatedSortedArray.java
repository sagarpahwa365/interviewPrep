/**
 * Problem Description
Given a sorted array of integers A of size N and an integer B, 
where array A is rotated at some pivot unknown beforehand.

For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].

Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.

You can assume that no duplicates exist in the array.

NOTE: You are expected to solve this problem with a time complexity of O(log(N)).


Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 109
All elements in A are Distinct.


Input Format
The First argument given is the integer array A.
The Second argument given is the integer B.


Output Format
Return index of B in array A, otherwise return -1


Example Input
Input 1:

A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4 
Input 2:

A : [ 9, 10, 3, 5, 6, 8 ]
B : 5


Example Output
Output 1:

 0 
Output 2:

 3
 */
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int getPivot(List<Integer> a){
        int min = 0;
        int size = a.size();
        int max = size - 1;
        int mid = min + ((max - min) / 2);
        int pivot = -1;
        int firstElement = a.get(0);
        int lastElement = a.get(size-1);
        // System.out.println("min="+min+" max="+max+" mid="+mid+" e="+a.get(mid)+" pivot="+pivot);
        while(min <= max){
            // mid is smaller than min
            if(a.get(mid) < firstElement){
                // next half of sorted array could be mining at mid
                pivot = mid;
                max = mid - 1;
            }
            // mid is greater than max 
            else if(a.get(mid) > lastElement){
                // next half of sorted array could be mining at mid+1
                pivot = mid + 1;
                min = mid + 1;
            }
            else return pivot;
            mid = min + ((max - min) / 2);
            // System.out.println("min="+min+" max="+max+" mid="+mid+" e="+a.get(mid)+" pivot="+pivot);
        }
        return pivot;
    }
    public int search(final List<Integer> a, int target) {
        int max = a.size()-1;
        if(max == 0){
            return a.get(0) == target ? 0 : -1;
        }
        int pivot = getPivot(a);
        // System.out.println(pivot);
        if(pivot == -1){
            return binarySearch(a, 0, max, target);
        }
        else{
            int res = binarySearch(a, 0, pivot-1, target);
            // System.out.println(res);
            if(res != -1) return res;
            res = binarySearch(a, pivot, max, target);
            return res;
        }
    }
    public int binarySearch(List<Integer> a, int min, int max, int target){
        int mid = min + ((max - min) / 2);
        while(min <= max){
            if(a.get(mid) == target){
                return mid;
            }
            if(a.get(mid) < target){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
            mid = min + ((max - min) / 2);
        }
        return -1;
    }
}
