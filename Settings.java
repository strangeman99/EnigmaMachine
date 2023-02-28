import java.util.Scanner;

public class Settings {

    final int NUM_OF_CHARACTERS = 28; // a constant for the characters
    final int NUM_OF_ROTORS = 5; // a constant for the num of rotors
    final int NUM_ROTORS_HELD = 3; // the num of rotors that can be in the machine

    private int[] rotors; // holds which rotors are in the machine
    private int[] rotorStart; // holds the starting position of each rotor
    private int[] plugBoard; // holds the combinations of the plug board
    private char[] possibleChars; // holds all of the characters that will be used
    private boolean[] beenLinked; // keeps track of if a character has been linked on the plug board
    private boolean[] rotorUsed; // keeps track of if the rotor has been used
    private int switchIndex; // where to switch the index to

    public Settings() // the constructor for the class
    {

        switchIndex = 0; // setting the original index to 0

        // creating the arrays
        rotors = new int[NUM_ROTORS_HELD];
        rotorStart = new int[NUM_ROTORS_HELD];
        plugBoard = new int[NUM_OF_CHARACTERS];
        possibleChars = new char[NUM_OF_CHARACTERS];
        beenLinked = new boolean[NUM_OF_CHARACTERS];
        rotorUsed = new boolean[NUM_OF_ROTORS];

        // initializing arrays

        for (int i = 0; i < NUM_ROTORS_HELD; i++)
        {
            rotors[i] = ++i;
        }

        for (int i = 0; i < NUM_ROTORS_HELD; i++)
        {
            rotorStart[i] = 0;
        }

        for (int i = 0; i < NUM_OF_CHARACTERS; i++)
        {
            plugBoard[i] = i;

            beenLinked[i] = false;
        }

        for (int i = 0; i < 5; i++)
        {
            rotorUsed[i] = false;
        }

        for (int i = 0; i < NUM_OF_CHARACTERS; i++)
        {
            switch (i) {
                case 0 -> possibleChars[0] = 'a';
                case 1 -> possibleChars[1] = 'b';
                case 2 -> possibleChars[2] = 'c';
                case 3 -> possibleChars[3] = 'd';
                case 4 -> possibleChars[4] = 'e';
                case 5 -> possibleChars[5] = 'f';
                case 6 -> possibleChars[6] = 'g';
                case 7 -> possibleChars[7] = 'h';
                case 8 -> possibleChars[8] = 'i';
                case 9 -> possibleChars[9] = 'j';
                case 10 -> possibleChars[10] = 'k';
                case 11 -> possibleChars[11] = 'l';
                case 12 -> possibleChars[12] = 'm';
                case 13 -> possibleChars[13] = 'n';
                case 14 -> possibleChars[14] = 'o';
                case 15 -> possibleChars[15] = 'p';
                case 16 -> possibleChars[16] = 'q';
                case 17 -> possibleChars[17] = 'r';
                case 18 -> possibleChars[18] = 's';
                case 19 -> possibleChars[19] = 't';
                case 20 -> possibleChars[20] = 'u';
                case 21 -> possibleChars[21] = 'v';
                case 22 -> possibleChars[22] = 'w';
                case 23 -> possibleChars[23] = 'x';
                case 24 -> possibleChars[24] = 'y';
                case 25 -> possibleChars[25] = 'z';
                case 26 -> possibleChars[26] = ' ';
                case 27 -> possibleChars[27] = '.';
            }
        }
    }

    public Settings(Settings settings) // this is a copy constructor for the class
    {
        switchIndex = settings.getSwitchIndex(); // copying the switch index

        // creating the arrays
        rotors = new int[NUM_ROTORS_HELD];
        rotorStart = new int[NUM_ROTORS_HELD];
        plugBoard = new int[NUM_OF_CHARACTERS];
        possibleChars = new char[NUM_OF_CHARACTERS];
        beenLinked = new boolean[NUM_OF_CHARACTERS];
        rotorUsed = new boolean[NUM_OF_ROTORS];

        for (int i = 0; i < NUM_ROTORS_HELD; i++) // copy rotor start
        {
            rotors[i] =  settings.rotors[i];

            rotorStart[i] =  settings.rotorStart[i];
        }

        for (int i = 0; i < NUM_OF_CHARACTERS; i++) // copy chars
        {
            plugBoard[i] =  settings.plugBoard[i];

            possibleChars[i] = settings.possibleChars[i];

            beenLinked[i] = settings.beenLinked[i];
        }

        for (int i = 0; i < NUM_OF_ROTORS; i++) // copy if rotors are used
        {
            rotorUsed[i] = settings.rotorUsed[i];
        }
    }

    public void selectSettings() // to chose the settings that you want
    {
        String[] position = new String[NUM_ROTORS_HELD]; // holds the positions of the rotors

        for (int i = 0; i < NUM_ROTORS_HELD; i++) // this sets the positions
        {
            if (i == 0)
            {
                position[i] = "right";
            }

            else if (i == 1)
            {
                position[i] = "middle";
            }

            else
            {
                position[i] = "left";
            }
        }

        for (int i = 0; i < NUM_ROTORS_HELD; i++) // looping through the rotors
        {
            rotors[i] = changeRotor(position[i]); // this will determine what rotor is in the first spot
            setRotor(position[i], i); // this will set the rotors position
        }

        setBoard(); // this will set the switchboard
    }

