package solution.services;

import solution.model.PhoneInfo;

public class PhoneInfoServices {

    public PhoneInfo formObject(String[] arr) {

        int length = arr.length;
        long number = Long.parseLong(arr[0]);
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < length; i++) {
            builder.append(arr[i]).append(" ");
        }
        return new PhoneInfo(number, builder.toString());
    }



    public String printNoInfo(long value) {
        return String.format("%d -%n", value);
    }
}
