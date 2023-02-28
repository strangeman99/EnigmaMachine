public class Machine {

    private final int NUM_ROTORS = 3; // the number of rotors
    private Rotor[] rotors = new Rotor[NUM_ROTORS]; // an array for the rotors of the class
    private int[] switchBoard; // to hold the switchboard

    public Machine(Rotor rotor1, Rotor rotor2, Rotor rotor3) // the constructor for the class
    {
        // copying the rotors over
        rotors[0] = new Rotor(rotor1);
        rotors[1] = new Rotor(rotor2);
        rotors[2] = new Rotor(rotor3);

        switchBoard = new int[rotors[0].getPlugBoard().length]; // creating a switchboard that is the same length

        for (int i = 0; i < rotors[0].getPlugBoard().length; i++) // copying the board
        {
            switchBoard[i] = rotors[0].getPlugBoard()[i];
        }
    }

    public int[] throughSwitch(int[] message) // this will change the characters
    {
        for (int i = 0; i < message.length; i++)
        {
            int letter = message[i]; // the char being compared
            int switchVal = switchBoard[letter]; // the value of that char in the switchboard

            if (letter != switchVal) // if they are different, change them
            {
                message[i] = switchVal;
            }
        }

        return message; // returning the new array
    }

    public int[] throughRotorsEncode(int[] message) // this will change the characters with the rotors (encode)
    {
        int timesGoneThru = 0;

        for (int i = 0; i < message.length; i++) // this will loop through the input
        {
            message[i] = rotors[0].getConnectionsVal(message[i]); // switching the values

            rotors[0].moveRotorForward(); // moving the rotor one position

            message[i] = rotors[1].getConnectionsVal(message[i]); // switching the values

            double remainder = timesGoneThru % 28.0; // switching

            if (remainder == 0.0) // if it is evenly divided
            {
                rotors[1].moveRotorForward();
            }

            message[i] = rotors[2].getConnectionsVal(message[i]); // switching the values

            double remainder2 = timesGoneThru % 784.0; // setting the new remainder

            if (remainder2 == 0.0) // if the remainder is 0
            {
                rotors[2].moveRotorForward();
            }

            timesGoneThru++; // since it has gone through the rotors once
        }

        return message; // returning the new array
    }

    public int[] throughRotorsDecode(int[] message) // this will change the characters with the rotors (decode)
    {
        int timesGoneThru = 0; // to keep track of the times gone through

        for (int i = 0; i < message.length; i++) // this will loop through the message
        {
            message[i] = rotors[2].getConnectionsDecode(message[i]); // switching the values

            double remainder2 = timesGoneThru % 784.0; // setting the new remainder

            if (remainder2 == 0.0) // if the remainder is 0
            {
                rotors[2].moveRotorForward();
            }

            message[i] = rotors[1].getConnectionsDecode(message[i]); // switching the values

            double remainder = timesGoneThru % 28.0; // setting the new remainder

            if (remainder == 0.0) // if it is evenly divided
            {
                rotors[1].moveRotorForward();
            }

            message[i] = rotors[0].getConnectionsDecode(message[i]); // switching the values

            rotors[0].moveRotorForward(); // moving the rotor one position

            timesGoneThru++;
        }

        return message; // returning the new array
    }

    public void printData(int[] message) // to see what data is being printed
    {
        for (int i = 0; i < message.length; i++) // looping through the whole message
        {
            System.out.println(message[i]);
        }
    }

    public void printSwitchBoard() // to print the switchboard
    {
        for (int i = 0; i < switchBoard.length; i++) // looping through the board
        {
            System.out.println(switchBoard[i]);
        }
    }
}
