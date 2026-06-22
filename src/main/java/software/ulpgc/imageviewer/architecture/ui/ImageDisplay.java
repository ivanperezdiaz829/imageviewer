package software.ulpgc.imageviewer.architecture.ui;

public interface ImageDisplay {
    void on(Shift shift);
    void on(Released release);
    void paint(Paint... paints);

    int width();

    interface  Shift {
        void offset(int value);
    }

    interface  Released {
        void offset(int value);
    }

    public record Paint(byte[] bitmap, int offset) {}
}
