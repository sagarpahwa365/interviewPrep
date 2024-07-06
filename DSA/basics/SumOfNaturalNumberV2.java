package basics;

public class SumOfNaturalNumberV2 {
    public static void main(String[] args) {
        int start = 3;
        int end = 5;
        displayRangeSum(start, end);
        displaySum(end);
    }

    private static void displaySum(int end) {
        int sumTillEnd = sumNaturalNoTillEnd(end);
        System.out.println("Sum of first n natural no. is " + sumTillEnd);
    }

    public static void displayRangeSum(int start, int end){
        int sums = sumNaturalNoInRange(start, end);
        System.out.println("Sum of " +start+ " to " +end+ " natural no. is " +sums);
    }

    public static int sumNaturalNoTillEnd(int end){
        return sumNaturalNoInRange(1, end);
    }

    public static int sumNaturalNoInRange(int start, int end){
        int sum = 0;
        for(int i=start; i<=end; i++){
            sum = sum+i;
        }
        return sum;
    }
}