    private int changeRotor(String pos) // to change a specific rotor
    {
        int rotor = 0; // this will determine what rotor is put in

        // helper variables
        int input;
        boolean correctAnswer;

        Scanner keyboard = new Scanner(System.in); // a scanner object

        do {
            System.out.print("What rotor is in the " + pos + "? (1, 2, 3, 4, 5): ");
            input = keyboard.nextInt();
            System.out.println();

            input--;

            int index = input;

            // if the rotor is correct and it hasn't been used
            if ((input == 0 || input == 1 || input == 2 || input == 3 || input == 4) && !rotorUsed[index])
            {
                rotor = input; // setting the rotor to the input value

                rotorUsed[index] = true; // since this rotor is now used

                correctAnswer = true;
            }
            else {
                System.out.println("That rotor isn't an option. Choose again.");

                correctAnswer = false;
            }

        } while (!correctAnswer);

        return rotor; // returning the value that the rotor was set to
    }

    private void setRotor(String pos, int index) // this will set the rotor position
    {
        // helper variables
        int input;
        boolean correctAnswer;

        Scanner keyboard = new Scanner(System.in); // a scanner object

        do { // this is the input loop

            System.out.print("What is the starting setting for the " + pos + "? (1-28): ");
            input = keyboard.nextInt();
            System.out.println();

            if (input >= 1 && input <= 28) // if it is the correct range
            {
                correctAnswer = true;

                input--; // changing input into an index

                rotorStart[index] = input; // setting the new starting pos
            }

            else
            {
                System.out.println("That rotor isn't an option. Choose again.");
                correctAnswer = false;
            }

        } while (!correctAnswer);
    }

    private void setBoard() // this function will set the entire board
    {
        // helper variables for the class
        String switchInput;
        String secondInput;
        boolean switchAnswer;
        boolean secondAnswer;
        boolean cor;

        Scanner keyboard = new Scanner(System.in); // a scanner object

        do { // this will loop for the switchboard

            // if they want a switchboard
            System.out.print("Do you want a switchboard? (Y/N): ");
            String input = keyboard.nextLine();

            if (input.equalsIgnoreCase("y"))
            {
                cor = true;

                System.out.println("Now we will organize the switchboard.");
                System.out.println("FYI: Only lower case letters, spaces, and periods.");
                System.out.println("Only type one letter at a time.\n");

                for (int i = 0; i < NUM_OF_CHARACTERS; i++) // go through the characters
                {
                    if (!beenLinked[i]) // if this char hasn't been linked
                    {
                        do { // this will loop until a correct answer

                            System.out.println("Would you like to link anything with " + possibleChars[i] + "? (Y/N)");
                            switchInput = keyboard.nextLine();

                            // if they say yes
                            if (switchInput.equalsIgnoreCase("y")) {
                                switchAnswer = true;

                                do { // loops until the the answer is true

                                    System.out.println("What would you like to link " + possibleChars[i] + " with?");
                                    secondInput = keyboard.nextLine();

                                    secondAnswer = determineChar(secondInput.charAt(0)); // uses the first char of the input

                                } while (!secondAnswer);

                                changeBoard(i); // this will switch the board depending on the switch index and this index
                            }

                            else if (switchInput.equalsIgnoreCase("n")) // if they say no
                            {
                                switchAnswer = true;
                            }

                            else {
                                switchAnswer = false;

                                System.out.println("That isn't an option");
                            }

                        } while (!switchAnswer);
                    }
                }
            }

            else if(input.equalsIgnoreCase("n")) // if they don't want to switch the board
            {
                cor = true;
            }

            else
            {
                cor = false;
                System.out.println("That isn't a correct response.");
            }

        } while (!cor);

    }

    private boolean determineChar(char c) // this will determine what char is being asked of
    {
        for (int i = 0; i < 28; i++)  // loops through all of the chars
        {
            if (possibleChars[i] == c && !beenLinked[i]) // if this is the char we're looking for and it hasn't been linked
            {
                switchIndex = i; // because this is the switch index

                beenLinked[i] = true; // because this has now been linked

                return true;
            }

            else if (possibleChars[i] == c && beenLinked[i]) // if its the char but it has been linked
            {
                System.out.println(possibleChars[i] + " has already been linked.");
            }
        }

        return false;
    }

    private void changeBoard(int index) // this will change the board around
    {
        plugBoard[index] = switchIndex;

        plugBoard[switchIndex] = index;

        beenLinked[index] = true;

        beenLinked[switchIndex] = true;
    }

    public int getStart(int index) // this gets the starting position when given the index
    {
        return rotorStart[index];
    }

    public int getRotor(int index) // this will return the rotor at an index
    {
        return rotors[index];
    }

    public int[] getPlugBoard() // returns the connection array
    {
        return plugBoard;
    }

    public int getSwitchIndex() // returns the switch index
    {
        return switchIndex;
    }

    public void printPlugBoard() // to print the connections
    {
        for (int i = 0; i < plugBoard.length; i++) // loops through the plug board array
        {
            System.out.println(plugBoard[i]);
        }
    }

}
