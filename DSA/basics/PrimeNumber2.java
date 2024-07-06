package basics;

import java.util.Scanner;

public class PrimeNumber2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the no.- ");
        int x = sc.nextInt();

        for(int n=1; n<=x; n++){
            int c = 0;
            for(int j=1; j<=n; j++){
                if(n%j == 0){
                    c++;
                }
            }
            if(c==1){
                System.out.println(n+" is not Prime Number neither composite number");
            }else if(c==2){
                System.out.println(n+" is Prime Number");
            }else{
                System.out.println(n+" is Composite Number");
            }
        }

    }
}
