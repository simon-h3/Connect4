import java.awt.Desktop;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class textFile{
	
	public static void createTxt(){
		try{
			 File Connect4History = new File("C:\\temp\\Connect4History.txt"); //stored in the temporary folder in main drive.
			 
		    if (Connect4History.createNewFile()) {
				System.out.println("File created: " + Connect4History.getName());
		    } 
		      
		    else{
				System.out.println("File already exists.");
		    }
		} 
		
		catch (IOException error) {
		    System.out.println("Error in Text File Creation");	// error handling output
		    error.printStackTrace();
		}
	}
	
	public static void writeTxt(String data) {
		try {
			FileWriter dataWrite = new FileWriter("C:\\temp\\Connect4History.txt");	//refers to the game file

			dataWrite.write(data + "\n");	//writes the String data taken from the user name.
			dataWrite.close();	//ends the writing process
			System.out.println("Writing complete");	//logs for me to see if it works (will also check the actual file)

		}
		
		catch (IOException error) {
			System.out.println("Error in writing to File");
			error.printStackTrace();	//shows a system error reason for being unable to process the action.
		}
	}
	
	public static String readTxt() {
		try {
			File Connect4History = new File("C:\\temp\\Connect4History.txt");
			Scanner textReader = new Scanner(Connect4History);
			String firstLine = textReader.nextLine();
			
			firstLine = ("Last winner: " + firstLine);
			
			textReader.close();
			return firstLine;

		}
		catch(IOException error) {
			System.out.println("Error in reading file");
			error.printStackTrace();
			
		}
		return null;
		
	}
	
	public static void openTxt() {
		Desktop OS = Desktop.getDesktop();
		
		try {
			File Connect4History = new File("C:\\temp\\Connect4History.txt");
			OS.open(Connect4History);
		}
		
		catch(Exception error) {
			System.out.println("Error in opening file");
			error.printStackTrace();
		}
	}

}
