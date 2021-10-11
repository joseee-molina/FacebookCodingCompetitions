import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {
        readinpt();
    }

    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    public static void readinpt(){
        File myObj = new File("candy_collection_sample_input.txt");
        String result = "";
        try {
            //File myObj = new File("a.txt");
            Scanner myReader = new Scanner(myObj);
            int cases = Integer.parseInt(myReader.nextLine());
            System.out.println(cases);
            while (myReader.hasNextLine()) {
                int len = Integer.parseInt(myReader.nextLine());
                String s = myReader.nextLine();
                int[] arr = new int[len];
                String[] arrString = s.split("\\s+");
                //System.out.println(s);
                for(int i = 0 ; i<arrString.length;i++){
                    arr[i] = Integer.parseInt(arrString[i]);
                }
                result += maxSubArraySum(arr)+"\n";
            }
            result = result.substring(0,result.length()-1);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(result);
        try {
            FileWriter myWriter = new FileWriter("output3.txt");
            myWriter.write(result);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
