package test;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.print.Printer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.File;
import java.util.Optional;




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
                try {
                    initFX(fxPanel);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                initApplet();
            }
        });
    }

    private void initFX(JFXPanel fxPanel) throws Exception { // This method is invoked on JavaFX thread
        root = new Group();
        scene = new Scene(root);
        File pdfFile = new File("C:/Users/sereo_000/Downloads/magistratura_1_kurs_4_f-t.pdf");
        Node node = null;
        final VBox root = new VBox(5);
        scene.setUserData(pdfFile);

        String name = print(node);
        try {
            Testing.main(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //print(root);

    }

    public void initApplet() {
        // Add custom initialization code here

    }

    public String print(Node node) {
        ChoiceDialog dialog = new ChoiceDialog(Printer.getDefaultPrinter(), Printer.getAllPrinters());
        dialog.setHeaderText("Choose the printer!");
        dialog.setContentText("Choose a printer from available printers");
        dialog.setTitle("Printer Choice");
        Optional<Printer> opt = dialog.showAndWait();
        if (opt.isPresent()) {
            Printer printer = opt.get();
            String nameOfPrinter=printer.getName();
            return nameOfPrinter;
        }
        return null;
    }

}
