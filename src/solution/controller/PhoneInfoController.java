package solution.controller;

public class PhoneInfoController {

    // Method which checking input number (must be only digits)
    public boolean isNumberCorrect(String number) {
        return number != null && number.matches("[0-9]+");
    }
}
