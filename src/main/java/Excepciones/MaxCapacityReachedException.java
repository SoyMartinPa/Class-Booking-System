package Excepciones;

public class MaxCapacityReachedException extends RuntimeException {
    public MaxCapacityReachedException(String message) {
        super(message);
    }
}
