import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
public class problem1 {
    public static void main(String[] args) {

        File myObj = new File("finding_facebook_input.txt");
        ArrayList<String> arr = new ArrayList<>();
        try {
            //File myObj = new File("a.txt");
            Scanner myReader = new Scanner(myObj);
            int num = Integer.parseInt(myReader.nextLine());
            System.out.println(num);
            while (myReader.hasNextLine()) {
                String s = myReader.nextLine();
                arr.add(s);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String result = "";
        for(int i = 0 ; i<arr.size(); i++){
            int n = i+1;
            result+= "Case #" + n+ ": "+checkYesNo(arr.get(i))+ "\n";
        }
        result = result.substring(0,result.length()-1);
        System.out.println(result);
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            myWriter.write(result);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static String checkYesNo(String s){
        String fb = "facebook";
        int ind1 = 0 ;
        int ind2 = 0;

        while(ind2<s.length()){
            if(ind1>=fb.length()){
                return "YES";
            }
            if(s.charAt(ind2) == fb.charAt(ind1)){
                ind1++;
                ind2++;
                continue;
            }

            ind2++;
        }
        if(ind1!=fb.length()){
            return "NO";
        }
        else{
            return "YES";
        }
    }


}