/**
 * Problem Description
Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?



Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return the largest minimum distance possible among the cows.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
Explanation 2:

 The minimum distance will be 1.
 */
public class Solution {
    public boolean checkDistance(ArrayList<Integer> stalls, int cows, int dist){
        // 1 cow is assigned 
        int cowsAssigned = 1;
        // to stall at index 0
        int stallsConsumed = 1;
        int lastAssignedStallPosition = stalls.get(0);
        // totalStalls also denotes the next stall to consume
        int totalStalls = stalls.size();
        while(cowsAssigned < cows && stallsConsumed < totalStalls){
            int currentStallPosition = stalls.get(stallsConsumed);
            if(currentStallPosition - lastAssignedStallPosition >= dist ){
                // assign the slot
                cowsAssigned += 1;
                lastAssignedStallPosition = currentStallPosition;
            }else{
                // move on to next slot and check if min dist is achieved
            }
            stallsConsumed += 1;
        }
        // System.out.println("dist="+dist+" cowsAssigned="+cowsAssigned+" cows="+cows);
        return cowsAssigned >= cows;
    }
    public int solve(ArrayList<Integer> stalls, int cows) {
        //first we need to sort the stalls as per their position
        Collections.sort(stalls);
        // minimum dist b/w any 2 cows = 1, max dist = lastStallPosition - firstStallPosition
        int minDist = 1;
        int maxDist = stalls.get(stalls.size()-1) - stalls.get(0);
        int midDist = minDist + ((maxDist - minDist) / 2);
        int ans = minDist;
        while(minDist <= maxDist){
            if(checkDistance(stalls, cows, midDist)){
                ans = midDist;
                minDist = midDist+1; 
            }else{
                maxDist = midDist-1;
            }
            midDist = minDist + ((maxDist - minDist) / 2);
        }
        return ans;
    }
}
