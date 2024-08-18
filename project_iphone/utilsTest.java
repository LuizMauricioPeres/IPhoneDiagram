package project_iphone;

public class utilsTest {
    public static String generateRandomNumberPhone() {
        String number = "(";
        for (int i = 0; i < 10; i++) {
            if (i == 2) {
                number += ")";
            }else if (i == 6) {
                number += "-";
            }
            number += String.valueOf((int) (Math.random() * 10));
        }
        return number;
    }
}
