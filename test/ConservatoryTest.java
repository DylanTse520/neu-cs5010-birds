import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;

import static org.junit.Assert.*;

/**
 * This class is to test a conservatory. It contains a conservatory and several predefined birds.
 * */
public class ConservatoryTest {

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
    Bird extinctPigeon = new Pigeon(302, BirdType.PIGEON, "feeding their young \"bird milk\"", true, 2, preferredFood);
    Bird enu = new FlightlessBird(401, BirdType.ENU, "live on the ground", false, 0, preferredFood);
    Bird kiwi = new FlightlessBird(402, BirdType.KIWI, "live on the ground", false, 0, preferredFood);
    Bird moa = new FlightlessBird(403, BirdType.MOA, "live on the ground", true, 0, preferredFood);
    Bird hawk = new BirdOfPray(501, BirdType.HAWK, "sharp, hooked beaks with visible nostrils", false, 2,
            preferredFood);
    Bird eagle = new BirdOfPray(502, BirdType.EAGLE, "sharp, hooked beaks with visible nostrils", false, 2,
            preferredFood);
    Bird osprey = new BirdOfPray(503, BirdType.OSPREY, "sharp, hooked beaks with visible nostrils", false, 2,
            preferredFood);
    Bird duck = new Waterfowl(601, BirdType.DUCK, "live near water sources", false, 2, preferredFood,
            WaterBody.FRESHWATER_SHORELAND);
    Bird swan = new Waterfowl(602, BirdType.SWAN, "live near water sources", false, 2, preferredFood,
            WaterBody.FRESHWATER_SHORELAND);
    Bird geese = new Waterfowl(603, BirdType.GEESE, "live near water sources", false, 2, preferredFood,
            WaterBody.FRESHWATER_SHORELAND);
    Bird greatAuk = new Shorebird(701, BirdType.GREAT_AUK, "live near water sources", false, 2, preferredFood,
            WaterBody.FRESHWATER_SHORELAND);
    Bird hornedPuffin = new Shorebird(702, BirdType.HORNED_PUFFIN, "live near water sources", false, 2, preferredFood,
            WaterBody.FRESHWATER_SHORELAND);
    Bird africanJacana = new Shorebird(703, BirdType.AFRICAN_JACANA, "live near water sources", false, 2, preferredFood,
            WaterBody.FRESHWATER_SHORELAND);


    private Conservatory conservatory;

    /**
     * To set up the conservatory.
     * */
    @Before
    public void setUp() {
        this.conservatory = new Conservatory();
    }

    /**
     * To test rescuing birds with normal cases.
     * */
    @Test
    public void testRescueBirdWithNormalCases() {
        initConservatory();
        assertEquals(defaultBirdIndex(), conservatory.listBirds());
    }

    /**
     * To test rescuing birds with bird being null or extincted.
     * */
    @Test
    public void testRescueBirdWithAbnormalCases() {
        try {
            conservatory.rescueBird(null);
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Bird should not be null", e.getMessage());
        }
        try {
            conservatory.rescueBird(extinctPigeon);
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Bird should not be extinct", e.getMessage());
        }
    }

    /**
     * To test rescuing birds with more than 100 birds.
     * */
    @Test
    public void testRescueBirdWithExceedingCapacityCases() {
        for (int i = 0; i < 100; i++) {
            Bird shorebird = new Shorebird(i, BirdType.GREAT_AUK, "live near water sources", false, 2, preferredFood,
                    WaterBody.FRESHWATER_SHORELAND);
            conservatory.rescueBird(shorebird);
        }

        try {
            conservatory.rescueBird(greatAuk);
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Conservatory exceeds capacity", e.getMessage());
        }
    }

    /**
     * To test getting needed food.
     * */
    @Test
    public void testNeededFood() {
        EnumMap<Food, Integer> foodMap = new EnumMap<>(Food.class) {{
            put(Food.BUDS, 24);
            put(Food.BERRIES, 12);
        }};
        initConservatory();
        assertEquals(foodMap, conservatory.getNeededFood());
    }

