import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Integer> f = new HashMap<>();
        for (int i=0; i< friends.length;i++) {
            f.put(friends[i], i);
        }
        
        int[] record = new int[f.size()];
        int[][] board = new int[f.size()][f.size()];
        
        for (String gift : gifts) {
            String[] temp = gift.split(" ");
            int giver = f.get(temp[0]);
            int taker = f.get(temp[1]);
            board[giver][taker]+=1;
            record[giver]+=1;
            record[taker]-=1;
        }
        
        int[] giftCount = new int[f.size()];
        for (int i=0; i<f.size(); i++) {
            for (int j=0; j<f.size(); j++) {
                if (i==j) continue;
                int atob = board[i][j];
                int btoa = board[j][i];
                if (atob > btoa) {
                    giftCount[i] +=1;
                } else if (atob < btoa) {
                    giftCount[j] +=1;
                } else {
                    if (record[i] > record[j]) {
                        giftCount[i]+=1;
                    } else if (record[j] > record[i]) {
                        giftCount[j] +=1;
                    } else {
                        continue;
                    }
                }
            }
        }
        answer = Arrays.stream(giftCount).max().getAsInt();
        return answer/2;
    }
}