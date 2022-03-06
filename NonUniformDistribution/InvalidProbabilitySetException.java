package NonUniformDistribution.NonUniformDistribution;

/**
 * The main purpose of this class is to fire an exception if the sum of all probabilities is not equal to 1 in a selector,
 * abiding fundamental probability principles.
 */
public class InvalidProbabilitySetException extends Exception{

    public InvalidProbabilitySetException(){
        super("The sum of probabilities must be 1");
    }

}
