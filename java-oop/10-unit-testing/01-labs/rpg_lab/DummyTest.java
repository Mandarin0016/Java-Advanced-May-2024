package rpg_lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DummyTest {
    private static final int HEALTH = 100;
    private static final int EXP = 13;
    private static final int ATTACK = 21;
    private Dummy dummy;
    private Dummy deadDummy;

    @BeforeEach
    public void setUp() {
        this.dummy = new Dummy(HEALTH, EXP);
        this.deadDummy = new Dummy(0, EXP);
    }

    @Test
    public void test_DummyLoosesHealth_WhenAttacked() {
        dummy.takeAttack(ATTACK);
        int expectedHealth = HEALTH - ATTACK;
        assertEquals(expectedHealth, dummy.getHealth());
    }

    @Test
    public void test_DummyGiveExp_Throws_WhenAlive() {
        IllegalStateException ex = assertThrows(IllegalStateException.class, dummy::giveExperience);
        assertEquals("Target is not dead.", ex.getMessage());
    }

    @Test
    public void test_DeadDummy_Throws_WhenAttacked() {
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> deadDummy.takeAttack(ATTACK));
        assertEquals("Dummy is dead.", ex.getMessage());
    }

    @Test
    public void test_DeadDummy_GivesEXP() {
        assertEquals(EXP, deadDummy.giveExperience());
    }

}