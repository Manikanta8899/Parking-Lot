package com.vikmanik;

public class OutputPrinter {

    private static void printLine(String msg) {
        System.out.println(msg);
    }

    public void welcome() {
        printWithNewLine("Welcome to Mapple Monk Parking lot.");
    }

    public void end() {
        printWithNewLine("Thanks for using Mapple Monk Parking lot service.");
    }
    public void notFound() {
        printWithNewLine("Not found");
    }

    public void invalidFile() {
        printLine("Invalid   file given.");
    }
    public void printWithNewLine(final String msg) {
        System.out.println(msg);
    }
    public void statusHeader() {
        printWithNewLine("Slot No.    Registration No    Colour");
    }

    public void parkingLotEmpty() {
        printWithNewLine("Parking lot is empty");
    }
    public void parkingLotFull() {
        printWithNewLine("Sorry, parking lot is full");
    }
}
