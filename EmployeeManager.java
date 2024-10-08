
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    //add a common function for read a file
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

    // add a common function for write into the file
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

        // declare constant object
        Constant constants = new Constant();

        // set value invalid variable to check a arguments includes or not
        boolean isValidArg = true;

        while (isValidArg) {

            // arguments 1

            if (args[0].equals("l")) {
                isValidArg = false;
                System.out.println(constants.LOADING_DATA_MESSAGE);

                String newReadLine = fileReader("employees.txt");
                String e[] = newReadLine.split(",");
                for (String emp : e) {
                    System.out.println(emp);
                }

                System.out.println(constants.DATA_LOADING_MESSAGE);
            }
            // arguments 2
            else if (args[0].equals("s")) {
                isValidArg = false;
                System.out.println(constants.LOADING_DATA_MESSAGE);

                String newReadLine = fileReader("employees.txt");
                String e[] = newReadLine.split(",");
                Random random = new Random();
                int idx = random.nextInt(e.length);
                System.out.println(e[idx]);

                System.out.println(constants.DATA_LOADING_MESSAGE);
            }
            // arguments 3
            else if (args[0].contains("+")) {
                isValidArg = false;
                System.out.println(constants.LOADING_DATA_MESSAGE);
                String name = args[0].substring(1);
                fileWriter("employee.txt", name);
                System.out.println(constants.DATA_LOADING_MESSAGE);
            }
            // arguments 4
            else if (args[0].contains("?")) {
                isValidArg = false;
                System.out.println(constants.LOADING_DATA_MESSAGE);

                String newReadLine = fileReader("employees.txt");
                String e[] = newReadLine.split(",");
               
                String name = args[0].substring(1);
                for(String i :e){
                    if(name.equals(i)){
                        System.out.println(constants.EMPLOYEE_FOUND_MESSAGE);
                    }
                }
                System.out.println(constants.DATA_LOADING_MESSAGE);
            }
            // arguments 5
            else if (args[0].contains("c")) {
                isValidArg = false;
                System.out.println(constants.LOADING_DATA_MESSAGE);

                String newReadLine = fileReader("employees.txt");
                char[] chars = newReadLine.toCharArray();
                String words[]=newReadLine.split((","));
                System.out.println(words.length + constants.Word_fOUND_MESSAGE + chars.length);
                System.out.println(constants.DATA_LOADING_MESSAGE);
            }
            // arguments 6
            else if (args[0].contains("u")) {
                isValidArg = false;
                System.out.println(constants.LOADING_DATA_MESSAGE);
                
                    String newReadLine = fileReader("employees.txt");
                    String e[] = newReadLine.split(",");
                    String name = args[0].substring(1);
                    for (int i = 0; i < e.length; i++) {
                        if (e[i].equals(name)) {
                            e[i] = "Updated" ;
                        }
                    }
                    fileWriter("employee.txt", name);
                
                System.out.println(constants.DATA_UPDATED_MESSAGE);
            }
            // argument 7
            else if (args[0].contains("d")) {
                isValidArg = false;
                System.out.println(constants.LOADING_DATA_MESSAGE);

                    String newReadLine = fileReader("employees.txt");
                    String e[] = newReadLine.split(",");
                    String name = args[0].substring(1);
                    List<String> list = new ArrayList<>(Arrays.asList(e));
                    list.remove(name);
                    fileWriter("employee.txt", name);

                System.out.println(constants.DATA_DELETED_MESSAGE);
            }
            // Give a wrong Argument Message for invalid argument
            else {
                System.out.println(constants.WRONG_ARGUMENT_MESSAGE);

                Scanner input = new Scanner(System.in);
                String getArgs = input.nextLine();
                args = getArgs.split("//s+") ;
            }
        }
    }
}
