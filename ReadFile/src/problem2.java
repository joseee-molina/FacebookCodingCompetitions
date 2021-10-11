import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class problem2 {
    static int ROW, COL, count;

    static boolean canBeIncluded(int[][] M, int row, int col, int[][] visited)
    {

        return (
                (row >= 0) && (row < ROW) && (col >= 0)
                        && (col < COL)
                        && (M[row][col] == 1 && visited[row][col]==0));
    }
    static void DFS(int[][] matrix, int row, int column ,int[][] visited){
        int[] rowdDirections = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] columnDirections = { -1, 0, 1, -1, 1, -1, 0, 1 };
        visited[row][column] = 1;


        for (int k = 0; k < 8; k++){
            if (canBeIncluded(matrix, row + rowdDirections[k], column + columnDirections[k], visited)) {
                count++;
                DFS(matrix, row + rowdDirections[k], column + columnDirections[k],visited);
            }
        }
    }
    static int maximalMexicanMates(int[][] M)
    {

        int[][] visited = new int[ROW][COL];


        int result = 0;
        for (int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COL; j++)
            {

                if (M[i][j] == 1 && visited[i][j] ==0) {
                    count = 1;
                    DFS(M, i, j, visited);

                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    public static void main(String args[])
    {

        readInput();

    }

    public static void readInput(){
        File myObj = new File("maximal_mexican_mates_input (1).txt");
        int cases = 0 ;
        String result = "";
        try {
            //File myObj = new File("a.txt");
            Scanner myReader = new Scanner(myObj);
            int testCases = Integer.parseInt(myReader.nextLine());
            System.out.println(testCases);
            while (myReader.hasNextLine()) {
                int row = Integer.parseInt(myReader.nextLine());
                System.out.println(row);
                int col = Integer.parseInt(myReader.nextLine());
                System.out.println(col);
                int[][] mat = new int[row][col];

                int ind = row;
                int j = 0;
                while(ind>0){
                    String s = myReader.nextLine();
                    for(int i = 0; i<s.length();i++){
                        if(s.charAt(i) != ' '){
                            char curr = s.charAt(i);
                            mat[row-ind][j] = Character.getNumericValue(curr);
                            j++;
                            System.out.print( Character.getNumericValue(curr) + " ");
                        }
                    }
                    ind--;
                    j = 0;
                    System.out.println();
                }

                ROW = row;
                COL = col;
                count = 0;
                cases+=1;
                result+= "Case #"+cases+": "+maximalMexicanMates(mat)+ "\n";



                System.out.println();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
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

}
