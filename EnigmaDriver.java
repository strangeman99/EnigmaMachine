import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

/* Figure out why the switchboard isn't working. It translates everything to a*/

public class EnigmaDriver {

    final static int NUM_ROTORS = 3; // the number of rotors which can be changed

    public static void main(String[] args) throws IOException {
        runEnigma(); // to run the machine
    }

    public static void runEnigma() throws IOException // this runs the whole program
    {
        String input = "";
        boolean correctAnswer = false;

        Scanner keyboard = new Scanner(System.in); // a scanner object

        do // asking the user what they want to do
        {
            System.out.print("Do you want to encode or decode? (E/D): ");
            input = keyboard.nextLine();
            System.out.println();

            if (input.equalsIgnoreCase("e")) // if they want to encode
            {
                correctAnswer = true;

                encode(); // encoding the message
            }

            else if (input.equalsIgnoreCase("d")) // if they want to decode
            {
                correctAnswer = true;

                decode(); // decoding the message
            }

            else
            {
                System.out.println("That isn't a valid response.");
            }

        } while (!correctAnswer);
    }

    public static void encode() throws IOException // if you want to change a message
    {
        Settings settings = new Settings(); // a settings object

        settings.selectSettings(); // to select the settings

        Rotor[] rotors = getRotors(settings); // making the rotors array

        int[] data = getData(); // this will get the data from the user

        Machine machine = new Machine(rotors[0], rotors[1], rotors[2]); // creating a new machine with the new rotors

        data = machine.throughSwitch(data); // putting the data through the board

        data = machine.throughRotorsEncode(data); // putting the data through the rotors

        numsToOutput(data); // printing the new data to the screen
    }

    private static void decode() throws IOException // to decode a message
    {
        Settings settings = new Settings(); // creating a settings object

        settings.selectSettings(); // to select the settings

        Rotor[] rotors = getRotors(settings); // making the rotors array

        int[] data = getData(); // getting data from the user

        Machine machine = new Machine(rotors[0], rotors[1], rotors[2]); // creating a new machine with the new rotors

        data = machine.throughRotorsDecode(data); // decoding through rotors

        data = machine.throughSwitch(data); // putting the data thorough the switch board

        numsToOutput(data); // printing the output

    }

    private static int[] type() // to type a message
    {
        Scanner keyboard = new Scanner(System.in); // creating a scanner object

        // getting the user input
        System.out.println("Enter your message now. Only lowercase and \" \" \".\": ");
        String input = keyboard.nextLine();

        return stringToNums(input); // returning the input in integer form
    }

    private static int[] fromFile() throws FileNotFoundException // to get the message from a file
    {
        Scanner keyboard = new Scanner(System.in); // creating a scanner object

        // getting the name of the file they're creating
        System.out.print("What is the name of the file?: ");
        String name = keyboard.nextLine();

        FileDisplay file = new FileDisplay(name); // creating a fileDisplay object

        return stringToNums(file.readFile()); // returning the data from the read file
    }

    private static int[] stringToNums(String message) // this will convert a string to an array of int
    {
        char[] chars = new char[message.length()]; // making an array of chars
        int[] info =  new int[message.length()]; // this is the array of converted data

        for (int i = 0; i < message.length(); i++) // this will loop through the string
        {
            chars[i] = message.charAt(i); // breaking the string into chars
        }

        for (int i = 0; i < message.length(); i++) // this will loop through the char array and set the chars to ints
        {
            if (chars[i] == 'a')
            {
                info[i] = 0;
            }

            else if (chars[i] == 'b')
            {
                info[i] = 1;
            }

            else if (chars[i] == 'c')
            {
                info[i] = 2;
            }

            else if (chars[i] == 'd')
            {
                info[i] = 3;
            }

            else if (chars[i] == 'e')
            {
                info[i] = 4;
            }

            else if (chars[i] == 'f')
            {
                info[i] = 5;
            }

            else if (chars[i] == 'g')
            {
                info[i] = 6;
            }

            else if (chars[i] == 'h')
            {
                info[i] = 7;
            }

            else if (chars[i] == 'i')
            {
                info[i] = 8;
            }

            else if (chars[i] == 'j')
            {
                info[i] = 9;
            }

            else if (chars[i] == 'k')
            {
                info[i] = 10;
            }

            else if (chars[i] == 'l')
            {
                info[i] = 11;
            }

            else if (chars[i] == 'm')
            {
                info[i] = 12;
            }

            else if (chars[i] == 'n')
            {
                info[i] = 13;
            }

            else if (chars[i] == 'o')
            {
                info[i] = 14;
            }

            else if (chars[i] == 'p')
            {
                info[i] = 15;
            }

            else if (chars[i] == 'q')
            {
                info[i] = 16;
            }

            else if (chars[i] == 'r')
            {
                info[i] = 17;
            }

            else if (chars[i] == 's')
            {
                info[i] = 18;
            }

            else if (chars[i] == 't')
            {
                info[i] = 19;
            }

            else if (chars[i] == 'u')
            {
                info[i] = 20;
            }

            else if (chars[i] == 'v')
            {
                info[i] = 21;
            }

            else if (chars[i] == 'w')
            {
                info[i] = 22;
            }

            else if (chars[i] == 'x')
            {
                info[i] = 23;
            }

            else if (chars[i] == 'y')
            {
                info[i] = 24;
            }

            else if (chars[i] == 'z')
            {
                info[i] = 25;
            }

            else if (chars[i] == ' ')
            {
                info[i] = 26;
            }

            else if (chars[i] == '.')
            {
                info[i] = 27;
            }

            else
            {
                info[i] = 26;
            }

        }

        return info; // returning the int array
    }

