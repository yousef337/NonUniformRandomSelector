package NonUniformDistribution.NonUniformDistribution;

import java.util.Arrays;
import java.util.Random;

public class ArrayNonuniformSelector<E> implements NonuniformSelector <E>{

    private final Element<E>[] elementsArray;
    private final Random RAND = new Random();

    public ArrayNonuniformSelector(E[] elements, double[] probs) throws InvalidProbabilitySetException, UnmatchedElementsAndProbabilities {
        if (!validateSelector(probs))
            throw new InvalidProbabilitySetException();
        else if (elements.length != probs.length)
            throw new UnmatchedElementsAndProbabilities();

        elementsArray = new Element[elements.length];

        for (int i = 0; i < elements.length; i++)
            elementsArray[i] = new Element<>(elements[i], probs[i]);

    }

    @Override
    public void setSeed(int seed) {
        RAND.setSeed(seed);
    }

    @Override
    public boolean validateSelector(double[] probs) {
        return Arrays.stream(probs).sum() == 1;
    }

    @Override
    public E getRandomElement() {

        double probability = RAND.nextDouble();
        double offset = 0;

        for (Element e : elementsArray) {

            if (probability <= e.getProbability()+offset) {
                return (E) e.getElement();
            } else
                offset += e.getProbability();

        }

        return null;
    }

    private Element getElement(E e){
        return elementsArray[Arrays.asList(elementsArray).indexOf(e)];
    }

}
