package basics;

public class SquareRootOfNumber {
    public static void main(String[] args) {
        displayValue(169);

    }

    public static void displayValue(int n){
        int x = squareRoot(n);
        if(x == n){
            System.out.println(Math.sqrt(n));
        } else{
            System.out.println("-1");
        }
    }


    public static int squareRoot(int n){
        int mul =1;
        for(int i=1; i<n; i++){
            if(i*i == n){
                mul = i*i;
            }
        }
        if(mul==n){
            return n;
        }else{
            return -1;
        }
    }

}
