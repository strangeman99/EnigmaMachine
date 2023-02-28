import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDisplay {

    private String name; // the name of the file

    public FileDisplay(String fileName) // the constructor for the class
    {
        name = fileName + ".txt"; // setting the file name
    }

    public String readFile() throws FileNotFoundException // to read a file
    {
        File file = new File(name); // opening the file
        StringBuilder message = new StringBuilder(); // to hold the users message

        if (file.exists()) // if the file exists
        {
            Scanner inFile = new Scanner(file); // a scanner for the file

            while (inFile.hasNext()) // this will loop through the file
            {
                message.append(inFile.nextLine()); // adding each line to the message
            }
        }

        else
        {
            System.out.println("That file doesn't exist.");
        }

        return message.toString(); // returning the message
    }
}
