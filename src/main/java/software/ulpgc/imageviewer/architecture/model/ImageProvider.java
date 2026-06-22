package software.ulpgc.imageviewer.architecture.model;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class ImageProvider {
    private final List<String> images;


    private ImageProvider(Stream<String> images) {
        this.images = images.toList();
    }

    public static ImageProvider of(Stream<String> images) {
        return new ImageProvider(images);
    }

    public Image first(Function<String, byte[]> loader){
        return load(0, loader);
    }

    private Image load(int i, Function<String,byte[]> loader) {
        return new Image() {
            private final int size = images.size();
            private byte[] bitmap;

            @Override
            public String id() {
                return images.get(i);
            }

            @Override
            public byte[] bitmap() {
                if(bitmap == null) bitmap = loader.apply(images.get(i));
                return bitmap;
            }

            @Override
            public Image prev() {
                return i == 0 ? load(size-1, loader) : load(i-1, loader);
            }

            @Override
            public Image next() {
                return i == size - 1 ? load(0, loader) : load(i+1, loader);
            }
        };
    }
}
