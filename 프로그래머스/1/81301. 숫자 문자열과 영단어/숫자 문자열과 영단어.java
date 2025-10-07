import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Map<Integer, String> num = new HashMap<>();
        num.put(0, "zero");
        num.put(1, "one");
        num.put(2, "two");
        num.put(3, "three");
        num.put(4, "four");
        num.put(5, "five");
        num.put(6, "six");
        num.put(7, "seven");
        num.put(8, "eight");
        num.put(9, "nine");
        
        String res = "";
        int s_size = s.length();
        for (int i=0; i<s_size; i++) {
            //System.out.println("index: " +i);
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                res += s.charAt(i);
                //System.out.println("add: " +s.charAt(i));
                continue;
            }
            
            for (int j=0; j<10; j++) {
                String n =  num.get(j);
                int n_size = n.length();
                if (s_size < i+n_size) {
                    //System.out.println("stop"+ i+n_size +"is over than "+ s_size);
                    continue;
                }
                String tmp = s.substring(i, i+n_size);
                
                if (n.equals(tmp)) {
                    //System.out.println("add " + j);
                    res += j;
                    i+=n_size-1;
                    break;
                }
                
                
            }
        }
        answer = Integer.parseInt(res);
        return answer;
    }
}