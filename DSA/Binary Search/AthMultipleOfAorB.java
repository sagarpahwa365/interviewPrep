/**
 * Problem Description
You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Note: Ensure to prevent integer overflow while calculating.



Problem Constraints
1 <= A <= 109

2 <= B, C <= 40000



Input Format
The first argument given is an integer A.

The second argument given is an integer B.

The third argument given is an integer C.



Output Format
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.



Example Input
Input 1:

 A = 1
 B = 2
 C = 3
Input 2:

 A = 4
 B = 2
 C = 3


Example Output
Output 1:

 2
Output 2:

 6
 */
public class Solution {
    public int getGCD(int a, int b){
        if(a < b) return getGCD(b, a);
        if(a % b == 0) return b;
        return getGCD(a % b, b);
    }
    public int solve(int n, int a, int b) {
        int gcd = getGCD(a, b);
        long lcm = (long) ((a * b) / gcd);
        int minAB = Math.min(a, b);
        long ans = (long) n * minAB;
        long min = (long) minAB;
        long max = (long) n * minAB;
        long mid = min + ((max - min) / 2);
        // System.out.println("gcd="+gcd+" lcm="+lcm+" min="+min+" max="+max);
        while(min <= max){
            long multiplesOfA = mid/a;
            long multiplesOfB = mid/b;
            long multiplesOfAB = mid/lcm;
            if(multiplesOfA + multiplesOfB - multiplesOfAB >= n){
                ans = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
            mid = min + ((max - min) / 2);
            // System.out.println("min="+min+" max="+max+" mid="+mid+" ans="+ans);
        }
        return (int) (ans % 1000000007) ;
    }
}
