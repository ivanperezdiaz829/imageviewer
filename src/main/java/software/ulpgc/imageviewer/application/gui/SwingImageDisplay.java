package software.ulpgc.imageviewer.application.gui;

import software.ulpgc.imageviewer.architecture.ui.ImageDisplay;
import software.ulpgc.imageviewer.architecture.model.Canvas;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Shift shift;
    private Released released;
    private Paint paint;

    public SwingImageDisplay() {
        MouseAdapter mouseAdapter = new MouseAdapter();
        this.addMouseListener(mouseAdapter);
        this.addMouseMotionListener(mouseAdapter);
    }

    @Override
    public void on(Shift shift) {
        this.shift  = shift;
    }

    @Override
    public void on(Released release) {
        this.released = release;
    }

    @Override
    public void paint(Paint... paints) {
        this.paint = paints.length > 0 ? paints[0] : null;
        repaint();
    }

    @Override
    public int width() {
        return this.getWidth();
    }

    private final Map<Integer, BufferedImage> images = new HashMap<>();
    private BufferedImage toBufferedImage(byte[] bitmap) {
        return images.computeIfAbsent(Arrays.hashCode(bitmap), _ -> read(bitmap));
    }

    private BufferedImage read(byte[] bitmap) {
        try (InputStream is = new ByteArrayInputStream(bitmap)) {
            return ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (paint == null) return;

        BufferedImage bitmap = toBufferedImage(paint.bitmap());
        Canvas canvas = Canvas.ofSize(getWidth(), getHeight())
                .fit(bitmap.getWidth(), bitmap.getHeight());

        int x = (getWidth() - canvas.width()) / 2;
        int y = (getHeight() - canvas.height()) / 2;

        g.drawImage(
                bitmap,
                x + paint.offset(),
                y,
                canvas.width(),
                canvas.height(),
                null
        );
    }


    private class MouseAdapter implements MouseListener, MouseMotionListener {
        private int x;

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            x = e.getX();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            SwingImageDisplay.this.released.offset(e.getX() - x);
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            SwingImageDisplay.this.shift.offset(e.getX() - x);
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }


}
