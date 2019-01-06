package REMtracker.src.PKGminiscope;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * MiniScopeDataModel instantiates the objects necessary for producing the GUI
 * This class also instantiates other framework classes such as:
 * (ChannelFunctions & MiniScopeEnums)
 * Refer to the REMtracker SDD for GUI Objects
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since 2018-NOV-20
 */
public class MiniScopeDataModel {

    //Global Variables
    public ChannelFunctions channelFunctions;
    public MiniScopeEnums miniScopeEnums;

    //Local Variables
    private String scopeName;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private Border border;
    private Label lbl_scopeName;
    private Group grp_Graph, grp_Results, grp_Controls, grp_HiddenMenu;
    private StackPane stPane_Graph, stPane_Results, stPane_Controls, stPane_HiddenMenu;
    private Rectangle graph_Rect, results_Rect, controls_Rect, menu_Rect;
    private VBox center_VBox;
    private Text text1, text2, text3, text4, text5, text6, text7, text8, text9;
    private GridPane grPane_Results;


    //************START OF CONSTRUCTORS************
    public MiniScopeDataModel() {
    } //Constructors w/o args

    public MiniScopeDataModel(Stage aStage, BorderPane aLayout) {
        this.primaryStage = aStage;
        this.rootLayout = aLayout;
        channelFunctions = new ChannelFunctions();
        miniScopeEnums = new MiniScopeEnums();
        stylizeGUI();
        initScope("MiniScope");
    } //Constructors w/ args
    //************END OF CONSTRUCTORS************


    //************START OF INIT METHODS************
    private void stylizeGUI() {
        //stylizeGUI sets BorderPane borders and sizes for all regions: top, bot, left, right & center
        setBorder();
        rootLayout.setBorder(this.border);
        double screenWidth = getScreenDimensions().getWidth() * 0.95;
        double screenHeight = getScreenDimensions().getHeight();

        //Top pane
        Rectangle rect_TopPane = new Rectangle();
        rect_TopPane.setStroke(Color.BLACK);
        rect_TopPane.setFill(Color.TRANSPARENT);
        rect_TopPane.setWidth(screenWidth);
        rect_TopPane.setTranslateX(-3); //Shifting so the borders overlap
        rect_TopPane.setHeight(screenHeight * 0.10);
        StackPane stPane_Top = new StackPane();
        stPane_Top.getChildren().add(rect_TopPane);
        rootLayout.setTop(stPane_Top);

        //Left Pane
        Rectangle rect_LeftPane = new Rectangle();
        rect_LeftPane.setStroke(Color.BLACK);
        rect_LeftPane.setFill(Color.TRANSPARENT);
        rect_LeftPane.setWidth(screenWidth * 0.10);
        rect_LeftPane.setTranslateX(-3);
        rect_LeftPane.setHeight(screenHeight * 0.75);
        StackPane stPane_Left = new StackPane();
        stPane_Left.getChildren().add(rect_LeftPane);
        rootLayout.setLeft(stPane_Left);


        //Right Pane
        Rectangle rect_RightPane = new Rectangle();
        rect_RightPane.setStroke(Color.BLACK);
        rect_RightPane.setFill(Color.TRANSPARENT);
        rect_RightPane.setWidth(screenWidth * 0.10);
        rect_RightPane.setTranslateX(-5);
        rect_RightPane.setHeight(screenHeight * 0.75);
        StackPane stPane_Right = new StackPane();
        stPane_Right.getChildren().add(rect_RightPane);
        rootLayout.setRight(stPane_Right);

        //Bottom Pane
        Rectangle rect_BottomPane = new Rectangle();
        rect_BottomPane.setStroke(Color.BLACK);
        rect_BottomPane.setFill(Color.TRANSPARENT);
        rect_BottomPane.setWidth(screenWidth);
        rect_BottomPane.setTranslateX(-3);
        rect_BottomPane.setHeight(screenHeight * 0.10);
        StackPane stPane_Bottom = new StackPane();
        stPane_Bottom.getChildren().add(rect_BottomPane);
        rootLayout.setBottom(stPane_Bottom);

        //Center Pane
        Rectangle rect_CenterPane = new Rectangle();
        rect_CenterPane.setStroke(Color.BLACK);
        rect_CenterPane.setFill(Color.TRANSPARENT);
        rect_CenterPane.setWidth(screenWidth - (2 * rect_LeftPane.getWidth()));
        rect_CenterPane.setTranslateX(-4);
        rect_CenterPane.setHeight(rect_LeftPane.getHeight());
        StackPane stPane_Center = new StackPane();
        stPane_Center.getChildren().add(rect_CenterPane);
        rootLayout.setCenter(stPane_Center);
    }

