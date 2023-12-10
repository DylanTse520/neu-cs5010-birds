import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.EnumMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This class is to test an aviary. It contains an aviary and several predefined birds.
 * */
public class AviaryTest {

    EnumMap<Food, Integer> preferredFood = new EnumMap<>(Food.class) {{
        put(Food.BERRIES, 1);
        put(Food.BUDS, 2);
    }};
    Bird roseRingParakeet = new Parrot(101, BirdType.ROSE_RING_PARAKEET, "short, curved beak", false, 2, preferredFood,
            50, "Lovin’ it");
    Bird grayParrot = new Parrot(102, BirdType.GRAY_PARROT, "short, curved beak", false, 2, preferredFood, 50, "Lovin" +
            "’" +
            " it");
    Bird sulfurCrestedCockatoo = new Parrot(103, BirdType.SULFUR_CRESTED_COCKATOO, "short, curved beak", false, 2,
            preferredFood, 50, "Lovin’" +
            " it");
    Bird owl = new Owl(201, BirdType.OWL, "facial disks that frame the eyes and bill", false, 2, preferredFood);
    Bird pigeon = new Pigeon(301, BirdType.PIGEON, "feeding their young \"bird milk\"", false, 2, preferredFood);
    Bird enu = new FlightlessBird(401, BirdType.ENU, "live on the ground", false, 0, preferredFood);
    Bird hawk = new BirdOfPray(501, BirdType.HAWK, "sharp, hooked beaks with visible nostrils", false, 2,
            preferredFood);
    Bird duck = new Waterfowl(601, BirdType.DUCK, "live near water sources", false, 2, preferredFood,
            WaterBody.FRESHWATER_SHORELAND);

    private Aviary aviary;

    /**
     * To set up the aviary.
     * */
    @Before
    public void setUp() {
        this.aviary = new Aviary(1, "Position (0, 1)");
    }

    /**
     * To test the unique id.
     * */
    @Test
    public void testUid() {
        assertEquals((Integer) 1, aviary.getUid());
    }

    /**
     * To test the constructor with null input for location. Expect exception to be thrown.
     * */
    @Test
    public void testConstructorExceptionThrownWithNullValue() {
        try {
            new Aviary(1, null);
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Location should not be null", e.getMessage());
        }
    }

    /**
     * To test the location of the aviary.
     * */
    @Test
    public void testLocation() {
        assertEquals("Position (0, 1)", aviary.getLocation());
    }

    /**
     * To test assigning birds. The first bird is ordinary bird. The following unique birds cannot be assigned here.
     * When exceeding 5 birds, no more birds could be assigned.
     * */
    @Test
    public void testAssignBirdWithAverageBirds() {

        try {
            assertEquals(false, aviary.assignBird(null));
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Bird should not be null", e.getMessage());
        }
        try {
            Bird moa = new FlightlessBird(402, BirdType.MOA, "live on the ground", true, 0, preferredFood);
            aviary.assignBird(moa);
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Bird should not be extinct", e.getMessage());
        }

        assertEquals(true, aviary.assignBird(roseRingParakeet));
        assertEquals(false, aviary.assignBird(enu));
        assertEquals(false, aviary.assignBird(hawk));
        assertEquals(false, aviary.assignBird(duck));
        assertEquals(true, aviary.assignBird(grayParrot));
        assertEquals(true, aviary.assignBird(sulfurCrestedCockatoo));
        assertEquals(true, aviary.assignBird(owl));
        assertEquals(true, aviary.assignBird(pigeon));

        Bird shorebird = new Shorebird(602, BirdType.GREAT_AUK, "live near water sources", false, 2, preferredFood,
                WaterBody.OCEAN);
        assertEquals(false, aviary.assignBird(shorebird));
    }

    /**
     * To test assigning birds. The first bird is a unique bird. The following other birds could not be assigned. The
     * following same category bird could be assigned.
     * */
    @Test
    public void testAssignBirdWithExclusiveBirds() {
        assertEquals(true, aviary.assignBird(enu));
        assertEquals(false, aviary.assignBird(hawk));
        assertEquals(false, aviary.assignBird(duck));
        assertEquals(false, aviary.assignBird(grayParrot));

        Bird kiwi = new FlightlessBird(403, BirdType.KIWI, "live on the ground", false, 0, preferredFood);
        assertEquals(true, aviary.assignBird(kiwi));
    }

    /**
     * To test getting bird list.
     * */
    @Test
    public void testGetBirds() {
        ArrayList<Bird> emptyBirdArray = new ArrayList<>();
        assertEquals(emptyBirdArray, aviary.getBirds());

        ArrayList<Bird> fiverBirdsArray = new ArrayList<>() {{
            add(roseRingParakeet);
            add(grayParrot);
            add(sulfurCrestedCockatoo);
            add(owl);
            add(pigeon);
        }};
        initAviaryWithBirds();
        assertEquals(fiverBirdsArray, aviary.getBirds());
    }

    /**
     * To test getting food needed map.
     * */
    @Test
    public void testGetNeededFood() {
        EnumMap<Food, Integer> foodMap = new EnumMap<>(Food.class) {{
            put(Food.BERRIES, 5);
            put(Food.BUDS, 10);
        }};
        initAviaryWithBirds();
        assertEquals(foodMap, aviary.getNeededFood());
    }

    /**
     * To test finding a bird in the aviary.
     * */
    @Test
    public void testBirdInAviary() {
        initAviaryWithBirds();
        assertEquals(true, aviary.isBirdInAviary(roseRingParakeet));
        assertEquals(false, aviary.isBirdInAviary(enu));
    }

    /**
     * To test describing the aviary.
     * */
    @Test
    public void testDescribeAviary() {
        initAviaryWithBirds();
        String expectedOutput = """
                This aviary houses 5 birds.
                Bird NO.1 is rose ring parakeet. Its defining characteristic is short, curved beak. It speaks 50 words. Its favourite saying is "Lovin’ it".
                Bird NO.2 is gray parrot. Its defining characteristic is short, curved beak. It speaks 50 words. Its favourite saying is "Lovin’ it".
                Bird NO.3 is sulfur crested cockatoo. Its defining characteristic is short, curved beak. It speaks 50 words. Its favourite saying is "Lovin’ it".
                Bird NO.4 is owl. Its defining characteristic is facial disks that frame the eyes and bill.
                Bird NO.5 is pigeon. Its defining characteristic is feeding their young "bird milk".""";
        assertEquals(expectedOutput, aviary.describeAviary());
    }

    private void initAviaryWithBirds() {
        assertEquals(true, aviary.assignBird(roseRingParakeet));
        assertEquals(true, aviary.assignBird(grayParrot));
        assertEquals(true, aviary.assignBird(sulfurCrestedCockatoo));
        assertEquals(true, aviary.assignBird(owl));
        assertEquals(true, aviary.assignBird(pigeon));
    }

}
