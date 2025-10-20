public class CodingBat {

    public int close10(int a, int b) {
        if (Math.abs(10-a)<Math.abs(10-b)){
            return a;
        }else if(Math.abs(10-a)==Math.abs(10-b)){
            return 0;
        }else{
            return b;
        }
    }

    public boolean in3050(int a, int b) {
        return( a<= 40 && a>=30 && b<=40 && b>=30 || a>=40 && a<= 50 && b<=50 && b>=40);
    }


    public static void main(String[] args) {
    }
}
