package Thumbtack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        String path = "/Users/jiamingxie/Documents/Company/2016_Fall_FT/thumtback/test_cases/input001.txt";
        SimpleDB db = new SimpleDB();
        
        Scanner reader = new Scanner(new File(path));
        while (reader.hasNext()){
           String str = reader.nextLine();
           db.execute(str);
           //System.out.println(str);
        }
    }
}

/*
 * 
 * SET name value
 * GET name
 * UNSET name
 * NUMEQUALTO value
 * END
 * 
 * BEGIN
 * ROLLBACK
 * COMMIT
 * 
 */

class SimpleDB {
    HashMap<String, String> keyValueMap;
    HashMap<String, HashSet<String>> invertedIndex;
    LinkedList<String> logStack;
    
    private static final String SET = "SET";
    private static final String GET = "GET";
    private static final String UNSET = "UNSET";
    private static final String NUMEQUALTO = "NUMEQUALTO";
    private static final String END = "END";
    
    private static final String BEGIN = "BEGIN";
    private static final String ROLLBACK = "ROLLBACK";
    private static final String COMMIT = "COMMIT";
    
    public SimpleDB () {
        this.keyValueMap = new HashMap<String, String>();
        this.invertedIndex = new HashMap<String, HashSet<String>>();
        this.logStack = new LinkedList<>();
    }
    
    public void execute (String command) {
        if (command == null || command.length() == 0) {
            return;
        }
        command = command.trim();
        System.out.println(command);
        String[] commands = command.split(" ");
        
        if (commands.length == 1) {
            String operation = commands[0];
            
            if (operation.equalsIgnoreCase(END)) {
                end();
            } else if (operation.equalsIgnoreCase(BEGIN)) {
                begin();
            } else if (operation.equalsIgnoreCase(ROLLBACK)) {
                rollback();
            } else if (operation.equalsIgnoreCase(COMMIT)) {
                commit();
            }
        } else if (commands.length == 2) {
            String operation = commands[0];
            String input = commands[1];
            
            if (operation.equalsIgnoreCase(GET)) {
                get(input);
            } else if (operation.equalsIgnoreCase(UNSET)) {
                unset(input);
            } else if (operation.equalsIgnoreCase(NUMEQUALTO)) {
                numEqualTo(input);
            }
        } else if (commands.length == 3) {
            String operation = commands[0];
            String key = commands[1];
            String value = commands[2];
            
            if (operation.equalsIgnoreCase(SET)) {
                set(key, value);
            }
        }
    }
    
    private void set (String key, String value) {
        this.keyValueMap.put(key, value);
        
        if (!this.invertedIndex.containsKey(value)) {
            this.invertedIndex.put(value, new HashSet<String>());
        }
        this.invertedIndex.get(value).add(key);
    }

    private void setLog (String key, String value) {
        StringBuilder sb = new StringBuilder();
        String currentVal = this.keyValueMap.get(key);
        if (currentVal == null) {
            sb.append("UNSET");
            sb.append(" ");
            sb.append(key);
        } else {
            sb.append("SET");
            sb.append(" ");
            sb.append(key);
            sb.append(" ");
            sb.append(currentVal);
        }

        if (!this.invertedIndex.containsKey(value)) {
            this.invertedIndex.put(value, new HashSet<String>());
        } else {
            
        }
    }
    
    private String get (String key) {
        if (!this.keyValueMap.containsKey(key)) {
            return null;
        }
        return this.keyValueMap.get(key);
    }
    
    private void unset (String key) {
        String value = get(key);
        
        if (value != null) {
            this.keyValueMap.remove(key);
            this.invertedIndex.get(value).remove(key);
        }
    }
    
    private int numEqualTo (String value) {
        if (!this.invertedIndex.containsKey(value)) {
            return 0;
        }
        return this.invertedIndex.get(value).size();
    }
    
    private void end () {
        System.exit(0);
    }
    
    private void begin () {
    }
    
    private void rollback () {
        
    }
    
    private void commit () {
        this.logStack = new LinkedList<String>();
    }
}
