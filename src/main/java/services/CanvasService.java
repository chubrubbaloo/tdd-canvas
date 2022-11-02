package services;

import entities.Pixel;
import repositories.PixelRepository;

import java.util.Arrays;



public class CanvasService {

    public static String[][] generateEmptyArray(int size) {

        String[][] colorArr = new String[size][(int) Math.floor(size * 1.5)];

        Arrays.stream(colorArr).forEach(x->Arrays.fill(x,"white"));

        return colorArr;
    }

    public String[][] getPixels() {
        var query = repository.getAllPixels();

        var colors = generateEmptyArray(2);
        for (var pixel:query){
            if( pixel.getX() < colors.length) {
                if (pixel.getY() < colors[pixel.getX()].length) {
                    colors[pixel.getX()][pixel.getY()] = pixel.getColor();
                }
            }
        }
        return colors;
    }


    private final PixelRepository repository;

    public CanvasService (PixelRepository repository) { this.repository = repository;}

    public Pixel putPixel(int x, int y, String color) throws Exception {

        var pixel = new Pixel(x, y, color);

        if(pixel.getColor() == null) {
            throw new Exception();
        }
        repository.updatePixel(pixel);

        return pixel;
    }
}




