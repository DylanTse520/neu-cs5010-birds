import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * Constructs a Waterfowl object and initializes it with 7 params.
 */
public class Waterfowl extends WaterBird {
    public Waterfowl(int uid, BirdType birdType, String definingChar, boolean isExtinct, int wingsNum, EnumMap<Food, Integer> preferredFood, WaterBody waterBody) {
        super(uid, birdType, definingChar, isExtinct, wingsNum, preferredFood, waterBody);
        List<BirdType> birdsList = new ArrayList<>();
        birdsList.add(BirdType.DUCK);
        birdsList.add(BirdType.SWAN);
        birdsList.add(BirdType.GEESE);
        if (!birdsList.contains(birdType)) {
            throw new IllegalArgumentException("This bird doesn't include current type");
        }
    }
}
