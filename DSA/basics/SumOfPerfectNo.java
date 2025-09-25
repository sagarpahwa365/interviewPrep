package basics;

import java.util.List;

public class SumOfPerfectNo {
    public static void main(String[] args) {
        checkSingleInput(8);
        List<Integer> nums = List.of(6,8,10);
        checkMultipleInput(nums);
    }

    private static void checkMultipleInput(List<Integer> nums) {
        for(int i=0; i<nums.size(); i++){
            checkSingleInput(nums.get(i));
        }
    }

    private static void checkSingleInput(int n) {
        int x = sumOfDivisor(n);
        System.out.println(x);
    }
    public static int sumOfDivisor(int n ){
        int sum =0;
        for(int i=1; i<n; i++){
            if(n%i==0){
                sum=sum+i;
            }
        }
        return sum;
    }
}
