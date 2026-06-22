package software.ulpgc.imageviewer.application.gui;

import software.ulpgc.imageviewer.application.FileImageStore;
import software.ulpgc.imageviewer.architecture.control.NextCommand;
import software.ulpgc.imageviewer.architecture.control.PrevCommand;
import software.ulpgc.imageviewer.architecture.model.ImageProvider;
import software.ulpgc.imageviewer.architecture.store.ImageStore;
import software.ulpgc.imageviewer.architecture.ui.ImagePresenter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static File root;

    public static void main(String[] args) {
        root = new File(System.getProperty("user.dir"), "images");
        if (!root.exists()) root.mkdirs();
        ImageStore imageStore = new FileImageStore(root);
        ImageProvider imageProvider = ImageProvider.of(imageStore.images());
        SwingImageDisplay imageDisplay = new SwingImageDisplay();
        ImagePresenter imagePresenter = new ImagePresenter(imageDisplay);
        imagePresenter.show(imageProvider.first(Main::readImage));
        Desktop.create(imageDisplay)
                .putCommand("prev", new PrevCommand(imagePresenter))
                .putCommand("next", new NextCommand(imagePresenter))
                .setVisible(true);
    }

    private static byte[] readImage(String id) {
        try {
            return Files.readAllBytes(new File(root, id).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
