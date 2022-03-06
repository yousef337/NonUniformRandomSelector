package NonUniformDistribution.NonUniformDistribution;

/**
 * The main purpose of this class is to fire an exception when the provided data have a mismatch between the number of
 * elements and the number of assigned probabilities.
 */
public class UnmatchedElementsAndProbabilities extends Throwable{

    public UnmatchedElementsAndProbabilities(){
        super("The number of elements and their probabilities must be equal");
    }

}
