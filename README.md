# Birds

## Design

Modern biologists have been classifying life into categories according to the complexity of that life as well as a distinguishable property that can be observed since the 1700s. Birds are defined as warm-blooded, bipedal, vertebrate animals who have two wings instead of arms. They are typically covered in feathers and have a beak instead of a mouth. Bird is one of the largest classes of animals in the bigger Kingdom Animalia.

Some of the classifications of birds (derived in part from [BioExplorer.net](https://www.bioexplorer.net/animals/birds/)) include:

* Birds of prey all have sharp, hooked beaks with visible nostrils. They include hawks, eagles, and osprey.
* Flightless birds live on the ground and have no (or undeveloped) wings. They include the emus, kiwis, and moas. Some (but not all) of these birds are extinct.
* Owls are distinguished by the facial disks that frame the eyes and bill.
* Parrots have a short, curved beak and are known for their intelligence and ability to mimic sounds. Many pet parrots can learn a vocabulary of up to 100 words and often adopt a single "favorite" saying.  They include the rose-ring parakeet, gray parrot, and sulfur-crested cockatoo.
* Pigeons (or doves) are known for feeding their young "bird milk" very similar to the milk of mammals. Found all over the world, there are several varieties that are extinct.
* Shorebirds include the great auk, horned puffin, and African Jacana. They live near water sources including wetlands, freshwater and saltwater shorelands, even the ocean.
* Waterfowl are another classification that live near water sources (fresh or salt) and include ducks, swans, and geese.

In this homework you will be asked to design and implement a solution that can be used to keep track of birds according to the above classifications (we are omitting many classifications to keep this assignment relatively confined).  For each classification of bird, your solution should be able to track each of the following:

* The type of bird (e.g., duck, horned puffin, etc), their defining characteristic, whether they are extinct, as well as the number of wings they have.
* A description of what 2-4 items they prefer to eat from the following list: berries, seeds, fruit, insects, other birds, eggs, small mammals, fish, buds, larvae, aquatic invertebrates, nuts, and vegetation.
* For birds that live near water, the name of the body of water that they live by.
* In the case of parrots, the number of words in their vocabulary as well as their single "favorite" saying.

Create a design doc for the solution, with a test plan to test the design.

## Development

Implement the class hierarchy that specified in previous part. Create a diver class that represents a conservatory that houses many different types of birds. The conservatory is broken into various aviaries. This new class should:

* Allow you to rescue new birds and bring them into your conservatory
* Calculate what food needs to be kept and in what quantities
* Assign a bird to an aviary in the conservatory. Assignments must follow the following criteria:
  * There is a maximum of 20 aviaries in the conservatory
  * Any bird can be inserted into an empty aviary
  * No aviary can house more than 5 birds
  * No extinct birds can be added to an aviary
  * Flightless birds, birds of prey, and waterfowl should not be mixed with other bird types
* Have a guest look up which aviary a bird is in
* Print a sign for any given aviary that gives a description of the birds it houses and any interesting information that it may have about that animal.
* Print a “map” that lists all the aviaries by location and the birds they house
* Print an index that lists all birds in the conservatory in alphabetical order and their location
