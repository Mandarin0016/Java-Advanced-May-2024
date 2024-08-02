package rpg_lab;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HeroTest {

    @Test
    public void test_HeroGainsExp_When_TargetIsDead() {
        Axe axe = mock(Axe.class);
        Hero hero = new Hero("Pesho", axe);
        Dummy dummy = mock(Dummy.class);
        int exp = 13;
        when(dummy.giveExperience()).thenReturn(exp);
        when(dummy.isDead()).thenReturn(true);
        hero.attack(dummy);
        assertEquals(exp, hero.getExperience());
    }

}