    /**
     * To test finding bird with normal cases.
     * */
    @Test
    public void testFindBirdWithNormalCases() {
        initConservatory();
        assertEquals((Integer) 1, conservatory.findBird(roseRingParakeet));
    }

    /**
     * To test finding bird with null input or not existing bird.
     * */
    @Test
    public void testFindBirdWithAbnormalCases() {
        initConservatory();
        assertNull(conservatory.findBird(moa));
        try {
            conservatory.findBird(null);
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Bird should not be null", e.getMessage());
        }
    }

    /**
     * To test describing an aviary.
     * */
    @Test
    public void testDescribeAviary() {
        initConservatory();
        assertEquals("""
                This aviary houses 5 birds.
                Bird NO.1 is rose ring parakeet. Its defining characteristic is short, curved beak. It speaks 50 words. Its favourite saying is "Lovin’ it".
                Bird NO.2 is owl. Its defining characteristic is facial disks that frame the eyes and bill.
                Bird NO.3 is gray parrot. Its defining characteristic is short, curved beak. It speaks 50 words. Its favourite saying is "Lovin’ it".
                Bird NO.4 is sulfur crested cockatoo. Its defining characteristic is short, curved beak. It speaks 50 words. Its favourite saying is "Lovin’ it".
                Bird NO.5 is pigeon. Its defining characteristic is feeding their young "bird milk".""", conservatory.describeAviary(1));
        try {
            conservatory.describeAviary(22);
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Aviary id should be within 1 to 20", e.getMessage());
        }
    }

    /**
     * To test listing all aviaries.
     * */
    @Test
    public void testListAviaries() {
        initConservatory();
        assertEquals("""
                Aviary 1 Position (0, 0) rose ring parakeet, owl, gray parrot, sulfur crested cockatoo, pigeon
                Aviary 2 Position (0, 1) enu, kiwi
                Aviary 3 Position (0, 2) hawk, eagle
                Aviary 4 Position (0, 3) duck, swan
                Aviary 5 Position (0, 4) great auk
                Aviary 6 Position (1, 0)\s
                Aviary 7 Position (1, 1)\s
                Aviary 8 Position (1, 2)\s
                Aviary 9 Position (1, 3)\s
                Aviary 10 Position (1, 4)\s
                Aviary 11 Position (2, 0)\s
                Aviary 12 Position (2, 1)\s
                Aviary 13 Position (2, 2)\s
                Aviary 14 Position (2, 3)\s
                Aviary 15 Position (2, 4)\s
                Aviary 16 Position (3, 0)\s
                Aviary 17 Position (3, 1)\s
                Aviary 18 Position (3, 2)\s
                Aviary 19 Position (3, 3)\s
                Aviary 20 Position (3, 4)\s""", conservatory.listAviaries());
    }

    /**
     * To test listing all the birds.
     * */
    @Test
    public void testListBirds() {
        initConservatory();
        assertEquals(defaultBirdIndex(), conservatory.listBirds());
    }

    private void initConservatory() {
        conservatory.rescueBird(roseRingParakeet);
        conservatory.rescueBird(owl);
        conservatory.rescueBird(enu);
        conservatory.rescueBird(hawk);
        conservatory.rescueBird(duck);
        conservatory.rescueBird(grayParrot);
        conservatory.rescueBird(sulfurCrestedCockatoo);
        conservatory.rescueBird(pigeon);
        conservatory.rescueBird(kiwi);
        conservatory.rescueBird(eagle);
        conservatory.rescueBird(swan);
        conservatory.rescueBird(greatAuk);
    }

    private String defaultBirdIndex() {
        return """
                Duck Position (0, 3)
                Eagle Position (0, 2)
                Enu Position (0, 1)
                Gray parrot Position (0, 0)
                Great auk Position (0, 4)
                Hawk Position (0, 2)
                Kiwi Position (0, 1)
                Owl Position (0, 0)
                Pigeon Position (0, 0)
                Rose ring parakeet Position (0, 0)
                Sulfur crested cockatoo Position (0, 0)
                Swan Position (0, 3)""";
    }

}
