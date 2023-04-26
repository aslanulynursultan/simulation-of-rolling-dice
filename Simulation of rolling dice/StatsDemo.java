import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
// TASK #3 Add the file I/O import statement here

/**
   This class reads numbers from a file, calculates the
   mean and standard deviation, and writes the results
   to a file.
*/

public class StatsDemo
 {
   // TASK #3 Add the throws clause
   public static void main(String[] args) throws IOException {
       double sum = 0;      // The sum of the numbers
       int count = 0;       // The number of numbers added
       double mean = 0;     // The average of the numbers
       double stdDev = 0;   // The standard deviation
       String line;         // To hold a line from the file
       double difference;   // The value and mean difference
       ArrayList<Double> values = new ArrayList<>();

       // Create an object of type Scanner
       Scanner keyboard = new Scanner(System.in);
       String filename;     // The user input file name

       // Prompt the user and read in the file name
       System.out.println("This program calculates " +
               "statistics on a file " +
               "containing a series of numbers");
       System.out.print("Enter the file name:  ");
       filename = keyboard.nextLine();
       keyboard.close();
       // ADD LINES FOR TASK #4 HERE
       FileReader File = new FileReader(filename); // Create a FileReader object passing it the filename
       BufferedReader readFile = new BufferedReader(File);// Create a BufferedReader object passing FileReader
       // object
       line = readFile.readLine();// Perform a priming read to read the first line of
       // the file
       while (true)
       {


         line = readFile.readLine(); // Read a new line from the file
         if (line == null)
           break;
          else {
           values.add(Double.parseDouble(line));
           sum += Double.valueOf(line);
           count += 1;
            }
       }
       readFile.close();
       System.out.println(count);
       mean = sum / count;
       System.out.println("The mean is: " + mean);

       FileReader File_read = new FileReader(filename);
       BufferedReader read_File = new BufferedReader(File_read);
       sum = 0; count = 0;
       line = read_File.readLine();
       while(true) {
           line = read_File.readLine();
           if (line == null)
               break;
           else {
               difference = (Double.valueOf(line) - mean);
               sum += Math.pow(difference, 2);
               count += 1;

           }
       }
       read_File.close();
       stdDev = Math.sqrt(sum / count - 1);
       System.out.println("The standard deviation is: " + stdDev);



           // Loop until you are at the end of the file
      // Convert the line to a double value and add the
      // value to sum
      // Increment the counter
      // Read a new line from the file
      // Close the input file
      // Store the calculated mean

      // ADD LINES FOR TASK #5 HERE

       // Reconnect FileReader object passing it the
      // filename
      // Reconnect BufferedReader object passing
      // FileReader object
      // Reinitialize the sum of the numbers
      // Reinitialize the number of numbers added
      // Perform a priming read to read the first line of
      // the file
      // Loop until you are at the end of the file
      // Convert the line into a double value and
      // subtract the mean
      // Add the square of the difference to the sum
      // Increment the counter
      // Read a new line from the file
      // Close the input file
      // Store the calculated standard deviation

      // ADD LINES FOR TASK #3 HERE

       FileWriter write = new FileWriter("Result.txt"); // Create a FileWriter object using "Results.txt"
       PrintWriter output = new PrintWriter(write); // Create a PrintWriter object passing the
       output.printf("Mean of %s = %.3f.\n\n", values.toString(), mean); // FileWriter object
       output.printf("Standard Deviation of %s  = %.3f.",values.toString(), stdDev); // Print the results to the output file
       output.close(); // Close the output file
   }
 }