package basics;

import static basics.PrimeNo1.isPrime2;

public class PrimeNoCounter {
    public static void main(String[] args) {
        int n =10;
        countPrimeNumbers(n);
    }

    private static void countPrimeNumbers(int n) {
        int totalPrimeNo = 0;
        for(int i = 1; i<= n; i++){
            totalPrimeNo += isPrime2(i) ? 1:0;
        }
        System.out.println(totalPrimeNo);
    }
}
