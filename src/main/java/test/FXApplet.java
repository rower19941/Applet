package test;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javax.swing.*;

/**
 * Created by Валерий on 03.10.2016.
 */
public class FXApplet extends JApplet{
    protected Scene scene;
    protected Group root;

    @Override
    public final void init() { // This method is invoked when applet is loaded
        SwingUtilities.invokeLater(new Runnable() {
            //@Override
            public void run() {
                initSwing();
            }
        });
    }

    private void initSwing() { // This method is invoked on Swing thread
        final JFXPanel fxPanel = new JFXPanel();
        add(fxPanel);

        Platform.runLater(new Runnable() {
            //@Override
            public void run() {
                initFX(fxPanel);
                initApplet();
            }
        });
    }

    private void initFX(JFXPanel fxPanel) { // This method is invoked on JavaFX thread
        root = new Group();
        scene = new Scene(root);
        Label label = new Label("dfsdf");
        root.getChildren().add(label);
        fxPanel.setScene(scene);
    }

    public void initApplet() {
        // Add custom initialization code here

    }
}
