package REMtracker.src.PKGminiscope;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

/**
 * ControlElements is a helper class that helps to create the sections within the control section
 * Said sections are:
 *  - Column 1: Buttons(Channel, Grid, Text, Cursor, Menu)
 *  - Column 2: Vertical Cursor Properties
 *  - Column 3: Horizontal Cursor Properties
 *  - Column 4: Vertical Scale Properties
 *  - Column 5: Horizontal Scale Properties
 *
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since 2018-JAN-11
 */
public class ControlElements {
    private VBox col_1_VBox = new VBox();
    private VBox vbox_ControlVertical_Template;
    private VBox vbox_ControlHorizontal_Template;
    private Button btn_V, btn_mV, btn_uV, btn_s, btn_ms, btn_us;

    //Constructor
    public ControlElements() {}

    //**************************COLUMN 1 SECTION*******************************
    public VBox getColumn_1_VBox(){return col_1_VBox;}
    public void setColumn_1_VBox(){
        col_1_VBox.getChildren().addAll(getBtnChannel(), getHBox_COL1_Btns(), getBtnCursor(), getBtnMenu());
    }

    public Button getBtnChannel(){
        return new Button("Channel");
    }
    public Button getBtnCursor(){
        return new  Button("Cursor");
    }
    public Button getBtnMenu(){
        return new Button("Menu");
    }
    public Button getBtn_V(){return btn_V;}
    public Button getBtn_mV(){return btn_mV;}
    public Button getBtn_uV(){return btn_uV;}
    public Button getBtn_s(){return btn_s;}
    public Button getBtn_ms(){return btn_ms;}
    public Button getBtn_us(){return btn_us;}

    public HBox getHBox_COL1_Btns(){
        Button btn_Grid = new Button("Grid");
        Button btn_Text = new Button("Text");
        HBox hbox = new HBox(btn_Grid, btn_Text);
        return hbox;
    }
    //************************END COLUMN 1 SECTION*****************************



    //************************HELPER SETTER METHODS*****************************
    public void setVbox_ControlVertical_Template(String label, String btn1_Label, String btn2_Label, String btn3_Label,
                                                 String sliderTopLabel, String sliderLowerLabel){

        Slider slider = new Slider(0, 5, 0);
        slider.setOrientation(Orientation.VERTICAL);
        slider.setPrefSize(10, 110);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        slider.setBlockIncrement(1);

        vbox_ControlVertical_Template = new VBox();

        btn_V = new Button(btn1_Label);
        btn_mV = new Button(btn2_Label);
        btn_uV = new Button(btn3_Label);
        int btnWidth = 35;
        btn_V.setPrefWidth(btnWidth);
        btn_mV.setPrefWidth(btnWidth);
        btn_uV.setPrefWidth(btnWidth);

        VBox vboxWithButtons = new VBox(btn_V, btn_mV, btn_uV);
        vboxWithButtons.setSpacing(15);
        vboxWithButtons.setTranslateX(10);

        HBox hbox = new HBox(slider,vboxWithButtons);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        Text text = new Text(label);
        text.setFont(new Font(16));

        vbox_ControlVertical_Template.getChildren().addAll(text,hbox);
        //vbox_ControlVertical_Template.setTranslateX(-15);
        vbox_ControlVertical_Template.setTranslateY(0);
        vbox_ControlVertical_Template.setAlignment(Pos.CENTER);


        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                if(object < 0.5) return sliderLowerLabel;
                if(object < 1.5) return "0.5";
                if(object < 2.5) return "1";
                if(object < 3.5) return "5";
                if(object < 4.5) return "10";
                return sliderTopLabel;
            }

            @Override
            public Double fromString(String string) {
                switch(string){
                    case "0.1":
                        return 0d;
                    case "0.5":
                        return 1d;
                    case "1":
                        return 2d;
                    case "5":
                        return 3d;
                    case "10":
                        return 4d;
                    case "20":
                        return 5d;
                    default:
                        return 5d;
                }
            }
        });
    }

    public void setVbox_ControlHorizontal_Template(String label, String btn1_Label, String btn2_Label, String btn3_Label,
                                                   String sliderLeftLabel, String sliderRightLabel){
        btn_us = new Button(btn1_Label);
        btn_ms = new Button(btn2_Label);
        btn_s = new Button(btn3_Label);

        Slider slider = new Slider(0, 5, 0);
        slider.setOrientation(Orientation.HORIZONTAL);
        slider.setPrefSize(100, 10); //Short width hides some tick labels
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        slider.setBlockIncrement(1);

        Text text = new Text(label);
        text.setFont(new Font(16));

        vbox_ControlHorizontal_Template = new VBox();
        HBox hbox = new HBox(btn_us, btn_ms, btn_s);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(5);

        vbox_ControlHorizontal_Template.getChildren().addAll(text, slider, hbox);

        vbox_ControlHorizontal_Template.setAlignment(Pos.CENTER);

        vbox_ControlHorizontal_Template.setSpacing(20);

        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                if(object < 0.5) return sliderLeftLabel;
                if(object < 1.5) return "0.5";
                if(object < 2.5) return "1";
                if(object < 3.5) return "5";
                if(object < 4.5) return "10";
                return sliderRightLabel;
            }

            @Override
            public Double fromString(String string) {
                switch(string){
                    case "0.1":
                        return 0d;
                    case "0.5":
                        return 1d;
                    case "1":
                        return 2d;
                    case "5":
                        return 3d;
                    case "10":
                        return 4d;
                    case "20":
                        return 5d;
                    default:
                        return 5d;
                }
            }
        });
    }
    //************************END OF HELPER SETTER METHODS**********************


    //************************HELPER GETTER METHODS*****************************
    public VBox getVbox_ControlVertical_Template(){return vbox_ControlVertical_Template;}
    public VBox getVbox_ControlHorizontal_Template(){return vbox_ControlHorizontal_Template;}
    //************************END OF HELPER GETTER METHODS**********************

}