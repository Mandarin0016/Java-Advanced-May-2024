package rpg_lab;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static rpg_lab.Axe.DURABILITY_LOST;

public class AxeTest {

    private static final Dummy DUMMY = mock(Dummy.class);
    private static final int ATTACK = 10;
    private static final int DURABILITY = 50;

    @Test
    public void test_AxeLoosesDurability_OnAttack() {
        // A - Arrange
        Axe axe = new Axe(ATTACK, DURABILITY);
        // A - Act
        axe.attack(DUMMY);
        // A - Assert
        assertEquals(DURABILITY - DURABILITY_LOST, axe.getDurabilityPoints());
    }

    @Test
    public void test_AxeAttack_WhenBroken_Throws() {
        Axe brokenAxe = new Axe(10, 0);
        IllegalStateException ex =
                assertThrows(IllegalStateException.class, () -> brokenAxe.attack(DUMMY));
        assertEquals("Axe is broken.", ex.getMessage());
    }

    @Disabled
    @Test
    public void test_Mockito_Demo() {
        Dummy dummy = mock(Dummy.class);
        when(dummy.giveExperience()).thenReturn(13);
        when(dummy.isDead()).thenReturn(true);
    }

}
