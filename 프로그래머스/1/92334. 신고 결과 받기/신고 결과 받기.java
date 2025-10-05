import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        answer = new int[id_list.length];
        
        // 멤버추출
        Map<String, Integer> member = new HashMap<>();
        for (int i=0; i<id_list.length; i++) {
            member.put(id_list[i], i);
        }
        
        // 중복제거
        int length = id_list.length;
        Set<String> reports = new HashSet<>(Arrays.asList(report));
        report = reports.toArray(new String[0]);
        
        
        int[][] map = new int[length][length];
        int[] repoCount = new int[length];
        
        for (int i=0; i<report.length; i++) {
            
            String[] p = report[i].split(" "); 
            String sfrom = p[0];
            String sto = p[1];
        
            Integer from = member.get(sfrom);
            Integer to = member.get(sto);
            
            map[from][to]+=1;
            repoCount[to]+=1;
        }
             
        
        // 신고제한 넘은사람 선정
        for (int i=0; i<id_list.length; i++) {
            if (repoCount[i] >= k) {
                for (int j=0; j<id_list.length; j++) {
                    if (map[j][i]>=1) answer[j]+=1;
                }
                
            }
        }
        
        return answer;
        
    }
}