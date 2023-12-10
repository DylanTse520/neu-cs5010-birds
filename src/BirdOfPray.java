import java.util.*;

/**
 * Constructs a BirdOfPray object and initializes it with 6 params.
 */
public class BirdOfPray extends AbstractBird {
    public BirdOfPray(int uid, BirdType birdType, String definingChar, boolean isExtinct, int wingsNum, EnumMap<Food,
            Integer> preferredFood) {
        super(uid, birdType, definingChar, isExtinct, wingsNum, preferredFood);
        List<BirdType> birdsList = new ArrayList<>();
        birdsList.add(BirdType.HAWK);
        birdsList.add(BirdType.EAGLE);
        birdsList.add(BirdType.OSPREY);
        if (!birdsList.contains(birdType)) {
            throw new IllegalArgumentException("This bird doesn't include current type");
        }
    }
}
