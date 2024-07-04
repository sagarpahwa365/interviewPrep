//import java.io.*;
//import java.util.*;
//
//class TimePlanner {
//
//  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
//    // your code goes here
//    // max(s1,s2)+d <= min(e1,e2)
//    int a = 0;
//    int b = 0;
//    int lenA = slotsA.length;
//    int lenB = slotsB.length;
//    while(a < lenA && b < lenB){
//      int startA = slotsA[a][0];
//      int endA = slotsA[a][1];
//      int startB = slotsB[b][0];
//      int endB = slotsB[b][1];
//      int start = Math.max(startA, startB);
//      if ( start + dur <= Math.min(endA, endB) ){
//        return new int[]{start, start+ dur};
//      }
//      if(endA < endB){
//        a++;
//      }else{
//        b++;
//      }
//    }
//    return new int[]{};
//  }
//
//  public static void main(String[] args) {
//      int[][] slotsA = new int[][]{ new int[] {10, 50}, new int[] {60, 120}};
//      int[][] stotsB = new int[][]{ new int[] {0, 15}, new int[] {60, 70}};
//      int dur = 8;
//      int[] opt = meetingPlanner(slotsA, slotsB, dur);
//      System.out.println(opt);
//  }
//
//}
//
///**
//    input:
//    slotsA = [[10, 50], [60, 120], [140, 210]]
//    slotsB = [[0, 15], [60, 70]]
//    dur = 8
//
//    a = 0
//    b = 0
//
//    1. does intervals overlap for at least d duration
//        start = max(a_start, b_start)
//        => return ans   [  start, d+start]
//    2. if not =>
//        increase the ptr for the one with smaller ending
//
//
//    a = 0
//    b = 1
//
//    a = 1
//    b = 1
//
//
//    does intervals overlap for at least d duration
//
//            -----------------------
//
//    -----                            ------- // no overlap => false
//    e1 < s2 || s1 > e2
//        --------- // has overlap
//
//        max(s1,s2)+d <= min(e1,e2)
//                    ---------
//                                -------------
//
//
//    output: [60, 68]
//**/