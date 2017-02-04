package Z_airbnb;

import java.util.*;

public class host_pagination {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static List<List<String>> buildPages(ArrayList<String> input) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        
        int i = 0;
        LinkedList<String> queue = new LinkedList<>();
        while (i < input.size()) {
            ArrayList<String> page = new ArrayList<String>();
            HashSet<String> check = new HashSet<String>();
            LinkedList<String> repeatedHosts = new LinkedList<String>();
            
            while (page.size() < 12 && (i < input.size() && !queue.isEmpty())) {
                if (!queue.isEmpty()) {
                    String next = queue.pollFirst();
                    String host = next.split(",")[0];
                    
                    if (!check.contains(host)) {
                        page.add(next);
                        check.add(host);
                    } else {
                        repeatedHosts.offerLast(next);
                    }
                } else {
                    String next = input.get(i);
                    i++;
                    String host = next.split(",")[0];
                    
                    if (!check.contains(host)) {
                        page.add(next);
                        check.add(host);
                    } else {
                        repeatedHosts.offerLast(next);
                    }
                }
            }
            queue = repeatedHosts;
            result.add(page);
        }
        
        return result;
    }
}
