package dolphinsPlay;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayDolphinsTests {

    private DolphinsPlay dolphinsPlay;
    private Dolphin dolphin;

    @BeforeEach
    public void setUp() {
        this.dolphinsPlay = new DolphinsPlay("Delphinium", 1);
        this.dolphin = new Dolphin("Watery", "Willy", 10);
    }

    @Test
    public void test_GetDolphins_Returns_UnmodifiableList() {
        dolphinsPlay.addDolphin(dolphin);
        List<Dolphin> dolphins = dolphinsPlay.getDolphins();
        assertThrows(UnsupportedOperationException.class, () -> dolphins.remove(0));
    }

    @Test
    public void test_GetCount_Returns_CorrectSize() {
        assertEquals(0, dolphinsPlay.getCount());
        dolphinsPlay.addDolphin(dolphin);
        assertEquals(1, dolphinsPlay.getCount());
    }

    @Test
    public void test_AddDolphin_ShouldThrow_WhenAddingNull() {
        assertThrows(IllegalArgumentException.class, () -> dolphinsPlay.addDolphin(null));
    }

    @Test
    public void test_AddDolphin_ShouldThrow_WhenCapacityIsFull() {
        dolphinsPlay.addDolphin(dolphin);
        assertThrows(IllegalArgumentException.class, () -> dolphinsPlay.addDolphin(
                new Dolphin("Smart", "Smarty", 13)
        ));
    }

    @Test
    public void test_AddDolphin_ShouldThrow_WhenDuplicatedDolphin() {
        dolphinsPlay.addDolphin(dolphin);
        assertThrows(IllegalArgumentException.class, () -> dolphinsPlay.addDolphin(dolphin));
    }

    @Test
    public void test_RemoveDolphin_ReturnsCorrectBooleanValue() {
        assertFalse(dolphinsPlay.removeDolphin(dolphin.getName()));
        dolphinsPlay.addDolphin(dolphin);
        assertTrue(dolphinsPlay.removeDolphin(dolphin.getName()));
    }

    @Test
    public void test_GetTheDolphinWithTheMaxEnergy_returnsCorrectEntry() {
        DolphinsPlay dolphinsPlay = new DolphinsPlay("test_name", 2);
        dolphinsPlay.addDolphin(new Dolphin("test_type_1", "test_name_1", 13));
        dolphinsPlay.addDolphin(new Dolphin("test_type_2", "test_name_2", 3));
        String name = dolphinsPlay.getTheDolphinWithTheMaxEnergy();
        assertEquals("test_name_1", name);
    }

    @Test
    public void test_GetTheDolphinWithTheMaxEnergy_WithNoEntries() {
        assertThrows(AssertionError.class, () -> dolphinsPlay.getTheDolphinWithTheMaxEnergy());
    }

    @Test
    public void test_SetCapacity_Throws_WithNegativeValue() {
       assertThrows(IllegalArgumentException.class, () -> dolphinsPlay.setCapacity(-1));
    }

    @Test
    public void test_FindAllDolphinsByType_ShouldReturn_CorrectNumberOfEntries() {
        DolphinsPlay dolphinsPlay = new DolphinsPlay("test_name", 4);
        dolphinsPlay.addDolphin(new Dolphin("type_one", "dolcho", 13));
        dolphinsPlay.addDolphin(new Dolphin("type_one", "peshko", 13));
        dolphinsPlay.addDolphin(new Dolphin("type_two", "ivo", 13));
        List<Dolphin> dolphins = dolphinsPlay.findAllDolphinsByType("type_one");
        assertEquals(2, dolphins.size());
    }

}
