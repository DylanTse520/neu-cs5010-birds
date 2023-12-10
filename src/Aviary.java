import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents an aviary. An aviary in a conservatory is a place where birds lives. It has a unique id, a
 * location and a list of birds that it hosts. An aviary can have no more than 5 birds, and can host no extinct birds.
 * Flightless birds, birds of prey, and waterfowl should not be mixed with other bird types.
 */
public class Aviary {
    private final int uid;
    private final String location;
    private final ArrayList<Bird> birds;
    private final static int MAXIMUM_NUM_OF_BIRDS = 5;

    /**
     * Constructs an aviary object and initializes it to the given unique id, location. Not changing the given object.
     *
     * @param uid         int, the unique id of the aviary
     * @param location    String, the location of the aviary
     * @exception IllegalArgumentException thrown when location is null
     */
    Aviary(int uid, String location) {
        if (location == null) {
            throw new IllegalArgumentException("Location should not be null");
        }
        this.uid = uid;
        this.location = location;
        this.birds = new ArrayList<>();
    }

    /**
     * The getter method for unique id.
     *
     * @return the unique id
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * The getter method for location.
     *
     * @return the location of the aviary
     */
    public String getLocation() {
        return location;
    }

    /**
     * The getter method for the birds list.
     *
     * @return the list of the birds
     */
    public ArrayList<Bird> getBirds() {
        return birds;
    }

    /**
     * The getter method for the food needed by this aviary. A summation of all the food needed by the birds in this
     * aviary.
     *
     * @return a map of the food-amount pair.
     */
    public Map<Food, Integer> getNeededFood() {
        Map<Food, Integer> foodTotalQuantities = new HashMap<>();

        for (Bird bird : birds) {
            Map<Food, Integer> foodQuantities = bird.getPreferredFood();

            for (Map.Entry<Food, Integer> entry : foodQuantities.entrySet()) {
                Food food = entry.getKey();
                int foodQuantity = entry.getValue();

                if (foodTotalQuantities.containsKey(food)) {
                    int currentFoodQuantity = foodTotalQuantities.get(food);
                    foodTotalQuantities.put(food, currentFoodQuantity + foodQuantity);
                } else {
                    foodTotalQuantities.put(food, foodQuantity);
                }
            }
        }

        return foodTotalQuantities;
    }

    /**
     * The setter method to assign a new bird to this aviary. Returns boolean to indicate success.
     *
     * @param bird  Bird, the to-be-assigned bird
     * @return the boolean indicating the success
     * @exception IllegalArgumentException thrown when the given bird is null or extincted
     */
    public Boolean assignBird(Bird bird) {
        if (bird == null) {
            throw new IllegalArgumentException("Bird should not be null");
        }
        if (bird.isExtinct()) {
            throw new IllegalArgumentException("Bird should not be extinct");
        }
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            birds.add(bird);
            return true;
        }
        Class<? extends Bird> birdClass = bird.getClass();
        Class<? extends Bird> birdClassInAviary = birds.get(0).getClass();
        if (birdClass == FlightlessBird.class || birdClass == BirdOfPray.class || birdClass == Waterfowl.class) {
            if (birdClass.equals(birdClassInAviary)) {
                birds.add(bird);
                return true;
            } else {
                return false;
            }
        }
        if (birdClassInAviary == FlightlessBird.class || birdClassInAviary == BirdOfPray.class || birdClassInAviary == Waterfowl.class) {
            return false;
        }
        birds.add(bird);
        return true;
    }

    /**
     * The getter method to see if a bird is in the aviary.
     *
     * @param bird  Bird, the to-be-checked bird
     * @return boolean for whether the bird is found
     */
    public Boolean isBirdInAviary(Bird bird) {
        return birds.contains(bird);
    }

    private Boolean isEmpty() {
        return birds.size() == 0;
    }

    private Boolean isFull() {
        return birds.size() >= MAXIMUM_NUM_OF_BIRDS;
    }

    /**
     * The getter method to get a description of this aviary. Returns the number of the birds it hosts, the defining
     * characteristic of the birds and some interesting features.
     *
     * @return the description for the aviary
     */
    public String describeAviary() {
        List<String> results = new ArrayList<>();

        int birdCount = birds.size();
        String birdPlural = (birdCount == 0 || birdCount == 1) ? " bird." : " birds.";
        results.add("This aviary houses " + birdCount + birdPlural);
        for (int i = 0; i < birdCount; i++) {
            Bird bird = birds.get(i);
            List<String> birdDescriptions = new ArrayList<>();
            birdDescriptions.add("Bird NO." + (i + 1) + " is " + bird.getType().toString().toLowerCase().replace("_", " "
            ) + ". Its " +
                    "defining " +
                    "characteristic " +
                    "is " + bird.getDefiningChar() + ".");
            if (bird instanceof WaterBird waterBird) {
                birdDescriptions.add("It lives near " + waterBird.getLiveBy() + ".");
            }
            if (bird instanceof Parrot parrot) {
                int wordCount = parrot.getNumOfWords();
                String wordPlural = (wordCount == 0 || wordCount == 1) ? " word." : " words.";
                birdDescriptions.add("It speaks " + wordCount + wordPlural + " Its favourite saying is \"" + parrot.getFavSaying() + "\".");
            }
            String birdDescription = String.join(" ", birdDescriptions);

            results.add(birdDescription);
        }

        return String.join("\n", results);
    }

}
