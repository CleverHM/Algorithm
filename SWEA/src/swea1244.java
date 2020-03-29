
import java.util.Scanner;
 
public class swea1244 {
    static char[] inp;
    static int swp;
    static int MAX;
    static boolean[] check;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트케이스 숫자.
 
        for (int i = 1; i <= T; i++) {
            MAX = -1;
            inp = sc.next().toCharArray();// 숫자를 배열로 바꾸어 저장.
            swp = sc.nextInt(); // 스왑 횟수.
            check = new boolean[1000000];
            go(0);
            System.out.println("#" + i + " " + MAX);
        }
 
    }
 
    static void go(int cnt) {
        if (cnt == swp) {
             
            if(MAX < charToInt(inp)) {
                MAX = charToInt(inp);
            }
             
            return;
        }
         
        if(check[charToInt(inp)] == true) {
             
            return;
        }
         
        check[charToInt(inp)] = true;
         
 
        for (int i = 0; i < inp.length - 1; i++) {
            for (int j = i + 1; j < inp.length; j++) {
                swap(i, j);
                go(cnt + 1);
                swap(j, i);
            }
        }
    }
 
    static void swap(int i, int j) {
        char temp;
        temp = inp[i];
        inp[i] = inp[j];
        inp[j] = temp;
    }
     
    static int charToInt(char[] arr) {
        int result = 0;
        String str = String.valueOf(arr);
        result = Integer.parseInt(str);
        return result;
    }
}