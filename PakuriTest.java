import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PakuriTest {

    Pakuri test = new Pakuri("speciesName");

    @Test
    public void getSpeciesTest() {
        String expectedName = "speciesName";
        assertEquals(expectedName, test.getSpecies());
    }

    @Test
    public void getAttackTest() {
        int expected = 86;
        assert expected == test.getAttack();
    }

    @Test
    public void getDefenseTest() {
        int expected = 72;
        assert expected == test.getDefense();
    }

    @Test
    public void getSpeedTest() {
        int expected = 79;
        assert expected == test.getSpeed();
    }

    @Test
    public void setAttackTest() {
        int newAttack = 115;
        test.setAttack(115);
        assert newAttack == test.getAttack();
    }

    @Test
    public void evolveTestAttack() {
        test.evolve();
        int expectedAttack = 172;
        assert expectedAttack == test.getAttack();
    }

    @Test
    public void evolveTestDefense() {
        test.evolve();
        int expectedDefense = 288;
        assert expectedDefense == test.getDefense();
    }

    @Test
    public void evolveTestSpeed() {
        test.evolve();
        int expectedSpeed = 237;
        assert expectedSpeed == test.getSpeed();
    }

    @Test
    public void compareToTest1() {
        Pakuri test = new Pakuri("Charasaurus");
        Pakuri target = new Pakuri("Pikabu");
        assert -1 == test.compareTo(target);
    }

    @Test
    public void compareToTest2() {
        Pakuri test = new Pakuri("PsyGoose");
        Pakuri target = new Pakuri("Pikabu");
        assert 1 == test.compareTo(target);
    }

    @Test
    public void compareToTest3() {
        Pakuri test = new Pakuri("PsyGoose");
        Pakuri target = new Pakuri("Psygoose");
        assert 0 == test.compareTo(target);
    }
}
