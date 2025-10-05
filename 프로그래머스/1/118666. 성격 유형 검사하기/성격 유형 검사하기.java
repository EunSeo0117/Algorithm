import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] p = {0, 3, 2, 1, 0, 1, 2, 3};
        
        Map<String, Integer> s = new HashMap<>();
        s.put("R", 0);
        s.put("T", 0);
        s.put("C", 0);
        s.put("F", 0);
        s.put("J", 0);
        s.put("M", 0);
        s.put("A", 0);
        s.put("N", 0);
        
        for (int i=0; i<survey.length; i++) {
            
            String s1 = survey[i].substring(0,1);
            String s2 = survey[i].substring(1,2);
            
            if (choices[i] <= 3) {
                Integer tmp = s.get(s1);
                s.put(s1, tmp+p[choices[i]]);
            } else if (choices[i] == 4) { 
                continue;
            } else {
                Integer tmp = s.get(s2);
                s.put(s2, tmp+p[choices[i]]);
            }
        }
        
        Integer r = s.get("R");
        Integer t = s.get("T");
        if (r>t) answer += "R";
        else if (r==t) answer += "R";
        else answer +="T";
        
        Integer c = s.get("C");
        Integer f = s.get("F");
        if (c>f) answer += "C";
        else if (c==f) answer += "C";
        else answer +="F";
        
        Integer j = s.get("J");
        Integer m = s.get("M");
        if (j>m) answer += "J";
        else if (j==m) answer += "J";
        else answer +="M";
        
        Integer a = s.get("A");
        Integer n = s.get("N");
        if (a>n) answer += "A";
        else if (a==n) answer += "A";
        else answer +="N";
        
        
        return answer;
    }
}