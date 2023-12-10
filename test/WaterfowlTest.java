import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * A JUnit test class for the Waterfowl class.
 */

public class WaterfowlTest {
    EnumMap<Food, Integer> preferredFood = new EnumMap<>(Food.class);
    private Waterfowl waterfowl;

    @Before
    public void testConstructor() {
        preferredFood.put(Food.BERRIES, 1);
        preferredFood.put(Food.FISH, 2);
        waterfowl = new Waterfowl(101, BirdType.DUCK, "live near water sources", false, 2, preferredFood,
                WaterBody.FRESHWATER_SHORELAND);
    }

    @Test
    public void testUid() {
        assertEquals(101, waterfowl.getUid());
    }


    @Test
    public void testType() {
        assertEquals(BirdType.DUCK, waterfowl.getType());
    }

    @Test
    public void testDefiningChar() {
        assertEquals("live near water sources", waterfowl.getDefiningChar());
    }

    @Test
    public void testIsExtinct() {
        assertFalse(waterfowl.isExtinct());
    }

    @Test
    public void testNumOfWings() {
        assertEquals(2, waterfowl.getWingsNum());
    }

    @Test
    public void testPreferredFood() {
        preferredFood.put(Food.BERRIES, 1);
        preferredFood.put(Food.FISH, 2);
        assertEquals(preferredFood, waterfowl.getPreferredFood());
    }

    @Test
    public void testLiveBy() {
        assertEquals(WaterBody.FRESHWATER_SHORELAND, waterfowl.getLiveBy());
    }
}
