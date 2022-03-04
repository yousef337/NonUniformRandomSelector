package NonUniformDistribution.NonUniformDistribution;

public interface NonuniformSelector <E> {

    void setSeed(int seed);
    boolean validateSelector(double[] probs);
    E getRandomElement();

}
