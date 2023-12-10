import java.util.EnumMap;

/**
 * Constructs a Parrot object and initializes it with 8 params.
 */
public class Parrot extends AbstractBird {
    private final int numberOfWords;
    private final String favoriteSaying;

    public Parrot(int uid, BirdType birdType, String definingChar, boolean isExtinct, int wingsNum, EnumMap<Food, Integer> preferredFood, int numberOfWords, String favoriteSaying) {
        super(uid, birdType, definingChar, isExtinct, wingsNum, preferredFood);
        if (numberOfWords > 100) {
            throw new IllegalArgumentException("Parrots can learn up to 100 words");
        }
        if (numberOfWords < 0) {
            throw new IllegalArgumentException("Number of words must not be negative");
        }
        if (favoriteSaying == null) {
            throw new IllegalArgumentException("Favourite saying must not be null");
        }
        this.numberOfWords = numberOfWords;
        this.favoriteSaying = favoriteSaying;
    }

    /**
     * Get the amount of words parrots can learn
     *
     * @return the amount of words
     */
    public int getNumOfWords() {
        return numberOfWords;
    }

    /**
     * Get the single favorite saying
     *
     * @return favorite saying
     */
    public String getFavSaying() {
        return favoriteSaying;
    }

}
