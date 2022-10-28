package services;

import java.util.Arrays;

public class CanvasService {



    public static String[][] generateEmptyArray(int size) {

        if (size <= 0){
            throw new ArrayIndexOutOfBoundsException("A canvas can't be of size 0 or less. Try to pick a positive number.");
        }

        String[][] colorArr = new String[size][(int) Math.floor(size * 1.5)];

        Arrays.stream(colorArr).forEach(x->Arrays.fill(x,"white"));

        return colorArr;
    }
}
