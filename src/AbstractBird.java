import java.util.EnumMap;

public class AbstractBird implements Bird {
    private final int uid;
    private final String definingChar;
    private final boolean isExtinct;
    private final int wingsNum;
    BirdType birdType;
    EnumMap<Food, Integer> preferredFood;

    /**
     * Constructs a bird object and initializes it with 5 params.
     * @param birdType the type of bird
     * @param definingChar the defining character of bird
     * @param isExtinct whether a bird is extinct or not
     * @param wingsNum the number of wings of a bird
     * @param preferredFood the favorite food of a bird
     */
    public AbstractBird(int uid, BirdType birdType, String definingChar, boolean isExtinct, int wingsNum, EnumMap<Food,
            Integer> preferredFood) {
        if (wingsNum % 2 != 0) {
            throw new IllegalArgumentException("Wings must be odd number");
        }
        this.uid = uid;
        this.birdType = birdType;
        this.definingChar = definingChar;
        this.isExtinct = isExtinct;
        this.wingsNum = wingsNum;
        this.preferredFood = preferredFood;
    }

    @Override
    public int getUid() {
        return uid;
    }

    @Override
    public BirdType getType() {
        return birdType;
    }

    @Override
    public String getDefiningChar() {
        return definingChar;
    }

    @Override
    public boolean isExtinct() {
        return isExtinct;
    }

    @Override
    public int getWingsNum() {
        return wingsNum;
    }

    @Override
    public EnumMap<Food, Integer> getPreferredFood() {
        return preferredFood;
    }
}
