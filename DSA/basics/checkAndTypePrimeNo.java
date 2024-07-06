package basics;

public class checkAndTypePrimeNo {

    public static void main(String[] args) {
        int start = 5;
        int end = 10;
        int num = 8;
        checkSinglePrime(num);
        checkMultiPrime(start,end);
        displayCountPrimeNo(start, end);
    }

    private static void displayCountPrimeNo(int start, int end) {
        int countPrimeNo = countPrimesInRange(start, end);
        System.out.println(countPrimeNo);
    }

    private static int countPrimesInRange(int start, int end) {
        int count = 0;
        for(int i = start; i<=end; i++){
            boolean isPrime = checkPrimeNo(i);
            if(isPrime){
                count++;
            }
        }
        return count;
    }

    private static void checkMultiPrime(int start, int end) {
        for (int i = start; i<=end; i++){
            checkSinglePrime(i);
        }
    }

    private static void checkSinglePrime(int x) {
        boolean num =checkPrimeNo(x);
        if(num==true){
            System.out.println(x+ " is prime no.");
        }else{
            System.out.println(x +" is not prime no.");
        }
    }

    public static boolean checkPrimeNo(int n){
        int countFactor = 0;
        for(int i=1; i<=n; i++){
            if(n%i == 0){
                countFactor++;
            }
        }
        if(countFactor == 2) {
            return true;
        }else{
            return false;
        }
    }
}
