package repositories;

import entities.Pixel;

import java.util.ArrayList;

public class MemoryPixelRepository implements PixelRepository{

    ArrayList<Pixel> pixels = new ArrayList<>();

    @Override
    public ArrayList<Pixel> getAllPixels() {
        return null;
    }

    @Override
    public Pixel updatePixel(int id) {
        return null;
    }
}
