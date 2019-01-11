package REMtracker.src.PKGminiscope;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
    private VBox col_2_VBox = new VBox();
    private VBox col_3_VBox = new VBox();
    private VBox col_4_VBox = new VBox();
    private VBox col_5_VBox = new VBox();

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



    //**************************COLUMN 2 SECTION*******************************
    public VBox getColumn_2_VBox(){return col_2_VBox;}
    public void setColumn_2_VBox(){

    }
    //************************END COLUMN 2 SECTION*****************************



    //**************************COLUMN 3 SECTION*******************************
    public VBox getColumn_3_VBox(){return col_3_VBox;}
    public void setColumn_3_VBox(){

    }
    //************************END COLUMN 3 SECTION*****************************



    //**************************COLUMN 4 SECTION*******************************
    public VBox getColumn_4_VBox(){return col_4_VBox;}
    public void setColumn_4_VBox(){

    }
    //************************END COLUMN 4 SECTION*****************************



    //**************************COLUMN 5 SECTION*******************************
    public VBox getColumn_5_VBox(){return col_5_VBox;}
    public void setColumn_5_VBox(){

    }
    //************************END COLUMN 5 SECTION*****************************


}