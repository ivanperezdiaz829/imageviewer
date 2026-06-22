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
        return imagesIn(file.list());
    }

    private Stream<String> imagesIn(String[] list) {
        return Arrays.stream(list);
    }

}