    private void initScope(String aScopeName) {
        //Set up a default scope with all buttons, sliders, graph, etc...
        //Setup the Scope label
        setScopeLabel(aScopeName);

        //Setup groups for all scope sections(Graph, Results, Controls, HiddenMenu)
        setScopeGroups();

        //Setup the StackPanes for all scope sections(Graph, Results, Controls, HiddenMenu)
        setScopeStackPanes();

        //Setup all rectangles for the scope
        setScopeRectangles();

        //Load StackPanes
        loadStackPanes();

        //load Groups
        loadGroups();

        //Place all groups into the center of the BorderPane
        setGroupsToCenterPane();

        //Adjust the alignment of the Scope
        setScopeAlignment(center_VBox);

        //Setup the Graph area of this scope

        //Setup the Results area of this scope
        setupResultsSection();

        //Setup the Controls area of this scope
        setupControlsSection();

        //Setup the Hidden Menu area of this scope

    }

    private void setupResultsSection() {
        /**GridPane in Results Section
         * This section consists of a 3x3 grid
         * Each cell will include A Title, A Value and A Unit of Measurement
         * Keep in mind that the area is limited to the area provided by the results_Rect
         */
        grPane_Results = new GridPane();
        text1 = new Text();
        text2 = new Text();
        text3 = new Text();
        setResultText1(new Text("Max V: 100mV"));
        setResultText2(new Text("Min V: 0mV"));
        setResultText3(new Text("Counts/s: 1024"));
        grPane_Results.add(text1, 0, 0);
        grPane_Results.add(text2, 0, 1);
        grPane_Results.add(text3, 0, 2);

        text4 = new Text();
        text5 = new Text();
        text6 = new Text();
        setResultsText4(new Text("Peak V: 99mV"));
        setResultsText5(new Text("RMS V: 69.99mV"));
        setResultsText6(new Text("VACANT"));
        grPane_Results.add(text4, 1, 0);
        grPane_Results.add(text5, 1, 1);
        grPane_Results.add(text6, 1, 2);

        text7 = new Text();
        text8 = new Text();
        text9 = new Text();
        setResultsText7(new Text("VACANT"));
        setResultsText8(new Text("VACANT"));
        setResultsText9(new Text("VACANT"));
        grPane_Results.add(text7, 2, 0);
        grPane_Results.add(text8, 2, 1);
        grPane_Results.add(text9, 2, 2);

        //stPane_Results.getChildren().add(grPane_Results.getChildren().get(1));
        stPane_Results.getChildren().add(grPane_Results);
        grPane_Results.setHgap(85);
        grPane_Results.setVgap(10);
        grPane_Results.setAlignment(Pos.CENTER);
    }

    private void setupControlsSection(){
        HBox hbox_controls_COL1, hbox_controls_COL2, hbox_controls_COL3, hbox_controls_COL4, hbox_controls_COL5;
        hbox_controls_COL1 = new HBox();
        VBox vbox_controls_buttons = new VBox();
        vbox_controls_buttons.setSpacing(10);
        vbox_controls_buttons.setTranslateY(10);
        vbox_controls_buttons.setTranslateX(5);

        Button btn_Grid = new Button("Grid");
        Button btn_Text = new Button("Text");
        Button btn_Channel = new Button("Channel");
        Button btn_Cursors = new Button("Cursors");
        Button btn_Menu = new Button("Menu");
        HBox hbox_grid_TextButton = new HBox(btn_Grid, btn_Text);
        hbox_grid_TextButton.setSpacing(5);

        vbox_controls_buttons.getChildren().addAll(btn_Channel, hbox_grid_TextButton, btn_Cursors, btn_Menu);
        hbox_controls_COL1.getChildren().add(vbox_controls_buttons);

        stPane_Controls.getChildren().add(hbox_controls_COL1);

        btn_Channel.setPrefWidth(85);
        btn_Grid.setPrefWidth(40);
        btn_Text.setPrefWidth(40);
        btn_Cursors.setPrefWidth(85);
        btn_Menu.setPrefWidth(85);
    }

