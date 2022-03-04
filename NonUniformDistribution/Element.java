package NonUniformDistribution.NonUniformDistribution;

public class Element <E> {
    private E element;
    private double probability;

    public Element(E e, double prob){
        element = e;
        probability = prob;
    }

    public double getProbability() {
        return probability;
    }

    public E getElement() {
        return element;
    }
}
