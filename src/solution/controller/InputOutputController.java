package solution.controller;

public class InputOutputController {

    // checking two paths (f.e. source file and output file) and protect it from rewriting each other
    public boolean isPathEquals(String firstPath, String secondPath) {
        if (firstPath == null || secondPath == null)
            throw new IllegalArgumentException("Paste path!");

        return firstPath.compareTo(secondPath) == 0;
    }
}
