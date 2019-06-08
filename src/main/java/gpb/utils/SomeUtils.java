package gpb.utils;

public class SomeUtils {
    public static boolean isCorrectPortNumber(String value) {
        if (value == null)
            return false;
        if (value.matches("\\d{1,5}")) {
            int port = Integer.parseInt(value);
            return port < 65536;
        }
        return false;
    }

    public static String getPortFromArgs(String[] args) {
        if (args.length > 0 && isCorrectPortNumber(args[0]))
            return args[0];
        return "8080";
    }


}
