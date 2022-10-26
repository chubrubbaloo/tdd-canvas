package repositories;

import entities.Pixel;

import java.util.ArrayList;

public class MemoryPixelRepository implements PixelRepository{

    ArrayList<Pixel> pixels = new ArrayList<>();

    @Override
    public ArrayList<Pixel> getAllPixels() {
        return new ArrayList<>(pixels.stream().map(Pixel::new).toList());
    }

    @Override
    public Pixel updatePixel(Pixel pixel) {
        pixels.remove(pixel);
        pixels.add(new Pixel(pixel));
        return pixel;
    }
}
