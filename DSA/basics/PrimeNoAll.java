package basics;

import static basics.PrimeNo1.displayPrimeInfo;
import static basics.PrimeNo1.isPrime2;

public class PrimeNoAll {
    public static void main(String[] args) {
        int x =6;
        for(int j=0; j<=x; j++){
            boolean resp = isPrime2(j);
            displayPrimeInfo(j, resp);
        }
    }
}
