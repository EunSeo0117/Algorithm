import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();

        int num = 0;
        for (int i=0; i<binary.length(); i++) {
            int tmp = binary.charAt(i) - '0';
            num = num * 2 + tmp;
        }

        System.out.println(num);
    }
}