package REMtracker.src.PKGremtracker;

import REMtracker.src.PKGminiscope.MiniScope;

/**
 * REMtracker inherits from MiniScope and instatiates the follwoing classes:
 * (REMtrackerDataModel & REMtrackerPane)
 * The class is used to run the REMtracker App
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since   2018-NOV-22
 */
public class REMtracker {

    //Constructor with no arguments
   public REMtracker(){
        MiniScope miniScope = new MiniScope("REM Tracker", 1.0);
        REMtrackerDataModel reMtrackerDataModel = new REMtrackerDataModel();
        REMtrackerPane reMtrackerPane = new REMtrackerPane();
    }
}
