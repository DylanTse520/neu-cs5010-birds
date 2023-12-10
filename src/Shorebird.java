import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * Constructs a Shorebird object and initializes it with 7 params.
 */
public class Shorebird extends WaterBird {
    public Shorebird(int uid, BirdType birdType, String definingChar, boolean isExtinct, int wingsNum, EnumMap<Food, Integer> preferredFood, WaterBody waterBody) {
        super(uid, birdType, definingChar, isExtinct, wingsNum, preferredFood, waterBody);
        List<BirdType> birdsList = new ArrayList<>();
        birdsList.add(BirdType.GREAT_AUK);
        birdsList.add(BirdType.HORNED_PUFFIN);
        birdsList.add(BirdType.AFRICAN_JACANA);
        if (!birdsList.contains(birdType)) {
            throw new IllegalArgumentException("This bird doesn't include current type");
        }
    }
}
