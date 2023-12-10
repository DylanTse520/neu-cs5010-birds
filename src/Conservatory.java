import java.util.*;

/**
 * This class represents a conservatory. A conservatory is a place where you can rescue birds into the containing
 * aviaries. It has a list of aviaries. It has a maximum of 20 aviaries.
 */
public class Conservatory {
    private final ArrayList<Aviary> aviaries;

    private final static int MAXIMUM_NUM_OF_AVIARIES = 20;


    /**
     * Constructs a conservatory object and initializes its 20 aviaries with accenting unique id numbers and unique
     * locations.
     */
    Conservatory() {
        this.aviaries = new ArrayList<>();

        for (int i = 0; i < MAXIMUM_NUM_OF_AVIARIES; i++) {
            int row = i / 5;
            int column = i % 5;
            Aviary aviary = new Aviary(i + 1, "Position (" + row + ", " + column + ")");
            this.aviaries.add(aviary);
        }
    }

    /**
     * The setter method to rescue a new bird to this conservatory.
     *
     * @param bird Bird, the to-be-rescued bird
     * @throws RuntimeException thrown when the number of birds exceeds the capacity of this conservatory
     */
    public void rescueBird(Bird bird) {
        for (Aviary aviary : aviaries) {
            boolean assignSucceeded = aviary.assignBird(bird);
            if (assignSucceeded) {
                return;
            }
        }
        throw new RuntimeException("Conservatory exceeds capacity");
    }

    /**
     * The getter method to get the food needed by this conservatory. A summation of all the food needed by the
     * aviaries.
     *
     * @return the map for food-amount pair
     */
    public Map<Food, Integer> getNeededFood() {
        Map<Food, Integer> foodTotalQuantities = new HashMap<>();

        for (Aviary aviary : aviaries) {
            Map<Food, Integer> foodQuantities = aviary.getNeededFood();

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
     * The getter method to find given bird in this conservatory.
     *
     * @param bird Bird, the to-be-rescued bird
     * @return the unique id for the aviary where the bird is in; null for bird not found
     * @throws IllegalArgumentException thrown when the bird is null
     */
    public Integer findBird(Bird bird) {
        if (bird == null) {
            throw new IllegalArgumentException("Bird should not be null");
        }
        for (Aviary aviary : aviaries) {
            if (aviary.isBirdInAviary(bird)) {
                return aviary.getUid();
            }
        }
        return null;
    }

    /**
     * The getter method to get the description for an aviary.
     *
     * @param uid int, the aviary unique id
     * @return the description for the aviary including the number of the birds it hosts, the defining characteristic
     * of the birds and some interesting features.
     * @throws IllegalArgumentException thrown when the id is out of scope
     */
    public String describeAviary(int uid) {
        if (uid < 1 || uid > 20) {
            throw new IllegalArgumentException("Aviary id should be within 1 to 20");
        }
        for (Aviary aviary : aviaries) {
            if (aviary.getUid().equals(uid)) {
                return aviary.describeAviary();
            }
        }
        return null;
    }

    /**
     * The getter method to get the list of all aviaries.
     *
     * @return the description for all the aviaries for its unique id, the location and the birds they host.
     */
    public String listAviaries() {
        List<String> results = new ArrayList<>();

        for (Aviary aviary : aviaries) {
            List<String> aviaryInfo = new ArrayList<>();
            aviaryInfo.add("Aviary " + aviary.getUid() + " " + aviary.getLocation());

            ArrayList<Bird> birds = aviary.getBirds();
            List<String> birdInfo = new ArrayList<>();
            for (Bird bird : birds) {
                birdInfo.add(bird.getType().toString().toLowerCase().replace("_", " "));
            }

            aviaryInfo.add(String.join(", ", birdInfo));
            results.add(String.join(" ", aviaryInfo));
        }

        return String.join("\n", results);
    }

    /**
     * The getter method to get the list of all birds.
     *
     * @return the description for all the birds for its type and the location.
     */
    public String listBirds() {
        SortedMap<Bird, String> index = new TreeMap<>(Comparator.comparing(bird -> bird.getType().toString()));

        for (Aviary aviary : aviaries) {
            ArrayList<Bird> birds = aviary.getBirds();
            String location = aviary.getLocation();

            for (Bird bird : birds) {
                index.put(bird, location);
            }
        }

        List<String> results = new ArrayList<>();
        for (Map.Entry<Bird, String> entry : index.entrySet()) {
            Bird bird = entry.getKey();
            String location = entry.getValue();

            String birdName = bird.getType().toString().toLowerCase().replace("_", " ");

            results.add(birdName.substring(0, 1).toUpperCase() + birdName.substring(1) + " " + location);
        }

        return String.join("\n", results);
    }
}
