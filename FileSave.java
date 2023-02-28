import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSave {

    private String fileName; // for the file name

    public FileSave(String name) throws IOException // the constructor for the class
    {
        fileName = name;

        PrintWriter file = new PrintWriter(fileName); // opening a file

        file.close(); // closing the file
    }

    public void saveFile(String message) throws IOException // to save a message to the file
    {
        FileWriter file = new FileWriter(fileName, true); // so the file can be appended

        PrintWriter inFile = new PrintWriter(file); // to write to the file

        inFile.println(message); // putting the message in the file

        inFile.close(); // closing the file
    }
}
