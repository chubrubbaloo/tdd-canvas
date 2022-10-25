package repositories;

import entities.Pixel;

import java.util.HashMap;

public interface PixelRepository {

    HashMap<Integer, Pixel> getAllPixels();

    Pixel updatePixel(int id);
}
