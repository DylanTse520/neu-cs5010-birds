import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * A JUnit test class for the Owl class.
 */

public class OwlTest {
    EnumMap<Food, Integer> preferredFood = new EnumMap<>(Food.class);
    private Owl owl;

    @Before
    public void testConstructor() {
        preferredFood.put(Food.BERRIES, 1);
        preferredFood.put(Food.NUTS, 2);
        owl = new Owl(101, BirdType.OWL, "facial disks that frame the eyes and bill", false, 2, preferredFood);
    }

    @Test
    public void testUid() {assertEquals(101, owl.getUid());}

    @Test
    public void testType() {
        assertEquals(BirdType.OWL, owl.getType());
    }

    @Test
    public void testDefiningChar() {
        assertEquals("facial disks that frame the eyes and bill", owl.getDefiningChar());
    }

    @Test
    public void testIsExtinct() {
        assertFalse(owl.isExtinct());
    }

    @Test
    public void testNumOfWings() {
        assertEquals(2, owl.getWingsNum());
    }

    @Test
    public void testPreferredFood() {
        preferredFood.put(Food.BERRIES, 1);
        preferredFood.put(Food.NUTS, 1);
        assertEquals(preferredFood, owl.getPreferredFood());
    }
}
