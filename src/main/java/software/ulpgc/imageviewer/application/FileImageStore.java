package software.ulpgc.imageviewer.application;

import software.ulpgc.imageviewer.architecture.store.ImageStore;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileImageStore implements ImageStore {
    private final File file;

    public FileImageStore(File file) {
        this.file = file;
    }

    @Override
    public Stream<String> images() {
        String[] list = file.list((dir, name) -> {
            String lower = name.toLowerCase();
            return lower.endsWith(".jpg") || lower.endsWith(".jpeg")
                || lower.endsWith(".png") || lower.endsWith(".bmp");
        });
        if (list == null || list.length == 0) return Stream.empty();
        return imagesIn(list);
    }

    private Stream<String> imagesIn(String[] list) {
        return Arrays.stream(list);
    }

}
