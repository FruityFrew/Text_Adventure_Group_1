package Text_Adventure.menuDevelopment;

public class ColorPrint {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String Background_WHITE = "\u001B[47m";

    //Write in green
    public static void green(String text) {
        System.out.print(ANSI_GREEN + text + ANSI_RESET);
    }

    //Write in red
    public static void red(String text) {
        System.out.print(ANSI_RED + text + ANSI_RESET);
    }

    //Write in blue
    public static void blue(String text) {
        System.out.print(ANSI_BLUE + text + ANSI_RESET);
    }

    //Write in Yellow
    public static void yellow(String text) {
        System.out.print(ANSI_YELLOW + text + ANSI_RESET);
    }

}
