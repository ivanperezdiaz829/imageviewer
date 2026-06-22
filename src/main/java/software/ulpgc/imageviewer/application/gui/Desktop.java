package software.ulpgc.imageviewer.application.gui;

import software.ulpgc.imageviewer.architecture.control.Command;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Desktop extends JFrame {
    private final Map<String, Command> commands;

    public static Desktop create(SwingImageDisplay imageDisplay) {
        return new Desktop(imageDisplay);
    }

    public Desktop(SwingImageDisplay imageDisplay) {
        this.commands = new HashMap<>();
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.getContentPane().add(toolBar(), BorderLayout.SOUTH);
        this.getContentPane().add(imageDisplay, BorderLayout.CENTER);
    }

    private JPanel toolBar() {
        JPanel panel = new JPanel();
        panel.add(button("prev"));
        panel.add(button("next"));
        return panel;
    }

    private JButton button(String text) {
        JButton button = new JButton(text);
        button.addActionListener(e -> commands.get(text).execute());
        return button;
    }

    public Desktop putCommand(String name, Command command) {
        commands.put(name, command);
        return this;
    }
}
