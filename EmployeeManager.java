
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
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String newReadLine = reader.readLine();
                String e[] = newReadLine.split(",");
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
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String newReadLine = reader.readLine();
                System.out.println(newReadLine);
                String e[] = newReadLine.split(",");
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
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt", true));
                String name = args[0].substring(1);
                writer.write(", " + name);
                writer.close();
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } 
        
        else if (args[0].contains("?")) {
            isValidArg = false ;
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String newReadLine = reader.readLine();
                String e[] = newReadLine.split(",");
                boolean found = false;
                String name = args[0].substring(1);
                for (int i = 0; i < e.length && !found; i++) {
                    if (e[i].equals(name)) {
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
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String newReadLine = reader.readLine();
                char[] chars = newReadLine.toCharArray();
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
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String newReadLine = reader.readLine();
                String e[] = newReadLine.split(",");
                String name = args[0].substring(1);
                for (int i = 0; i < e.length; i++) {
                    if (e[i].equals(name)) {
                        e[i] = "Updated";
                    }
                }
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt"));
                writer.write(String.join(",", e));
                writer.close();
            } catch (Exception e) {
            }
            System.out.println("Data Updated.");
        } 
        
        else if (args[0].contains("d")) {
            isValidArg = false ;
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String newReadLine = reader.readLine();
                String e[] = newReadLine.split(",");
                String name = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(e));
                list.remove(name);
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt"));
                writer.write(String.join(",", list));
                writer.close();
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
