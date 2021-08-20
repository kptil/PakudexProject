/*
Pakudex driver class with main() entry point.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class PakuriProgram {

    //Prints the Pakudex menu in a separate method to simplify the code in main.
    public static void printMenu() {
        String title = "Pakudex Main Menu";
        System.out.println();
        System.out.println(title);
        for (int i = 0; i < title.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("1. List Pakuri");
        System.out.println("2. Show Pakuri");
        System.out.println("3. Add Pakuri");
        System.out.println("4. Evolve Pakuri");
        System.out.println("5. Sort Pakuri");
        System.out.println("6. Exit");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int capacity = 0;
        boolean validCapacity = false;

        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");

        /*
        Tests for valid capacity input and catches errors if input is not an integer or is below 1. When
        scnr.nextInt() throws an InputMismatchException, the token that caused the error is not 'dealt with'
        or properly read from the scanner, so the code keeps trying to read the same token. Using scnr.next()
        in the catch statement reads the problematic input without generating an error, and so it is dealt
        with and removed from the stream, and the next call to scnr.nextInt() asks for new input.
         */
        while (!validCapacity) {
            try {
                System.out.print("Enter max capacity of the Pakudex: ");
                capacity = scnr.nextInt();
                if (capacity < 1) {
                    throw new Exception("Please enter a valid size.");
                }
                validCapacity = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid size.");
                scnr.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("The Pakudex can hold " + capacity + " species of Pakuri.");

        //Creates the Pakudex and initializes menu choice
        Pakudex myPakudex = new Pakudex(capacity);
        int menuChoice = 0;

        /*
        Executes Pakudex operations based on user input. Catches exceptions and asks for input again
        if user enters a non-integer or a number outside the range 1-6. Loop exits when user enters 6.
        The catch clauses reset menuChoice to zero so none of the if statements specifying Pakudex
        operations run based on the last valid input.
         */
        while (menuChoice != 6) {
            try{
                printMenu();
                System.out.print("What would you like to do? ");
                menuChoice = scnr.nextInt();
                if ((menuChoice < 1) || (menuChoice > 6)) {
                    throw new Exception("Unrecognized menu selection!");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Unrecognized menu selection!");
                scnr.next();
                menuChoice = 0;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                menuChoice = 0;
            }
            //Lists Pakuri names in current Pakudex order. Prints error message if no Pakuri.
            if (menuChoice == 1) {
                String[] speciesNames = myPakudex.getSpeciesArray();
                if (speciesNames == null) {
                    System.out.println("No Pakuri in Pakudex yet!");
                }
                else {
                    System.out.println("Pakuri In Pakudex:");
                    for (int i = 0; i < speciesNames.length; i++) {
                        System.out.println((i + 1) + ". " + speciesNames[i]);
                    }
                }

            }
            /*
            Prints the attack, defense, and speed for a given Pakuri species. Prints error if given
            species name is not in the Pakudex.
             */
            if (menuChoice == 2) {
                System.out.print("Enter the name of the species to display: ");
                String speciesName = scnr.next();
                int[] speciesStats = myPakudex.getStats(speciesName);
                if (speciesStats == null) {
                    System.out.println("Error: No such Pakuri!");
                }
                else {
                    System.out.println();
                    System.out.println("Species: " + speciesName);
                    for (int i = 0; i < speciesStats.length; i++) {
                        switch (i) {
                            case 0:
                                System.out.println("Attack: " + speciesStats[0]);
                                break;
                            case 1:
                                System.out.println("Defense: " + speciesStats[1]);
                                break;
                            case 2:
                                System.out.println("Speed: " + speciesStats[2]);
                                break;
                        }
                    }
                }
            }
            /*
            Adds new Pakuri to the Pakudex. Prints error message if Pakudex is full or if the Pakuri
            has already been added (this is implemented in Pakudex.java method). Case is ignored when
            comparing species' names.
             */
            if (menuChoice == 3) {
                if (myPakudex.getCapacity() == myPakudex.getSize()) {
                    System.out.println("Error: Pakudex is full!");
                }
                else {
                    System.out.print("Enter the name of the species to add: ");
                    String newSpecies = scnr.next();
                    myPakudex.addPakuri(newSpecies);
                }

            }
            //Evolves the given Pakuri if it exists in the Pakudex.
            if (menuChoice == 4) {
                System.out.print("Enter the name of the species to evolve: ");
                String evolveSpecies = scnr.next();
                myPakudex.evolveSpecies(evolveSpecies);
            }
            //Sorts the Pakudex in alphabetical order by species name.
            if (menuChoice == 5) {
                myPakudex.sortPakuri();
                System.out.println("Pakuri have been sorted!");
            }
        }

        System.out.println("Thanks for using Pakudex! Bye!");
    }
}
