package basics;

public class PrimeNo1 {
    public static void checkPrimeDisplay(int n){
        int c=0;
        for(int i=1; i<=n; i++){
            if(n%i==0){
                c++;
            }
        }
        if(c==1){
            System.out.println(n+ "is Natural No.");
        }else if (c==2) {
            System.out.println(n+ "is Prime No.");
        }else{
            System.out.println(n+ "is Composite No.");
        }
    }

    public static boolean isPrime2(int n){
        int c=0;
        for(int i=1; i<=n; i++){
            if(n%i==0){
                c++;
            }
        }
        if(c==1){
            return false;
        }else if (c==2) {
            return true;
        }else{
            return false;
        }
    }

    public static void displayPrimeInfo(int n, boolean isPrime){
        String type = isPrime ? "prime" : "composite";
        System.out.println("Number " + n + " is " + type);
    }
}


