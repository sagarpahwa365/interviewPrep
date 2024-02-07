/**
 * Problem Description
Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.

Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.



Problem Constraints
1 <= A <= 1000
1 <= B <= 106
1 <= N <= 105
1 <= C[i] <= 106



Input Format
The first argument given is the integer A.
The second argument given is the integer B.
The third argument given is the integer array C.



Output Format
Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.



Example Input
Input 1:

 A = 2
 B = 5
 C = [1, 10]
Input 2:

 A = 10
 B = 1
 C = [1, 8, 11, 3]


Example Output
Output 1:

 50
Output 2:

 11


Example Explanation
Explanation 1:

 Possibility 1:- One painter paints both blocks, time taken = 55 units.
 Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
 There are no other distinct ways to paint boards.
 ans = 50 % 10000003
Explanation 2:

 Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3 
 and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
 ans = 11 % 10000003

 */
public class Solution {
    public boolean canPaint(ArrayList<Integer> boards, int pntrCnt, long time){
        // at least 1 painter will be consumed
        int pntrConsumed = 1;
        // boardsPainted also denotes the index of next board to paing
        int boardsPainted = 0;
        long currentPaintersBandwidth = time;
        int boardCnt = boards.size();

        while(pntrConsumed <= pntrCnt && boardsPainted < boardCnt){
            int currentBoardSize = boards.get(boardsPainted);
            // System.out.println("boardsPainted="+boardsPainted+" pntrConsumed="+pntrConsumed+" currentPaintersBandwidth="+currentPaintersBandwidth);
            if(currentPaintersBandwidth - currentBoardSize >= 0 ){
                // if painter can paint, let him paint
                currentPaintersBandwidth -= currentBoardSize;
                boardsPainted += 1;
            }else{
                // move on to next painter
                pntrConsumed += 1;
                currentPaintersBandwidth = time;
            }
        }
        // System.out.println("before return, boardsPainted="+boardsPainted+" time="+time);
        return boardsPainted >= boardCnt; 
    }

    public int paint(int pntrCnt, int timePerUnit, ArrayList<Integer> boards) {
        // for simplicity, we assume the timePerUnit = 1 and multiply the ans by this factor before returning.
        int boardCnt = boards.size();
        // at max we can use boardCnt painters
        pntrCnt = Math.min(boardCnt, pntrCnt);
        // min time taken will be same as max board size
        long minTime = boards.get(0);
        // max time taken will be sum of all board sizes
        long maxTime = boards.get(0);
        for(int i = 1; i < boardCnt; i++){
            minTime = Math.max(boards.get(i), minTime);
            maxTime += boards.get(i);
        }
        // do binary search for answer between minTime and maxTime
        long midTime = minTime + ((maxTime - minTime) / 2); 
        long ans = maxTime;
        while(minTime <= maxTime) {
            boolean possibleAns = canPaint(boards, pntrCnt, midTime);
            // System.out.println("midTime=" + midTime + " ans=" + possibleAns);
            if(possibleAns){
                ans = midTime;
                maxTime = midTime - 1;
            }else{
                minTime = midTime + 1;
            }
            midTime = minTime + ((maxTime - minTime) / 2);
        }
        // System.out.println("midTime=" + midTime);
        return (int) ((ans * timePerUnit) % 10000003);
    }
}
