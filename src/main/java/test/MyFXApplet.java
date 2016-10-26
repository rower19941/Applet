package test;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Валерий on 26.10.2016.
 */
public class MyFXApplet extends FXApplet {

    @Override
    public void initApplet(){

        Label label = new Label("-->"+"<--");
        root.getChildren().add(label);

        Rectangle r = new Rectangle(25,25,250,250);
        r.setFill(Color.BLUE);
        root.getChildren().add(r);
    }
}
