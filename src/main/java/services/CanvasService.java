package services;

import java.util.Arrays;

public class CanvasService {



    public static String[][] generateEmptyArray(int size) {

        String[][] colorArr = new String[size][(int) Math.floor(size * 1.5)];

        Arrays.stream(colorArr).forEach(x->Arrays.fill(x,"white"));

        return colorArr;
    }
}
