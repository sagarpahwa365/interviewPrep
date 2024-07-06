package basics;

public class SumOfNaturalNumberV2 {
    public static void main(String[] args) {
        int start = 3;
        int end = 5;
        // displayRangeSum(start, end);
        // displaySum(end);
    }

    public static int sumNaturalNoInRangeV2(int start, int end){
        int sumBefore = sumNaturalNoV2(start - 1);
        int overallSum = sumNaturalNoV2(end);
        return overallSum - sumBefore;
    }

    public static int sumNaturalNoV2(int num){
        return (num * (num + 1)) / 2;
    }
}
