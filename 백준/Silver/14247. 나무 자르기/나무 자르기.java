import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Tree {
        int height;
        int grow;

        Tree(int height, int grow) {
            this.height = height;
            this.grow = grow;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc =  new Scanner(System.in);

        int n = sc.nextInt();

        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        int[] grow = new int[n];
        for (int i = 0; i < n; i++) {
            grow[i] = sc.nextInt();
        }

        Tree[] arr = new Tree[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Tree(tree[i], grow[i]);
        }

        Arrays.sort(arr, (a, b) -> a.grow - b.grow);

        long answer = 0;

        for (int i = 0; i < n; i++) {
            answer += arr[i].height + (long) arr[i].grow * i;
        }

        System.out.println(answer);


    }

}
