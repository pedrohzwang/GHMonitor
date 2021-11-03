package util;

public final class LogUtils {

    private LogUtils() {
    }

    public static String getFilePath() {
        final String operationalSystem = System.getProperty("os.name");

        if (operationalSystem.equalsIgnoreCase("Windows")) {
            return "C:/GraceHopper/logs";
        } else if (operationalSystem.equalsIgnoreCase("Linux")) {
            return "/GraceHopper/logs";
        }

        return "C:/GraceHopper/logs";
    }
}
