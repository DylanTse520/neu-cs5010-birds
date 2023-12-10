import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * A JUnit test class for the Shorebird class.
 */

public class ShorebirdTest {
    EnumMap<Food, Integer> preferredFood = new EnumMap<>(Food.class);
    private Shorebird shorebird;

    @Before
    public void testConstructor() {
        preferredFood.put(Food.BERRIES, 1);
        preferredFood.put(Food.OTHER_BIRDS, 2);
        shorebird = new Shorebird(101, BirdType.GREAT_AUK, "live near water sources", false, 2, preferredFood,
                WaterBody.OCEAN);
    }

    @Test
    public void testUid() {
        assertEquals(101, shorebird.getUid());
    }


    @Test
    public void testType() {
        assertEquals(BirdType.GREAT_AUK, shorebird.getType());
    }

    @Test
    public void testDefiningChar() {
        assertEquals("live near water sources", shorebird.getDefiningChar());
    }

    @Test
    public void testIsExtinct() {
        assertFalse(shorebird.isExtinct());
    }

    @Test
    public void testNumOfWings() {
        assertEquals(2, shorebird.getWingsNum());
    }

    @Test
    public void testPreferredFood() {
        preferredFood.put(Food.BERRIES, 1);
        preferredFood.put(Food.OTHER_BIRDS, 2);
        assertEquals(preferredFood, shorebird.getPreferredFood());
    }

    @Test
    public void testLiveBy() {
        assertEquals(WaterBody.OCEAN, shorebird.getLiveBy());
    }
}
