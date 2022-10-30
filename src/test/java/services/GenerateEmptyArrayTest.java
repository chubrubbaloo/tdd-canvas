package services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GenerateEmptyArrayTest {

    @Test
    @DisplayName("Test to see if 2D array has generated the right amount of columns")
    void twoDArrayGeneratedCorrectAmountOfCols() {

        var result = CanvasService.generateEmptyArray(2);
        var expected = new String[2][3];

        Assertions.assertEquals(result.length, expected.length);
    }

    @Test
    @DisplayName("Test to see if 2D array has generated the right amount of rows")
    void twoDArrayGeneratedCorrectAmountOfRows() {

        var result = CanvasService.generateEmptyArray(5);
        var expected = new String[5][7];

        Assertions.assertEquals(result[0].length, expected[0].length);
    }

    @Test
    @DisplayName("Test to see if 2D array has generated the WRONG amount of columns")
    void twoDArrayGeneratedIncorrectAmountOfCols() {

        var result = CanvasService.generateEmptyArray(5);
        var expected = new String[7][7];

        Assertions.assertNotEquals(result.length, expected.length);
    }

    @Test
    @DisplayName("Test to see if 2D array has generated the WRONG amount of rows")
    void twoDArrayGeneratedIncorrectAmountOfRows() {

        var result = CanvasService.generateEmptyArray(5);
        var expected = new String[5][5];

        Assertions.assertNotEquals(result[0].length, expected[0].length);
    }



    @Test
    @DisplayName("Test to see if default color is white")
    void testDefaultColor() {

        var result = CanvasService.generateEmptyArray(2);
        var expected = new String[][]{
                {"white", "white", "white"},
                {"white", "white", "white"}
        };

        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(result));
    }


    @Test
    @DisplayName("Test to see if default color is NOT white")
    void testDefaultWrongColor() {

        var result = CanvasService.generateEmptyArray(2);
        var expected = new String[][]{
                {"black", "black", "black"},
                {"black", "black", "black"}
        };

        Assertions.assertNotEquals(Arrays.deepToString(expected), Arrays.deepToString(result));
    }
}


