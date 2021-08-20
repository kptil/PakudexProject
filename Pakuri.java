// Defines a Pakuri object by species, attack, defense, and speed.
public class Pakuri implements Comparable<Pakuri> {
    private String species;
    private int attack, defense, speed;

    /*
    Constructor assigns species name and initializes attack, defense, and speed based on species
    name length.
     */
    public Pakuri(String species) {
        this.species = species;
        attack  = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed   = (species.length() * 6) + 13;
    }

    /*
    Four getter methods return the characteristics of the Pakuri object - it's species name and attack,
    defense, and speed values.
     */
    public String getSpecies() {
        return species;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
    public int getSpeed() {
        return speed;
    }

    /*
    Two setter methods - First sets attack to a user specified value; Second evolves the Pakuri object
    by doubling the attack, quadrupling the defense, and tripling the speed.
     */
    public void setAttack(int newAttack) {
        attack = newAttack;
    }
    public void evolve() {
        attack  *= 2;
        defense *= 4;
        speed   *= 3;
    }

    /*
    Implements the compareTo method from the Comparable interface to sort Pakuri objects by
    species name. Allows for the use of Arrays.sort on indices of Pakuri objects.
     */
    @Override
    public int compareTo(Pakuri target) {
        if (this.getSpecies().compareToIgnoreCase(target.getSpecies()) < 0) {
            return -1;
        }
        else if (this.getSpecies().compareToIgnoreCase(target.getSpecies()) == 0) {
            return 0;
        }
        else {
            return 1;
        }
    }

}
