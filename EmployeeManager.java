
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {

    boolean isValidArg = true;

    while(isValidArg){

        // Check arguments

        if (args[0].equals("l")) {
            isValidArg = false ;
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String l = r.readLine();
                String e[] = l.split(",");
                for (String emp : e) {
                    System.out.println(emp);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } 

        else if (args[0].equals("s")) {
            isValidArg = false ;
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String l = r.readLine();
                System.out.println(l);
                String e[] = l.split(",");
                Random rand = new Random();
                int idx = rand.nextInt(e.length);
                System.out.println(e[idx]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } 
        
        else if (args[0].contains("+")) {
            isValidArg = false ;
            System.out.println("Loading data ...");
            try {
                BufferedWriter w = new BufferedWriter(
                        new FileWriter("employees.txt", true));
                String n = args[0].substring(1);
                w.write(", " + n);
                w.close();
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } 
        
        else if (args[0].contains("?")) {
            isValidArg = false ;
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String l = r.readLine();
                String e[] = l.split(",");
                boolean found = false;
                String s = args[0].substring(1);
                for (int i = 0; i < e.length && !found; i++) {
                    if (e[i].equals(s)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } 
        
        else if (args[0].contains("c")) {
            isValidArg = false ;
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String l = r.readLine();
                char[] chars = l.toCharArray();
                boolean inWord = false;
                int count = 0;
                for (char c : chars) {
                    if (c == ' ') {
                        if (!inWord) {
                            count++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + chars.length);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } 
        
        else if (args[0].contains("u")) {
            isValidArg = false ;
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String l = r.readLine();
                String e[] = l.split(",");
                String n = args[0].substring(1);
                for (int i = 0; i < e.length; i++) {
                    if (e[i].equals(n)) {
                        e[i] = "Updated";
                    }
                }
                BufferedWriter w = new BufferedWriter(
                        new FileWriter("employees.txt"));
                w.write(String.join(",", e));
                w.close();
            } catch (Exception e) {
            }
            System.out.println("Data Updated.");
        } 
        
        else if (args[0].contains("d")) {
            isValidArg = false ;
            System.out.println("Loading data ...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String l = r.readLine();
                String e[] = l.split(",");
                String n = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(e));
                list.remove(n);
                BufferedWriter w = new BufferedWriter(
                        new FileWriter("employees.txt"));
                w.write(String.join(",", list));
                w.close();
            } catch (Exception e) {
            }
            System.out.println("Data Deleted.");
        }

        else{
            System.out.println("Wrong Argument ! Please Provide Valid Argument Like :: l, s, +, ?, c, u");
            
            Scanner input = new Scanner(System.in);
            String getArgs = input.nextLine();
            args = getArgs.split("//s+");
        }
    }
}
}
