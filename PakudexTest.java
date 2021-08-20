import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PakudexTest {
    //Tests with empty Pakudex.

    @Test
    public void addPakuriTestSimple() {
        Pakudex test = new Pakudex(3);
        assert test.addPakuri("PsyGoose");
    }

    @Test
    public void getSizeTest1() {
        Pakudex test = new Pakudex(3);
        assert 0 == test.getSize();
    }

    @Test
    public void getCapacityTest1() {
        Pakudex test = new Pakudex(3);
        assert 3 == test.getCapacity();
    }

    @Test
    public void getSpeciesArrayTest1() {
        Pakudex test = new Pakudex(3);
        String[] expected = null;
        assertArrayEquals(expected, test.getSpeciesArray());
    }

    @Test
    public void getStatsTest1() {
        Pakudex test = new Pakudex(3);
        int[] expected = null;
        assertArrayEquals(expected, test.getStats("PsyGoose"));
    }

    //No test for sortPakuri

    @Test
    public void evolveSpeciesTest1() {
        Pakudex test = new Pakudex(3);
        assert !test.evolveSpecies("PsyGoose");
    }

    //Tests with partly full Pakudex.

    @Test
    public void addPakuriTestDuplicate() {
        Pakudex test = new Pakudex(3);
        boolean firstAdd = test.addPakuri("PsyGoose");
        assert !test.addPakuri("PsyGoose");
    }

    @Test
    public void getSizeTest2() {
        Pakudex test = new Pakudex(3);
        boolean firstAdd = test.addPakuri("PsyGoose");
        assert 1 == test.getSize();
    }

    @Test
    public void getSpeciesArrayTest2() {
        Pakudex test = new Pakudex(3);
        boolean firstAdd = test.addPakuri("PsyGoose");
        String[] expected = {"PsyGoose"};
        assertArrayEquals(expected, test.getSpeciesArray());
    }

    @Test
    public void getStatsTest2() {
        Pakudex test = new Pakudex(3);
        boolean firstAdd = test.addPakuri("PsyGoose");
        int[] expected = {65, 57, 61};
        assertArrayEquals(expected, test.getStats("PsyGoose"));
    }

    @Test
    public void sortPakuriTest2() {
        Pakudex test = new Pakudex(3);
        boolean testAdd = test.addPakuri("PsyGoose");
        test.sortPakuri();
        Pakudex expected = new Pakudex(3);
        boolean expAdd = expected.addPakuri("PsyGoose");
        assertArrayEquals(test.getSpeciesArray(), expected.getSpeciesArray());
    }

    //Tests with full Pakudex.

    @Test
    public void addPakuriTestFull() {
        Pakudex test = new Pakudex(3);
        boolean firstAdd = test.addPakuri("PsyGoose");
        boolean secondAdd = test.addPakuri("Charasaurus");
        boolean thirdAdd = test.addPakuri("Pikabu");
        assert !test.addPakuri("Pikaju");
    }

    @Test
    public void getSizeTest3() {
        Pakudex test = new Pakudex(3);
        boolean firstAdd = test.addPakuri("PsyGoose");
        boolean secondAdd = test.addPakuri("Charasaurus");
        boolean thirdAdd = test.addPakuri("Pikabu");
        assert 3 == test.getSize();
    }

    @Test
    public void getSpeciesArrayTest3() {
        Pakudex test = new Pakudex(3);
        boolean firstAdd = test.addPakuri("PsyGoose");
        boolean secondAdd = test.addPakuri("Charasaurus");
        boolean thirdAdd = test.addPakuri("Pikabu");
        String[] expected = {"PsyGoose", "Charasaurus", "Pikabu"};
        assertArrayEquals(expected, test.getSpeciesArray());
    }

    @Test
    public void getStatsTest3() {
        Pakudex test = new Pakudex(3);
        boolean firstAdd = test.addPakuri("PsyGoose");
        boolean secondAdd = test.addPakuri("Charasaurus");
        boolean thirdAdd = test.addPakuri("Pikabu");
        int[] expected = {51, 47, 49};
        assertArrayEquals(expected, test.getStats("Pikabu"));
    }

    @Test
    public void getStatsTest4() {
        Pakudex test = new Pakudex(3);
        boolean firstAdd = test.addPakuri("PsyGoose");
        boolean secondAdd = test.addPakuri("Charasaurus");
        boolean thirdAdd = test.addPakuri("Pikabu");
        int[] expected = null;
        assertArrayEquals(expected, test.getStats("Pikaju"));
    }

    @Test
    public void sortPakuriTest3() {
        Pakudex test = new Pakudex(3);
        boolean firstAdd = test.addPakuri("PsyGoose");
        boolean secondAdd = test.addPakuri("Charasaurus");
        boolean thirdAdd = test.addPakuri("Pikabu");
        test.sortPakuri();
        Pakudex expected = new Pakudex(3);
        boolean expAdd1 = expected.addPakuri("Charasaurus");
        boolean expAdd2 = expected.addPakuri("Pikabu");
        boolean expAdd3 = expected.addPakuri("PsyGoose");
        assertArrayEquals(test.getSpeciesArray(), expected.getSpeciesArray());
    }

}
