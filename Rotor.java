/*create the switchboard and manipulating the switchboard */

public class Rotor {

    // the variables for the class
    final int NUM_OF_CHARACTERS = 28; // a constant for the characters
    private int[] connections;
    private int[] plugBoard;
    private int startingPos;
    private int rotorNum;
    private Settings settings; // this is the current settings

    public Rotor(Settings tempSettings, int rotorPos) // the constructor for the rotor class
    {
        settings = new Settings(tempSettings); // setting the settings object

        plugBoard = settings.getPlugBoard(); // this will set the plug board

        rotorNum = settings.getRotor(rotorPos); // setting the rotor number based on the position its at

        startingPos = settings.getStart(rotorPos); // setting the rotor position

        createRotor(); // this will create the rotor
    }

    public Rotor(Rotor rot) // the copy constructor for the class
    {
        plugBoard = rot.getPlugBoard(); // the plug board
        startingPos = rot.getStartingPos(); // starting position
        rotorNum = rot.getRotorNum(); // the rotor number
        settings = rot.getSettings(); // the settings of the machine

        createRotor(); // creating the rotor (connections)
    }

    private void createRotor() // this will create a rotor depending on the rotor number
    {
        connections = new int[NUM_OF_CHARACTERS]; // initializing the array

        if (rotorNum == 0)
        {
            connections[0] = 14;
            connections[1] = 23;
            connections[2] = 6;
            connections[3] = 12;
            connections[4] = 26;
            connections[5] = 22;
            connections[6] = 2;
            connections[7] = 11;
            connections[8] = 18;
            connections[9] = 3;
            connections[10] = 13;
            connections[11] = 17;
            connections[12] = 21;
            connections[13] = 10;
            connections[14] = 8;
            connections[15] = 25;
            connections[16] = 1;
            connections[17] = 9;
            connections[18] = 7;
            connections[19] = 20;
            connections[20] = 4;
            connections[21] = 0;
            connections[22] = 16;
            connections[23] = 15;
            connections[24] = 24;
            connections[25] = 19;
            connections[26] = 5;
            connections[27] = 27;
        }

        else if (rotorNum == 1)
        {
            connections[0] = 27;
            connections[1] = 13;
            connections[2] = 23;
            connections[3] = 18;
            connections[4] = 20;
            connections[5] = 9;
            connections[6] = 0;
            connections[7] = 12;
            connections[8] = 3;
            connections[9] = 15;
            connections[10] = 24;
            connections[11] = 10;
            connections[12] = 25;
            connections[13] = 14;
            connections[14] = 19;
            connections[15] = 1;
            connections[16] = 16;
            connections[17] = 2;
            connections[18] = 5;
            connections[19] = 26;
            connections[20] = 17;
            connections[21] = 7;
            connections[22] = 22;
            connections[23] = 6;
            connections[24] = 8;
            connections[25] = 21;
            connections[26] = 4;
            connections[27] = 11;
        }

        else if (rotorNum == 2)
        {
            connections[0] = 22;
            connections[1] = 11;
            connections[2] = 10;
            connections[3] = 13;
            connections[4] = 8;
            connections[5] = 0;
            connections[6] = 26;
            connections[7] = 1;
            connections[8] = 3;
            connections[9] = 20;
            connections[10] = 27;
            connections[11] = 16;
            connections[12] = 25;
            connections[13] = 23;
            connections[14] = 17;
            connections[15] = 21;
            connections[16] = 12;
            connections[17] = 6;
            connections[18] = 9;
            connections[19] = 5;
            connections[20] = 2;
            connections[21] = 7;
            connections[22] = 14;
            connections[23] = 15;
            connections[24] = 19;
            connections[25] = 4;
            connections[26] = 18;
            connections[27] = 24;
        }

        else if (rotorNum == 3)
        {
            connections[0] = 2;
            connections[1] = 16;
            connections[2] = 26;
            connections[3] = 11;
            connections[4] = 14;
            connections[5] = 7;
            connections[6] = 10;
            connections[7] = 27;
            connections[8] = 21;
            connections[9] = 9;
            connections[10] = 0;
            connections[11] = 1;
            connections[12] = 19;
            connections[13] = 6;
            connections[14] = 20;
            connections[15] = 23;
            connections[16] = 15;
            connections[17] = 18;
            connections[18] = 9;
            connections[19] = 3;
            connections[20] = 22;
            connections[21] = 17;
            connections[22] = 24;
            connections[23] = 4;
            connections[24] = 25;
            connections[25] = 13;
            connections[26] = 5;
            connections[27] = 12;
        }

        else if (rotorNum == 4)
        {
            connections[0] = 15;
            connections[1] = 23;
            connections[2] = 7;
            connections[3] = 1;
            connections[4] = 12;
            connections[5] = 14;
            connections[6] = 8;
            connections[7] = 19;
            connections[8] = 22;
            connections[9] = 25;
            connections[10] = 11;
            connections[11] = 26;
            connections[12] = 17;
            connections[13] = 0;
            connections[14] = 9;
            connections[15] = 24;
            connections[16] = 20;
            connections[17] = 10;
            connections[18] = 21;
            connections[19] = 27;
            connections[20] = 5;
            connections[21] = 4;
            connections[22] = 6;
            connections[23] = 18;
            connections[24] = 3;
            connections[25] = 16;
            connections[26] = 2;
            connections[27] = 13;
        }

        else
        {
            for (int i = 0; i < NUM_OF_CHARACTERS; i++)
            {
                connections[i] = 0;
            }
        }
    }

    public void moveRotorForward() // this will move the rotor one position forward
    {
        int temp = connections[27]; // setting a temp for the last index

        for (int i = NUM_OF_CHARACTERS - 1; i > 0; i--) // loops backwards
        {
            connections[i] = connections[i - 1]; // moving all of the index's
        }

        connections[0] = temp; // making the first index equal to the temp
    }

    public void moveRotorBackward() // this will move the rotor one position backward
    {
        int temp = connections[0]; // setting a temp for the last index

        for (int i = 0; i < NUM_OF_CHARACTERS; i++) // loops forwards
        {
            connections[i] = connections[i + 1]; // moving the index's
        }

        connections[27] = temp; // making the last index equal to temp
    }

    public void putInStart() // to put the rotor in its starting position
    {
        int value = connections[startingPos];
        boolean found = false;

        do
        {
            if (connections[0] != value) // if the values don't equal, move the rotor
            {
                moveRotorForward();

                found = false;
            }

            else // if it is found
            {
                found = true;
            }

        } while (!found); // loops until found
    }

    public int[] getPlugBoard() // returns the connections
    {
        return plugBoard;
    }

    public int getStartingPos() // returns the starting pos
    {
        return startingPos;
    }

    public int getRotorNum() // returns the rotor num
    {
        return rotorNum;
    }

    public Settings getSettings() // returns the settings of the class
    {
        return settings;
    }

    public int[] getConnections() // returns the connections array
    {
        return connections;
    }

    public int getConnectionsVal(int index)// returns a value of the array at that index
    {
        return connections[index];
    }

    public void printPlugBoard() // to print the plug board to the screen
    {
        for (int i = 0; i < plugBoard.length; i++) // loops through the plug board array
        {
            System.out.println(plugBoard[i]);
        }
    }

    public int getConnectionsDecode(int val) // this will return the index that the value is at
    {
        for (int i = 0; i < NUM_OF_CHARACTERS; i++) // this will loop through the connections
        {
            if (connections[i] == val) // if that value is at this index
            {
                return i; // returning the index
            }
        }

        return 0;
    }
}

