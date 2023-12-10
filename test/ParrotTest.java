import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;

import static org.junit.Assert.*;

/**
 * A JUnit test class for the Parrot class.
 */

public class ParrotTest {
    EnumMap<Food, Integer> preferredFood = new EnumMap<>(Food.class);
    private Parrot parrot;

    @Before
    public void testConstructor() {
        preferredFood.put(Food.BERRIES, 1);
        preferredFood.put(Food.BUDS, 2);
        try {
            parrot = new Parrot(101, BirdType.ROSE_RING_PARAKEET, "short, curved beak", false, 2, preferredFood, 1000,
                    "Lovin’ it");
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Parrots can learn up to 100 words", e.getMessage());
        }
        try {
            parrot = new Parrot(101, BirdType.ROSE_RING_PARAKEET, "short, curved beak", false, 2, preferredFood, -1,
                    "Lovin’ it");
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Number of words must not be negative", e.getMessage());
        }
        try {
            parrot = new Parrot(101, BirdType.ROSE_RING_PARAKEET, "short, curved beak", false, 2, preferredFood, 50,
                    null);
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Favourite saying must not be null", e.getMessage());
        }
        parrot = new Parrot(101, BirdType.ROSE_RING_PARAKEET, "short, curved beak", false, 2, preferredFood, 50,
                "Lovin’ it");
    }

    @Test
    public void testUid() {
        assertEquals(101, parrot.getUid());
    }

    @Test
    public void testType() {
        assertEquals(BirdType.ROSE_RING_PARAKEET, parrot.getType());
    }

    @Test
    public void testDefiningChar() {
        assertEquals("short, curved beak", parrot.getDefiningChar());
    }

    @Test
    public void testIsExtinct() {
        assertFalse(parrot.isExtinct());
    }

    @Test
    public void testNumOfWings() {
        assertEquals(2, parrot.getWingsNum());
    }

    @Test
    public void testPreferredFood() {
        preferredFood.put(Food.BERRIES, 1);
        preferredFood.put(Food.BUDS, 2);
        assertEquals(preferredFood, parrot.getPreferredFood());
    }

    @Test
    public void testNumOfWord() {
        assertEquals(50, parrot.getNumOfWords());
    }

    @Test
    public void testFavSaying() {
        assertEquals("Lovin’ it", parrot.getFavSaying());
    }
}
