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

        Slider slider = new Slider();
        slider.setOrientation(Orientation.VERTICAL);
        slider.setPrefSize(10, 110);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(100);
        slider.setMinorTickCount(0);

        vbox_ControlVertical_Template = new VBox();

        Button btn1 = new Button(btn1_Label);
        Button btn2 = new Button(btn2_Label);
        Button btn3 = new Button(btn3_Label);
        int btnWidth = 35;
        btn1.setPrefWidth(btnWidth);
        btn2.setPrefWidth(btnWidth);
        btn3.setPrefWidth(btnWidth);

        VBox vboxWithButtons = new VBox(btn1, btn2, btn3);
        vboxWithButtons.setSpacing(15);
        vboxWithButtons.setTranslateX(10);

        HBox hbox = new HBox(slider,vboxWithButtons);
        hbox.setSpacing(15);

        Text text = new Text(label);
        text.setFont(new Font(16));

        vbox_ControlVertical_Template.getChildren().addAll(text,hbox);
        vbox_ControlVertical_Template.setTranslateX(-15);
        vbox_ControlVertical_Template.setTranslateY(0);
        vbox_ControlVertical_Template.setAlignment(Pos.CENTER);


        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                if(object == 0) return sliderLowerLabel;
                if(object == 100) return sliderTopLabel;
                return sliderLowerLabel;
            }

            @Override
            public Double fromString(String string) {
                switch(string){
                    case "DN":
                        return 0d;
                    case "UP":
                        return 1d;
                    default:
                        return 1d;
                }
            }
        });
    }

    public void setVbox_ControlHorizontal_Template(String label, String btn1_Label, String btn2_Label, String btn3_Label,
                                                   String sliderLeftLabel, String sliderRightLabel){

        Slider slider = new Slider();
        slider.setOrientation(Orientation.HORIZONTAL);
        slider.setPrefSize(75, 10);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(100);
        slider.setMinorTickCount(0);

        Text text = new Text(label);
        text.setFont(new Font(16));

        vbox_ControlHorizontal_Template = new VBox();

        vbox_ControlHorizontal_Template.getChildren().addAll(text, slider,
                new HBox(new Button(btn1_Label), new Button(btn2_Label), new Button(btn3_Label)));

        vbox_ControlHorizontal_Template.setAlignment(Pos.CENTER);
        vbox_ControlHorizontal_Template.setTranslateX(-15);
        vbox_ControlHorizontal_Template.setSpacing(20);

        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                if(object == 0) return sliderLeftLabel;
                if(object == 100) return sliderRightLabel;
                return sliderLeftLabel;
            }

            @Override
            public Double fromString(String string) {
                switch(string){
                    case "LEFT":
                        return 0d;
                    case "RIGHT":
                        return 1d;
                    default:
                        return 1d;
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