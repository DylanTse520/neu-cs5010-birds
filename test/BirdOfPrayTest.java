import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;

import static org.junit.Assert.*;

/**
 * A JUnit test class for the BirdOfPray class.
 */
public class BirdOfPrayTest {
    EnumMap<Food, Integer> preferredFood = new EnumMap<>(Food.class);
    private BirdOfPray birdOfPray;

    @Before
    public void testConstructor() {
        preferredFood.put(Food.BERRIES, 1);
        preferredFood.put(Food.SEEDS, 1);
        try {
            birdOfPray = new BirdOfPray(101, BirdType.HAWK, "sharp, hooked beaks with visible nostrils", false, 3,
                    preferredFood);
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Wings must be odd number", e.getMessage());
        }
        birdOfPray = new BirdOfPray(102, BirdType.HAWK, "sharp, hooked beaks with visible nostrils", false, 2,
                preferredFood);
    }

    @Test
    public void testUid() {
        assertEquals(102, birdOfPray.getUid());
    }

    @Test
    public void testType() {
        assertEquals(BirdType.HAWK, birdOfPray.getType());
    }

    @Test
    public void testDefiningChar() {
        assertEquals("sharp, hooked beaks with visible nostrils", birdOfPray.getDefiningChar());
    }

    @Test
    public void testIsExtinct() {
        assertFalse(String.valueOf(false), birdOfPray.isExtinct());
    }

    @Test
    public void testNumOfWings() {
        assertEquals(2, birdOfPray.getWingsNum());
    }

    @Test
    public void testPreferredFood() {
        preferredFood.put(Food.BERRIES, 1);
        preferredFood.put(Food.SEEDS, 1);
        assertEquals(preferredFood, birdOfPray.getPreferredFood());
    }
}
