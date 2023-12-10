import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * Constructs a FlightlessBird object and initializes it with 6 params.
 */

public class FlightlessBird extends AbstractBird {
    public FlightlessBird(int uid, BirdType birdType, String definingChar, boolean isExtinct, int wingsNum, EnumMap<Food, Integer> preferredFood) {
        super(uid, birdType, definingChar, isExtinct, wingsNum, preferredFood);
        if (wingsNum > 0) {
            throw new IllegalArgumentException("Flightless birds have no wings");
        }
        List<BirdType> birdsList = new ArrayList<>();
        birdsList.add(BirdType.ENU);
        birdsList.add(BirdType.KIWI);
        birdsList.add(BirdType.MOA);
        if (!birdsList.contains(birdType)) {
            throw new IllegalArgumentException("This bird doesn't include current type");
        }
    }
}
