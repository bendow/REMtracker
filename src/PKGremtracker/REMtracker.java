package REMtracker.src.PKGremtracker;

import REMtracker.src.PKGminiscope.MiniScope;
import REMtracker.src.PKGminiscope.MiniScopeDataModel;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * REMtracker inherits from MiniScope and instatiates the follwoing classes:
 * (REMtrackerDataModel & REMtrackerPane)
 * The class is used to run the REMtracker App
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since 2018-NOV-22
 */
public class REMtracker {
    private REMtrackerDataModel reMtrackerDataModel;

    //Constructor with no arguments
    REMtracker() {
    }

    public REMtracker(Stage aStage){

        MiniScope rawdata_Scope = new MiniScope("RAW Data", 1.0, aStage);
        MiniScope fft_Scope = new MiniScope("Mini Scope", 1.0, aStage);

        BorderPane rootLayout = new BorderPane();
        rawdata_Scope.setGUILayout(rootLayout);
        fft_Scope.setGUILayout(rootLayout);

        rawdata_Scope.initDataModel();
        fft_Scope.initDataModel();
        rawdata_Scope.setStage();

        REMtrackerDataModel reMtrackerDataModel = new REMtrackerDataModel(rawdata_Scope, fft_Scope);


    }





}
