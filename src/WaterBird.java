import java.util.EnumMap;

/**
 * Constructs a WaterBird object and initializes it with 7 params.
 */
public class WaterBird extends AbstractBird implements Bird {
    WaterBody waterBody;

    public WaterBird(int uid, BirdType birdType, String definingChar, boolean isExtinct, int wingsNum, EnumMap<Food, Integer> preferredFood, WaterBody waterBody) {
        super(uid, birdType, definingChar, isExtinct, wingsNum, preferredFood);
        this.waterBody = waterBody;
    }

    /**
     * Get the body of water waterbird lives by
     *
     * @return the body of water
     */
    public WaterBody getLiveBy() {
        return waterBody;
    }
}
