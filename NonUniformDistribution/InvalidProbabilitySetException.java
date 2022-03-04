package NonUniformDistribution.NonUniformDistribution;

public class InvalidProbabilitySetException extends Exception{

    public InvalidProbabilitySetException(){
        super("The sum of probabilities must be 1");
    }

}
