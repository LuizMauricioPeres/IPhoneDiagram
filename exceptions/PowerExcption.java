package exceptions;

public class PowerExcption extends RuntimeException {
    public PowerExcption() {
        System.out.println("\nChoose an option: ");
        System.out.println("P. Power");
        System.out.println(""); // not in at all
    }
}
