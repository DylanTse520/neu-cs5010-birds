import java.util.EnumMap;

/**
 * Constructs an Owl object and initializes it with 6 params.
 */
public class Owl extends AbstractBird {
    public Owl(int uid, BirdType birdType, String definingChar, boolean isExtinct, int wingsNum, EnumMap<Food, Integer> preferredFood) {
        super(uid, birdType, definingChar, isExtinct, wingsNum, preferredFood);
    }
}
