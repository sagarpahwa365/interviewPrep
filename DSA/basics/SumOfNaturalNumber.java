package basics;

import java.math.BigInteger;

public class SumOfNaturalNumber {
    public static void main(String[] args) {
//        int start = 3;
        long end = 7876655575575l;
//        long end = 2000000;
        BigInteger sum = sumNaturalNoTillEnd(end);
//        displayRangeSum(start, end);

        System.out.println(sum);
    }

    private static void displaySum(long end) {
        BigInteger sumTillEnd = sumNaturalNoTillEnd(end);
        System.out.println("Sum of first n natural no. is " + sumTillEnd);
    }

    public static void displayRangeSum(long start, long end){
        BigInteger sums = sumNaturalNoInRange(start, end);
        System.out.println("Sum of " +start+ " to " +end+ " natural no. is " +sums);
    }

    public static BigInteger sumNaturalNoTillEnd(long end){
        return sumNaturalNoInRange(1, end);
    }

    public static BigInteger sumNaturalNoInRange(long start, long end){
        BigInteger sum = BigInteger.valueOf(0);
        for(long i = start; i <= end; i++){
            if(i%10000000000l == 0) System.out.println("reached " + i);
            sum = sum.add(BigInteger.valueOf(i));
        }
        return sum;
    }
}
