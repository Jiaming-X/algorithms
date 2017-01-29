package Palantir;

import java.util.*;

public class CatchingInsiderTrader {
    class Transaction implements Comparable<Transaction>{
        int day;
        boolean buy;
        String name;
        int amount;
        
        public Transaction(int day, boolean buy, String name, int amount) {
            this.day = day;
            this.buy = buy;
            this.name = name;
            this.amount = amount;
        }
        
        @Override
        public int compareTo(Transaction t2) {
            if (this.day == t2.day) {
                return this.name.compareTo(t2.name);
            } else {
                return this.day - t2.day;
            }
        }
    }
    Map<Integer, Integer> priceMap = new HashMap<Integer, Integer>();
    SortedMap<Integer, SortedSet<Transaction>> transactionMap = new TreeMap<Integer, SortedSet<Transaction>>();
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] data = new String[]{
                "1|700", "2|10000","3|50","4|700", "5|10","8|50000","1|Bob|BUY|30000", "1|Alan|BUY|20000"
                ,"2|tob|BUY|30000", "3|Ann|BUY|20000","5|Bb|BUY|30000", "4|Aggn|BUY|20000"};
        
        CatchingInsiderTrader cs = new CatchingInsiderTrader();
        System.out.println(cs.catchInsider(data));
    }
    
    public void initData(String[] data) {
        for (int i = 0; i < data.length; i++) {
            if (i > 0 && data[i - 1].equals(data[i])) {
                continue;
            }
            String[] tokens = data[i].split("\\|");
            
            if (tokens.length == 2) {
                int day = Integer.parseInt(tokens[0]);
                int price = Integer.parseInt(tokens[1]);
                this.priceMap.put(day, price);
            } else {
                int day = Integer.parseInt(tokens[0]);
                boolean buy = tokens[2].equals("BUY");
                String name = tokens[1];
                int amount = Integer.parseInt(tokens[3]);
                
                if (!this.transactionMap.containsKey(day)) {
                    this.transactionMap.put(day, new TreeSet<Transaction>());
                }
                this.transactionMap.get(day).add(new Transaction(day, buy, name, amount));
            }
        }
    }
    
    public List<String> catchInsider(String[] data) {
        List<String> result = new ArrayList<String>();
        initData(data);
        
        System.out.println();
        for (Integer key : transactionMap.keySet()) {
            System.out.println(key);
            
            SortedSet<Transaction> trans = this.transactionMap.get(key);
            for (Transaction tran : trans) {
                int currentAmount = tran.amount * priceMap.get(key);
                if (tran.buy) {
                    for (int i = 0; i < 3; i++) {
                        if (priceMap.get(tran.day + i) != null) {
                            int diff = tran.amount * priceMap.get(key + i) - currentAmount;
                            if (diff >= 5000000) {
                                result.add(tran.name);
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < 3; i++) {
                        if (priceMap.get(tran.day - i) != null) {
                            int diff = tran.amount * priceMap.get(key - i) - currentAmount;
                            if (diff >= 5000000) {
                                result.add(tran.name);
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }

}