    private void loadStackPanes() {
        stPane_Graph.getChildren().add(graph_Rect);
        stPane_Results.getChildren().add(results_Rect);
        stPane_Controls.getChildren().add(controls_Rect);
        stPane_HiddenMenu.getChildren().add(menu_Rect);
    }

    private void loadGroups() {
        grp_Graph.getChildren().add(stPane_Graph);
        grp_Results.getChildren().add(stPane_Results);
        grp_Controls.getChildren().add(stPane_Controls);
        grp_HiddenMenu.getChildren().add(stPane_HiddenMenu);
    }
    //**************END OF INIT METHODS**************


    //************START OF GETTER METHODS************
    public Border getBorder() {
        return this.border;
    }

    public Rectangle2D getScreenDimensions() {
        //Getting Screen Dimensions
        return new Rectangle2D(0, 0, Screen.getPrimary().getVisualBounds().getWidth(),
                Screen.getPrimary().getVisualBounds().getHeight());
    }

    public String getScopeName() {
        //Get the name of the current Scope
        return this.scopeName;
    }
    //*************END OF GETTER METHODS*************


    //************START OF SETTER METHODS************
    public void setResultText1(Text aText) {
        text1 = aText;
    }

    public void setResultText2(Text aText) {
        text2 = aText;
    }

    public void setResultText3(Text aText) {
        text3 = aText;
    }

    public void setResultsText4(Text aText) {
        text4 = aText;
    }

    public void setResultsText5(Text aText) {
        text5 = aText;
    }

    public void setResultsText6(Text aText) {
        text6 = aText;
    }

    public void setResultsText7(Text aText) {
        text7 = aText;
    }

    public void setResultsText8(Text aText) {
        text8 = aText;
    }

    public void setResultsText9(Text aText) {
        text9 = aText;
    }

    public void setScopeAlignment(VBox aBox) {
        aBox.setTranslateY(20);
    }

    public void setScopeLabel(String aName) {
        //Scope Section: Name
        this.scopeName = aName;
        lbl_scopeName = new Label(this.scopeName);
        lbl_scopeName.setFont(Font.font(20));
    }

    public void setScopeGroups() {
        grp_Graph = new Group();

        grp_Results = new Group();
        grp_Results.setTranslateY(-3);

        grp_Controls = new Group();
        grp_Controls.setTranslateY(20);

        grp_HiddenMenu = new Group();
    }

    public void setScopeStackPanes() {
        stPane_Graph = new StackPane();
        stPane_Results = new StackPane();
        stPane_Controls = new StackPane();
        stPane_HiddenMenu = new StackPane();
    }

    public void setScopeRectangles() {

        //Scope Section: Graph
        graph_Rect = new Rectangle(500, 350);
        graph_Rect.setFill(Color.WHITE);
        graph_Rect.setStroke(Color.BLACK);

        //Scope Section: Results
        results_Rect = new Rectangle(500, 100);
        results_Rect.setFill(Color.WHITE);
        results_Rect.setStroke(Color.BLACK);

        //Scope Section: Controls
        controls_Rect = new Rectangle(500, 150);
        controls_Rect.setFill(Color.WHITE);
        controls_Rect.setStroke(Color.BLACK);

        //Scope Section: Hidden Menu
        menu_Rect = new Rectangle(500, 100);
        menu_Rect.setFill(Color.WHITE);
        menu_Rect.setStroke(Color.BLACK);
        menu_Rect.setVisible(false);
    }

    public void setBorder() {
        //setBorder sets the borders around each of the borderpane's sections(top, bottom, left, right & center)
        this.border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    }

    public void setGroupsToCenterPane() {
        //Making a VBox to contain & vertically center the Scope Label and Scope Rectangles
        center_VBox = new VBox();
        center_VBox.setAlignment(Pos.CENTER);
        center_VBox.getChildren().addAll(lbl_scopeName, grp_Graph, grp_Results, grp_Controls, grp_HiddenMenu);

        //Fetching the StackPane that is in Center to load it with scopeVBox
        StackPane stPane_Center = (StackPane) rootLayout.getCenter();
        stPane_Center.getChildren().add(center_VBox);
    }

    public void setScopeName(String theScopeName) {
        //Let the scope be renamed
        this.scopeName = theScopeName;
    }
    //*************END OF SETTER METHODS*************
}
