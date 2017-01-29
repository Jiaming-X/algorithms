package Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Connection {
    String city1;
    String city2;
    int cost;
    Connection (String city1, String city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
    }

    public void printConnection () {
            System.out.println("{ " + this.city1 + " , " + this.city2 + "} " + this.cost);
    }
}

public class MinimumSpanningTreeIII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Connection[] citys = new Connection[10];
        citys[0] = new Connection("A","B",6);
        citys[1] = new Connection("A","D",1);
        citys[2] = new Connection("A","E",5);
        citys[3] = new Connection("B","C",3);
        citys[4] = new Connection("B","D",5);
        citys[5] = new Connection("C","D",6);
        citys[6] = new Connection("C","F",6);
        citys[7] = new Connection("D","F",4);
        citys[8] = new Connection("D","E",5);
        citys[9] = new Connection("E","F",2);
        ArrayList<Connection> list = new ArrayList<Connection> ();
        for (Connection temp : citys) {
                list.add(temp);
        }

        for (Connection temp : findPath(list)){
                temp.printConnection();
        }
    }
    
    public static List<Connection> findPath (List<Connection> list) {
        Collections.sort(list, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                if (o1.cost == o2.cost) {
                    return 0;
                }
                return o1.cost < o2.cost ? -1 : 1;
            }
        });
        HashSet<String> set = new HashSet<String>();
        for (Connection con : list) {
            set.add(con.city1);
            set.add(con.city2);
        }
        UnionFind_II uf = new UnionFind_II(set);
        ArrayList<Connection> result = new ArrayList<Connection> ();
        for (Connection con : list) {
            String aRoot = uf.find(con.city1);
            String bRoot = uf.find(con.city2);

            if (!aRoot.equals(bRoot)) {
                uf.union(aRoot, bRoot);
                result.add(con);
            }
        }
        //override compare make it alphabet order
        Comparator<Connection> cmp = new Comparator<Connection>(){
                public int compare(Connection c1, Connection c2) {
                        if (c1.city1.equals(c2.city1)) {
                                return c1.city2.compareTo(c2.city2);
                        }
                        return c1.city1.compareTo(c2.city1);
                }};
        result.sort(cmp);

        return result;
    }
}

class UnionFind_II {
    HashMap<String, String> parent;
    HashMap<String, Integer> rank;
    
    public UnionFind_II (HashSet<String> set) {
        this.parent = new HashMap<String, String>();
        this.rank = new HashMap<String, Integer>();
        makeSet(set);
    }
    
    public void makeSet(HashSet<String> set) {        
        for (String one : set) {
            this.parent.put(one, one);
            this.rank.put(one, 0);
        }
    }
    
    public String find (String x) {
        // with path compression
        if (!this.parent.get(x).equals(x)) {
            this.parent.put(x, find(this.parent.get(x)));
        }
        return this.parent.get(x);
    }
    
    public void union (String x, String y) {
        String xRoot = find(x);
        String yRoot = find(y);
        
        if (xRoot.equals(yRoot)) {
            return;
        }
        
        if (rank.get(xRoot) < rank.get(yRoot)) {
            parent.put(xRoot, parent.get(yRoot));
        } else if (rank.get(xRoot) > rank.get(yRoot)) {
            parent.put(yRoot, parent.get(xRoot));
        } else {
            parent.put(yRoot, parent.get(xRoot));
            rank.put(xRoot, rank.get(xRoot) + 1);
        }
    }
}