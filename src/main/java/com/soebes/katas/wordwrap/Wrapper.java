package com.soebes.katas.wordwrap;

public class Wrapper {

    public static String wrap(String s, int column) {
        return new Wrapper(column).wrap(s);
    }

    private int column;
    
    private Wrapper(int column) {
        this.column = column;
    }

    private String wrap(String s) {
        if (s.length() <= column) {
            return s;
        } else {
            int space = s.substring(0, column).lastIndexOf(' ');

            if (space != -1) {
                return breakLine(s, space, 1);
            } else {
                if (s.charAt(column) == ' ') {
                    return breakLine(s, column, 1);
                } else {
                    return breakLine(s, column, 0);
                }
            }
        }
    }
    
    private String breakLine(String s, int pos, int gap) {
        return s.substring(0, pos) + "\n" + wrap(s.substring(pos + gap), column);
    }
}
