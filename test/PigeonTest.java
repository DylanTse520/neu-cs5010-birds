import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * A JUnit test class for the Pigeon class.
 */

public class PigeonTest {
    EnumMap<Food, Integer> preferredFood = new EnumMap<>(Food.class);
    private Pigeon pigeon;

    @Before
    public void testConstructor() {
        preferredFood.put(Food.BERRIES, 1);
        preferredFood.put(Food.FISH, 2);
        pigeon = new Pigeon(101, BirdType.PIGEON, "feeding their young \"bird milk\"", true, 2, preferredFood);
    }

    @Test
    public void testUid() {
        assertEquals(101, pigeon.getUid());
    }

    @Test
    public void testType() {
        assertEquals(BirdType.PIGEON, pigeon.getType());
    }

    @Test
    public void testDefiningChar() {
        assertEquals("feeding their young \"bird milk\"", pigeon.getDefiningChar());
    }

    @Test
    public void testIsExtinct() {
        assertTrue(pigeon.isExtinct());
    }

    @Test
    public void testNumOfWings() {
        assertEquals(2, pigeon.getWingsNum());
    }

    @Test
    public void testPreferredFood() {
        preferredFood.put(Food.BERRIES, 1);
        preferredFood.put(Food.FISH, 2);
        assertEquals(preferredFood, pigeon.getPreferredFood());
    }
}
