package be.nielsdelestinne.goldenempire.utils.precondition;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
public class PreconditionChecker {

    public static void checkPrecondition(boolean precondition, String exceptionMessage) throws IllegalArgumentException{
        if(!precondition) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

}
