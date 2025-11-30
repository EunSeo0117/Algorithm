import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Queue<String>> qList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] words = line.split("\\s+");
            Queue<String> q = new LinkedList<>();
            for (String word : words) {
                q.add(word);
            }
            qList.add(q);
        }

        String answer = "Possible";
        String line = br.readLine();
        String[] words = line.split("\\s+");
        for (String w : words) {
            boolean found = false;
            for (int i=0; i<n; i++) {
                if (!qList.get(i).isEmpty() && qList.get(i).peek().equals(w)) {
                    qList.get(i).remove();
                    found = true;
                    break;
                }
            }

            if (!found) {
                answer = "Impossible";
                break;
            }
        }

        for (Queue<String> q : qList) {
            if (!q.isEmpty()) {
                answer = "Impossible";
                break;
            }
        }


        System.out.println(answer);



    }
}