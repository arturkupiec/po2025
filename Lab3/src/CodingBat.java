import java.util.HashMap;
import java.util.Map;
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

    public int factorial(int n) {
        int wynik = 1;
        if (n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }

    public boolean scoresIncreasing(int[] scores) {
        boolean is_increasing = true;
        for (int i = 0; i < (scores.length-1); i++){
            if (scores[i+1] < scores[i]){
                is_increasing = false;
                break;
            }
        }return is_increasing;
    }

    public Map<String, String> mapBully(Map<String, String> map) {
        if (map.containsKey("a")){
            map.put("b", map.get("a"));
            map.put("a", "");
        }return map;
    }

    public int luckySum(int a, int b, int c) {
        if(a!=13){
            if(b!=13){
                if (c!=13){
                    return a+b+c;
                }else{
                    return a+b;
                }
            }else{
                return a;
            }
        }else{
            return 0;
        }
    }




    public static void main(String[] args) {
    }
}
