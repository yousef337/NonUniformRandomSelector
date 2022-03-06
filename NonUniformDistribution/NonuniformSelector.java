package NonUniformDistribution.NonUniformDistribution;

/**
 * This interface provides the signature of operations that every nonuniform selector should have.
 * @param <E> The type that the selector will store
 *
 * @author Yousef Altaher
 * @version 2022-03-06
 */
public interface NonuniformSelector <E> {

    void setSeed(int seed);
    boolean validateSelector(double[] probs);
    E getRandomValue();

}
