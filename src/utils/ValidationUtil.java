package utils;

public class ValidationUtil {

    private ValidationUtil(){}

    public static void requireNonNull(Object obj, String message){

        if(obj == null)
            throw new IllegalArgumentException(message);
    }

    public static void requireNonEmpty(String str, String message){

        if(str.isEmpty())
            throw new IllegalArgumentException(message);
    }

    public static void requirePositive(double value, String message){

        if(value <= 0)
            throw new IllegalArgumentException(message);
    }
}

