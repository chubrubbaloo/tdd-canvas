package repositories;

import entities.Pixel;

import java.util.ArrayList;

public interface PixelRepository {

    ArrayList<Pixel> getAllPixels();

    Pixel updatePixel(int id);
}
