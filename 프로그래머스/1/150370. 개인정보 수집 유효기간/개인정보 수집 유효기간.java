import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        Map<String, Integer> t = new HashMap<>();
        for (String term : terms) {
            String [] a = term.split(" ");
            t.put(a[0], Integer.parseInt(a[1]));
        }
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate ltoday = LocalDate.parse(today, fmt);
        List<Integer> as = new ArrayList<>();
        for (int i=0; i<privacies.length; i++) {
            String[] a = privacies[i].split(" ");
            LocalDate day = LocalDate.parse(a[0], fmt);
            
            int length = t.get(a[1]);
            day = day.plusMonths(length);
            System.out.println(day);
            if (day.isBefore(ltoday) || day.equals(ltoday)) {
                as.add(i+1);
                
            }
        }
        
        answer = as.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}