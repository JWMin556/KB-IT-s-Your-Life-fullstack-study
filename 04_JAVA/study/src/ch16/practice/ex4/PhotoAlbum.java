package ch16.practice.ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PhotoAlbum {
    private List<Photo> album;

    public PhotoAlbum() {
        album = new ArrayList<>();
    }

    public void addPhoto(Photo photo, Consumer<Photo> consumer) {
        consumer.accept(photo);
        album.add(photo);
    }

    public void printFiltered(Predicate<Photo> filter, Consumer<Photo> printer) {
        for (Photo photo : album) {
            if (filter.test(photo)) {
                printer.accept(photo);
            }
        }
    }
}
