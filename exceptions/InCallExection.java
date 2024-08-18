package exceptions;

public class InCallExection extends RuntimeException {

    public InCallExection(String message ) {
        System.out.println("Call in progress..." + message);
    }

}
