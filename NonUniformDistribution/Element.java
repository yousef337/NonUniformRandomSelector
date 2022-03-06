package NonUniformDistribution.NonUniformDistribution;

/**
 * This class represent an element in a selector. An element consist of a value and a probability for the element.
 * @param <E> The type of the values to be stored in this element.
 */
class Element <E> {
    private E value;
    private double probability;

    /**
     * This method construct an element object with its necessary information
     * @param e the value of the element
     * @param prob the probability of the element
     */
    public Element(E e, double prob){
        value = e;
        probability = prob;
    }

    /**
     * This method returns the probability for this element
     * @return The probability for this element
     */
    public double getProbability() {
        return probability;
    }

    /**
     * This method returns the value that is stored in this element.
     * @return The value that is stored in this element.
     */
    public E getElementValue() {
        return value;
    }
}