    private static void numsToOutput(int[] message) throws IOException // this converts the message to an output string
    {

        Scanner keyboard = new Scanner(System.in); // a scanner object
        String input;
        boolean corAns = false;

        do {
            // getting user input
            System.out.print("Would you like to translate to a .txt file or display on the console? (T/C): ");
            input = keyboard.nextLine();

            /* create the file save class */
            if (input.equalsIgnoreCase("t")) // to a file
            {
                corAns = true;

                sendToFile(getMessage(message)); // to get a message to a file

            }

            else if (input.equalsIgnoreCase("c"))  // to the console
            {
                corAns = true;

                System.out.println(getMessage(message)); // printing the message to the screen
            }

            else {
                System.out.println("That isn't a correct input");
            }
        } while (!corAns);
    }

    private static void sendToFile(String message) throws IOException // sending a message to a file
    {
        Scanner keyboard = new Scanner(System.in); // a scanner object

        // getting the file name
        System.out.print("What name do you want the file?: ");
        String input = keyboard.nextLine();

        input += ".txt"; // making the name a text file

        FileSave file = new FileSave(input); // creating a fileSave object

        file.saveFile(message); // saving the message
    }

    private static String getMessage(int[] data) // this converts the data to a string
    {
        char[] chars = new char[data.length]; // creating a char array the same length of the int array

        for (int i = 0; i < chars.length; i++) // this will convert all of the ints to chars
        {
            if (data[i] == 0)
            {
                chars[i] = 'a';
            }

            else if (data[i] == 1)
            {
                chars[i] = 'b';
            }

            else if (data[i] == 2)
            {
                chars[i] = 'c';
            }

            else if (data[i] == 3)
            {
                chars[i] = 'd';
            }

            else if (data[i] == 4)
            {
                chars[i] = 'e';
            }

            else if (data[i] == 5)
            {
                chars[i] = 'f';
            }

            else if (data[i] == 6)
            {
                chars[i] = 'g';
            }

            else if (data[i] == 7)
            {
                chars[i] = 'h';
            }

            else if (data[i] == 8)
            {
                chars[i] = 'i';
            }

            else if (data[i] == 9)
            {
                chars[i] = 'j';
            }

            else if (data[i] == 10)
            {
                chars[i] = 'k';
            }

            else if (data[i] == 11)
            {
                chars[i] = 'l';
            }

            else if (data[i] == 12)
            {
                chars[i] = 'm';
            }

            else if (data[i] == 13)
            {
                chars[i] = 'n';
            }

            else if (data[i] == 14)
            {
                chars[i] = 'o';
            }

            else if (data[i] == 15)
            {
                chars[i] = 'p';
            }

            else if (data[i] == 16)
            {
                chars[i] = 'q';
            }

            else if (data[i] == 17)
            {
                chars[i] = 'r';
            }

            else if (data[i] == 18)
            {
                chars[i] = 's';
            }

            else if (data[i] == 19)
            {
                chars[i] = 't';
            }

            else if (data[i] == 20)
            {
                chars[i] = 'u';
            }

            else if (data[i] == 21)
            {
                chars[i] = 'v';
            }

            else if (data[i] == 22)
            {
                chars[i] = 'w';
            }

            else if (data[i] == 23)
            {
                chars[i] = 'x';
            }

            else if (data[i] == 24)
            {
                chars[i] = 'y';
            }

            else if (data[i] == 25)
            {
                chars[i] = 'z';
            }

            else if (data[i] == 26)
            {
                chars[i] = ' ';
            }

            else if (data[i] == 27)
            {
                chars[i] = '.';
            }

            else // if it is none set it to a space
            {
                chars[i] = ' ';
            }
        }

        StringBuilder message = new StringBuilder(); // a string to hold the full message

        // adding each char to the message
        for (char aChar : chars) {
            message.append(aChar);
        }

        return message.toString();
    }

    private static int[] getData() throws FileNotFoundException // this will get the data from the user
    {
        Scanner keyboard = new Scanner(System.in); // a scanner object

        boolean correctInput = false; // to check input
        int[] data = new int[0]; // this will hold the data from the message

        do { // this will loop until it gets the correct input
            // getting the input
            System.out.print("Would you like to type the message or get it read through a file? (T/F): ");
            String input = keyboard.next();

            if (input.equalsIgnoreCase("t")) // if they want to type
            {
                data = type(); // to set the data

                correctInput = true;
            }

            else if (input.equalsIgnoreCase("f")) // if they want to read from a file
            {
                data = fromFile(); // to set the data

                correctInput = true;
            }

            else {
                System.out.println("That isn't an option.");
            }

        } while (!correctInput);

        return data; // returning the data to the user
    }

    private static Rotor[] getRotors(Settings settings) // this will return an array of rotors
    {
        Rotor[] rotors = new Rotor[NUM_ROTORS]; // declaring 3 rotors

        for (int i = 0; i < NUM_ROTORS; i++) // loops through the rotors
        {
            rotors[i] = new Rotor(settings, i); // creating a new rotor

            rotors[i].putInStart(); // putting the rotor in its starting position
        }

        return rotors; // returning the rotors array
    }
}
