package REMtracker.src.PKGminiscope;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.awt.*;

/**
 * MiniScopeEventRelayer handles any and all mouse and keyboard input
 * - Mouse: HoverOver, Clicked, Hold, Release, DoubleClick, Wheel, RightClick, LeftClick, Left&RightMouseButton
 * - Keyboard: Shortcut Keys, Sticky Keys, StandardKeys, NumpadKeys, FunctionKeys
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since   2018-NOV-20
 */
public class MiniScopeEventRelayer {
   private MiniScopeDataModel dataModel;
   private DropShadow dropGreenShadowEffect;


  //Constructor with no arguments
   MiniScopeEventRelayer(){}

    public MiniScopeEventRelayer(MiniScopeDataModel aModel){
       dataModel = new MiniScopeDataModel();
       this.dataModel = aModel;

       dropGreenShadowEffect = new DropShadow();
       dropGreenShadowEffect.setColor(Color.GREEN);


       setButtonListeners();
    }
    private void setButtonListeners(){
        dataModel.getBtn_Channel().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dataModel.getBtn_Channel().setText("Hello");
            }
        });

        dataModel.getBtn_Grid().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Perhaps we would like to change this button from"Grid" to "Clear Graph"?
                dataModel.getSeries().getData().clear();
            }
        });

        dataModel.getBtn_Text().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(dataModel.getText1().isVisible()){
                    dataModel.getText1().setVisible(false);
                    dataModel.getText2().setVisible(false);
                    dataModel.getText3().setVisible(false);
                    dataModel.getText4().setVisible(false);
                    dataModel.getText5().setVisible(false);
                    dataModel.getText6().setVisible(false);
                    dataModel.getText7().setVisible(false);
                    dataModel.getText8().setVisible(false);
                    dataModel.getText9().setVisible(false);

                }
                else{
                    dataModel.getText1().setVisible(true);
                    dataModel.getText2().setVisible(true);
                    dataModel.getText3().setVisible(true);
                    dataModel.getText4().setVisible(true);
                    dataModel.getText5().setVisible(true);
                    dataModel.getText6().setVisible(true);
                    dataModel.getText7().setVisible(true);
                    dataModel.getText8().setVisible(true);
                    dataModel.getText9().setVisible(true);
                }
            }
        });

        dataModel.getBtn_Cursors().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dataModel.getBtn_HortCursorA().setEffect(null);
                dataModel.getBtn_HortCursorB().setEffect(null);
                dataModel.getBtn_VCursor_A().setEffect(null);
                dataModel.getBtn_VCursor_B().setEffect(null);

            }
        });

        dataModel.getBtn_Menu().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO
                //Add code here
            }
        });

        dataModel.getBtn_HortCursorA().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO: Add code here
                dataModel.getBtn_HortCursorA().setEffect(dropGreenShadowEffect);
                dataModel.getBtn_HortCursorB().setEffect(null);


            }
        });

        dataModel.getBtn_HortCursorB().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                dataModel.getBtn_HortCursorB().setEffect(dropGreenShadowEffect);
                dataModel.getBtn_HortCursorA().setEffect(null);
            }
        });

        dataModel.getBtn_VCursor_A().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dataModel.getBtn_VCursor_A().setEffect(dropGreenShadowEffect);
                dataModel.getBtn_VCursor_B().setEffect(null);
            }
        });

        dataModel.getBtn_VCursor_B().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dataModel.getBtn_VCursor_B().setEffect(dropGreenShadowEffect);
                dataModel.getBtn_VCursor_A().setEffect(null);
            }
        });

        dataModel.getBtn_V().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dataModel.getBtn_V().setEffect(dropGreenShadowEffect);
                dataModel.getBtn_mV().setEffect(null);
                dataModel.getBtn_uV().setEffect(null);
            }
        });

        dataModel.getBtn_mV().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dataModel.getBtn_mV().setEffect(dropGreenShadowEffect);
                dataModel.getBtn_V().setEffect(null);
                dataModel.getBtn_uV().setEffect(null);
            }
        });

        dataModel.getBtn_uV().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dataModel.getBtn_uV().setEffect(dropGreenShadowEffect);
                dataModel.getBtn_mV().setEffect(null);
                dataModel.getBtn_V().setEffect(null);
            }
        });

        dataModel.getBtn_s().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dataModel.getBtn_s().setEffect(dropGreenShadowEffect);
                dataModel.getBtn_ms().setEffect(null);
                dataModel.getBtn_us().setEffect(null);
            }
        });

        dataModel.getBtn_ms().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dataModel.getBtn_ms().setEffect(dropGreenShadowEffect);
                dataModel.getBtn_s().setEffect(null);
                dataModel.getBtn_us().setEffect(null);
            }
        });

        dataModel.getBtn_us().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dataModel.getBtn_us().setEffect(dropGreenShadowEffect);
                dataModel.getBtn_ms().setEffect(null);
                dataModel.getBtn_s().setEffect(null);
            }
        });



    }


}
