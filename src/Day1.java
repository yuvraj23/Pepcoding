public class Day1 {
    public static void main(String[] args) {

    }

    public static void findFactorail(int n){
        int ans=1;
        for(int i=n;i>0;i--){
            ans*=i;
        }
        System.out.println(ans);
    }

    public static void fibo(int startPoint,int endpoint){
        int a=0,b=1,c=0;

        for(int i=startPoint;i<endpoint;i++){
            System.out.println(a);
            c=a+b;
            a=b;
            b=c;
        }
    }

    public static void getAllPrime(int startPoint, int endPoint){
        for(int i=startPoint;i<endPoint;i++){
            boolean found=false;
            for(int j=2;j*j<=i;j++){
                if(i%j==0){
                    found=true;
                    break;
                }
            }

            if(!found){
                System.out.println(i);
            }
        }
    }
}
