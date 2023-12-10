import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;

import static org.junit.Assert.*;

/**
 * A JUnit test class for the FlightlessBird class.
 */

public class FlightlessBTest {
    EnumMap<Food, Integer> preferredFood = new EnumMap<>(Food.class);
    private FlightlessBird flBirdE;
    private FlightlessBird flBirdK;

    @Before
    public void testConstructor() {
        preferredFood.put(Food.BERRIES, 1);
        preferredFood.put(Food.SEEDS, 2);
        flBirdE = new FlightlessBird(101, BirdType.ENU, "live on the ground", false, 0, preferredFood);
        try {
            flBirdK = new FlightlessBird(102, BirdType.ENU, "live on the ground", true, 2, preferredFood);
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Flightless birds have no wings", e.getMessage());
        }
        flBirdK = new FlightlessBird(102, BirdType.ENU, "live on the ground", true, 0, preferredFood);
    }

    @Test
    public void testUid() {
        assertEquals(101, flBirdE.getUid());
    }

    @Test
    public void testType() {
        assertEquals(BirdType.ENU, flBirdE.getType());
    }

    @Test
    public void testDefiningChar() {
        assertEquals("live on the ground", flBirdE.getDefiningChar());
    }

    @Test
    public void testIsExtinct() {
        assertFalse(flBirdE.isExtinct());
        assertTrue(flBirdK.isExtinct());
    }

    @Test
    public void testNumOfWings() {
        assertEquals(0, flBirdE.getWingsNum());
    }

    @Test
    public void testPreferredFood() {
        preferredFood.put(Food.BERRIES, 1);
        preferredFood.put(Food.SEEDS, 1);
        assertEquals(preferredFood, flBirdE.getPreferredFood());
    }
}
