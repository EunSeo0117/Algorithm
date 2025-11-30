import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;

public class Main {


    static class Customer {
        int id;
        long remain;

        Customer(int id, long remain) {
            this.id = id;
            this.remain = remain;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 초기고객
        Queue<Customer> q = new LinkedList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            long tx = Long.parseLong(st.nextToken());
            q.add(new Customer(P, tx));
        }

        // 이후 입장
        int M = Integer.parseInt(br.readLine());

        List<List<Customer>> arrive = new ArrayList<>();
        for (int i=0; i<W; i++) {
            arrive.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            long tx = Long.parseLong(st.nextToken());
            int cx = Integer.parseInt(st.nextToken());

            // w 이후는 필요없음
            if (cx < W) {
                arrive.get(cx).add(new Customer(id,tx));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        Customer co = null;
        int time =0;
        for (int i=0; i<W; i++) {
            for (Customer c : arrive.get(i)) {
                q.add(c);
            }
            
            if (i > 0 && co !=null) {
                if (co.remain == 0) {
                    co = null;
                    time = 0;
                } else if (time == T) {
                    q.add(co);
                    co = null;
                    time = 0;
                }
            }
            
            if (co == null) {
                co = q.poll();
                time = 0;
            }

            sb.append(co.id).append('\n');
            co.remain--;
            time++;
        }
        System.out.println(sb);
    }


}