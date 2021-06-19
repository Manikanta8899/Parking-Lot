package com.vikmanik;

public class OutputPrinter {
    public static void welcome() {
        printLine("Welcome to Mapple Monk Parking lot.");
    }
    private static void printLine(String msg) {
        System.out.println(msg);
    }
    public static void usage() {
        //TODO: Print usage.
    }

    public static void endInteractive() {
        //TODO: Print end of interactive mode.
    }

    public static void invalidFile() {
        printLine("Invalid file given.");
    }
}
