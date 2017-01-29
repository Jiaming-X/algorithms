package Amazon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MinimumSpanningTreeII {

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
                return o1.cost - o2.cost;
            }
        });
        HashMap<String, Integer> nameToIndex = new HashMap<String, Integer>();
        HashMap<Integer, String> indexToName = new HashMap<Integer, String>();
        int index = 0;
        for (Connection con : list) {
            if (!nameToIndex.containsKey(con.city1)) {
                nameToIndex.put(con.city1, index);
                indexToName.put(index, con.city1);
                index++;
            }
            if (!nameToIndex.containsKey(con.city2)) {
                nameToIndex.put(con.city2, index);
                indexToName.put(index, con.city2);
                index++;
            }
        }
        UnionFind uf = new UnionFind(list.size());
        ArrayList<Connection> result = new ArrayList<Connection> ();
        for (Connection con : list) {
            int aRoot = uf.find(nameToIndex.get(con.city1));
            int bRoot = uf.find(nameToIndex.get(con.city2));
            if (aRoot != bRoot) {
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


class UnionFind {
    int[] parent;
    int[] rank;
    
    public UnionFind (int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        makeSet();
    }
    
    public void makeSet() {
        int len = parent.length;
        
        for (int i = 0; i < len; i++) {
            this.parent[i] = i;
        }
    }
    
    public int find (int x) {
        // with path compression
        if (this.parent[x] != x) {
            this.parent[x] = find(this.parent[x]);
        }
        return this.parent[x];
    }
    
    public void union (int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        
        if (xRoot == yRoot) {
            return;
        }
        
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = parent[yRoot];
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = parent[xRoot];
        } else {
            parent[yRoot] = parent[xRoot];
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}