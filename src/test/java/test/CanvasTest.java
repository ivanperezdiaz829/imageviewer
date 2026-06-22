package test;

import org.junit.Test;
import software.ulpgc.imageviewer.architecture.model.Canvas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CanvasTest {
    @Test
    public void image_smaller_than_canvas() {
        Canvas canvas = Canvas.ofSize(200,200).fit(100,100);
        assertThat(canvas).isEqualTo(Canvas.ofSize(100,100));
    }

    @Test
    public void image_wider_than_canvas() {
        Canvas canvas = Canvas.ofSize(200,200).fit(400,100);
        assertThat(canvas).isEqualTo(Canvas.ofSize(200,50));
    }

    @Test
    public void image_higher_than_canvas() {
        Canvas canvas = Canvas.ofSize(200,200).fit(100,400);
        assertThat(canvas).isEqualTo(Canvas.ofSize(50,200));
    }

    @Test
    public void image_greater_than_canvas() {
        Canvas canvas = Canvas.ofSize(200,200).fit(500,500);
        assertThat(canvas).isEqualTo(Canvas.ofSize(200,200));
    }
}
