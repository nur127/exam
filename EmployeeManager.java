
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    public static String fileReader(String fileName) {
        String inputString;
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("employees.txt")));
            inputString = reader.readLine();
            reader.close();
        } catch (Exception e) {
            return e.getMessage();
        }
        return inputString;
    }

    public static String fileWriter(String fileName, String name) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("employees.txt", true));
            writer.write("," + name);
            writer.close();
        } catch (Exception e) {
            return e.getMessage();
        }
        return "File Write Succesful";
    }

    public static void main(String[] args) {

        boolean isValidArg = true;

        while (isValidArg) {

            // Check arguments

            if (args[0].equals("l")) {
                isValidArg = false;
                System.out.println("Loading data ...");

                String newReadLine = fileReader("employees.txt");
                String e[] = newReadLine.split(",");
                for (String emp : e) {
                    System.out.println(emp);
                }

                System.out.println("Data Loaded.");
            }

            else if (args[0].equals("s")) {
                isValidArg = false;
                System.out.println("Loading data ...");

                String newReadLine = fileReader("employees.txt");
                System.out.println(newReadLine);
                String e[] = newReadLine.split(",");
                Random rand = new Random();
                int idx = rand.nextInt(e.length);
                System.out.println(e[idx]);

                System.out.println("Data Loaded.");
            }

            else if (args[0].contains("+")) {
                isValidArg = false;
                System.out.println("Loading data ...");
                String name = args[0].substring(1);
                fileWriter("employee.txt", name);
                System.out.println("Data Loaded.");
            }

            else if (args[0].contains("?")) {
                isValidArg = false;
                System.out.println("Loading data ...");

                String newReadLine = fileReader("employees.txt");
                String e[] = newReadLine.split(",");
                boolean found = false;
                String name = args[0].substring(1);
                for (int i = 0; i < e.length && !found; i++) {
                    if (e[i].equals(name)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
                System.out.println("Data Loaded.");
            }

            else if (args[0].contains("c")) {
                isValidArg = false;
                System.out.println("Loading data ...");

                String newReadLine = fileReader("employees.txt");
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
                System.out.println("Data Loaded.");
            }

            else if (args[0].contains("u")) {
                isValidArg = false;
                System.out.println("Loading data ...");
                
                    String newReadLine = fileReader("employees.txt");
                    String e[] = newReadLine.split(",");
                    String name = args[0].substring(1);
                    for (int i = 0; i < e.length; i++) {
                        if (e[i].equals(name)) {
                            e[i] = "Updated";
                        }
                    }
                    fileWriter("employee.txt", name);
                
                System.out.println("Data Updated.");
            }

            else if (args[0].contains("d")) {
                isValidArg = false;
                System.out.println("Loading data ...");

                    String newReadLine = fileReader("employees.txt");
                    String e[] = newReadLine.split(",");
                    String name = args[0].substring(1);
                    List<String> list = new ArrayList<>(Arrays.asList(e));
                    list.remove(name);
                    fileWriter("employee.txt", name);

                System.out.println("Data Deleted.");
            }

            else {
                System.out.println("Wrong Argument ! Please Provide Valid Argument Like :: l, s, +, ?, c, u");

                Scanner input = new Scanner(System.in);
                String getArgs = input.nextLine();
                args = getArgs.split("//s+");
            }
        }
    }
}
