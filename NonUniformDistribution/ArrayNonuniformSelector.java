package NonUniformDistribution.NonUniformDistribution;

import java.util.Arrays;
import java.util.Random;
/**
 *
 * This class represent a nonuniform selector using an array. The class in initialized with two arrays, an array of the
 * elements, and another array for their probabilities. The probability of an element is its correspondent value in the
 * probability array. This class provides the basic operations of a selector that perform its main functionalities.
 *
 * @param <E> the type of the values to be stored in the selector
 *
 * @author Yousef Altaher
 * @version 2022-03-06
 */
public class ArrayNonuniformSelector<E> implements NonuniformSelector <E>{

    private final Element<E>[] elementsArray;
    private final Random RAND = new Random();

    /**
     * This method construct a nonuniform selector using an array to store the values and their probabilities in wrapped
     * class called Element.
     *
     * @param elements an array of elements
     * @param probs an array of the probabilities of these elements
     * @throws InvalidProbabilitySetException if the probabilities array is not valid
     * @throws UnmatchedElementsAndProbabilities if the element array and probability array have different sizes
     */
    public ArrayNonuniformSelector(E[] elements, double[] probs) throws InvalidProbabilitySetException, UnmatchedElementsAndProbabilities {
        if (!validateSelector(probs))
            throw new InvalidProbabilitySetException();
        else if (elements.length != probs.length)
            throw new UnmatchedElementsAndProbabilities();

        elementsArray = new Element[elements.length];

        for (int i = 0; i < elements.length; i++)
            elementsArray[i] = new Element<>(elements[i], probs[i]);

    }

    /**
     * This method sets the seed for the random class
     * @param seed the new seed
     */
    @Override
    public void setSeed(int seed) {
        RAND.setSeed(seed);
    }

    /**
     * This method validate a double array of probabilities. An array of probability is valid if, and only if, the sum
     * of all probabilities is 1, or it accounts for the imprecision 99/100.
     *
     * @param probs The array of probabilities to be validated
     * @return true if the array is valid, false otherwise.
     */
    @Override
    public boolean validateSelector(double[] probs) {
        return 1-Arrays.stream(probs).sum() < 0.00001;
    }

    /**
     * This method returns a random value from the array according to its probability.
     * @return a random value from the array, according to its probability
     */
    @Override
    public E getRandomValue() {

        double probability = RAND.nextDouble();
        double offset = 0;

        for (Element e : elementsArray) {

            if (probability <= e.getProbability()+offset)
                return (E) e.getElementValue();
            else
                offset += e.getProbability();

        }

        return null;
    }
}

