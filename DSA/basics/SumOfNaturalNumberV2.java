package basics;

import java.math.BigInteger;

public class SumOfNaturalNumberV2 {
    public static void main(String[] args) {
        int start = 5;
        int end = 10;
        long num = 9223372036854775807l;
        BigInteger sum = sumNaturalNoV2(num);
        System.out.println(sum);
        // long sumRange = sumNaturalNoInRangeV2(start, end);
        // System.out.println(sumRange);
    }

    public static BigInteger sumNaturalNoInRangeV2(long start, long end){
        BigInteger sumBefore = sumNaturalNoV2(start - 1);
        // System.out.println(sumBefore);
        BigInteger overallSum = sumNaturalNoV2(end);
        // System.out.println(overallSum);
        return overallSum.subtract(sumBefore);
    }

    public static BigInteger sumNaturalNoV2(long num){
        BigInteger bigNum = BigInteger.valueOf(num);
        return bigNum.multiply(bigNum.add(BigInteger.ONE)).divide(BigInteger.TWO);
    }
}
