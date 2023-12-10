import java.util.EnumMap;

/**
 * Constructs a Pigeon object and initializes it with 6 params.
 */
public class Pigeon extends AbstractBird {
    public Pigeon(int uid, BirdType birdType, String definingChar, boolean isExtinct, int wingsNum, EnumMap<Food,
            Integer> preferredFood) {
        super(uid, birdType, definingChar, isExtinct, wingsNum, preferredFood);
    }
}
