import java.util.Arrays;

// Defines a pakudex object as an index of pakuri objects.
public class Pakudex {
    private Pakuri[] index;
    private int size; //number of pakuri objects currently in the pakudex

    //Default constructor: Creates index array of length 20
    public Pakudex() {
        index = new Pakuri[20];
        size = 0;
    }

    //Constructs index array of user-specified length
    public Pakudex(int capacity) {
        index = new Pakuri[capacity];
        size = 0;
    }

    //Returns size which is initialized to zero and incremented in addPakuri
    public int getSize() {
        return size;
    }

    //Returns the capacity or length of the Pakudex array.
    public int getCapacity() {
        return index.length;
    }

    //Returns a string array containing the species names of the pakuri as ordered in the index.
    public String[] getSpeciesArray() {
        if (size == 0) {
            return null;
        }
        else {
            String[] speciesNames = new String[size];
            for (int i = 0; i < size; ++i) {
                speciesNames[i] = index[i].getSpecies();
            }

            return speciesNames;
        }
    }

    /*
    Returns an int array containing attack, defense, and speed of the given species. If species is not
    in index, returns null array. Duplicate species cause failure during addSpecies and do not need to
    be accounted for here.
     */
    public int[] getStats(String species) {
        int[] stats = null;
        for (int i = 0; i < size; ++i) {
            if (index[i].getSpecies().compareTo(species) == 0) {
                stats = new int[3];
                stats[0] = index[i].getAttack();
                stats[1] = index[i].getDefense();
                stats[2] = index[i].getSpeed();
            }
        }

        return stats;
    }

    /*
    Uses Arrays.sort and Comparable interface implementation to sort Pakuri objects based on
    species name.
     */
    public void sortPakuri() {
        Arrays.sort(index, 0, size);
    }

    /*
    Adds new Pakuri to the index and increments size. Prints an error message if the Pakuri to be
    added is already in the Pakudex (case ignored).
     */
    public boolean addPakuri(String species) {
        //Prints an error message and ends if species already in Pakudex.
        String[] names = getSpeciesArray();
        if (names != null) {
            for (int i = 0; i < names.length; ++i) {
                if (species.equalsIgnoreCase(names[i])) {
                    System.out.println("Error: Pakudex already contains this species!");
                    return false;
                }
            }
        }

        //Otherwise, adds new Pakuri and increments size.
        index[size] = new Pakuri(species);
        ++size;
        System.out.println("Pakuri species " + species + " successfully added!");
        return true;
    }

    /*
    Evolves the given species using evolve method from Pakuri.java. Prints an error message if the
    Pakuri is not in the Pakudex.
     */
    public boolean evolveSpecies(String species) {
        String[] names = getSpeciesArray();
        if (names == null) {
            System.out.println("Error: No such Pakuri!");
            return false;
        }
        else {
            for (int i = 0; i < names.length; ++i) {
                if (names[i].equals(species)) {
                    index[i].evolve();
                    System.out.println(species + " has evolved!");
                    return true;
                }
            }
            System.out.println("Error: No such Pakuri!");
            return false;
        }
    }
}
