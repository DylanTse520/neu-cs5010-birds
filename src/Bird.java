import java.util.EnumMap;

/**
 * Interface for basic bird
 */
public interface Bird {
    /**
     * Get the unique id of bird
     * @return the unique id of bird
     */
    int getUid();

    /**
     * Get a type of bird
     * @return the type of bird
     */
    BirdType getType();

    /**
     * Get defining character of a bird
     * @return defining character of a bird
     */
    String getDefiningChar();

    /**
     * Get whether a bird is extinct of not
     * @return a bird is extinct of not
     */
    boolean isExtinct();

    /**
     * Get the number of wings a bird has
     * @return the number of wings
     */
    int getWingsNum();

    /**
     * Get the favorite food lists of a bird
     * @return the favorite food lists
     */
    EnumMap<Food, Integer> getPreferredFood();
}
