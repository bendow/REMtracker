package REMtracker.src.PKGminiscope;
/**
 * MiniScope instantiates other framework classes such as:
 * (MiniScopeDataModel, MiniScopeTimerTask, Channel & MiniScopeEventRelayer)
 * 
 * setGUI() shows one default scope in the center of a GridPane Layout
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since   2018-NOV-20
 */

public class MiniScope {
    
    //Global Variables
    String appName;
    double version;
    MiniScopeDataModel miniScopeDataModel;
    MiniScopeTimerTask miniScopeTimerTask;
    MiniScopeEventRelayer miniScopeEventRelayer;
    Channel scopeChannel;
    
    //Local Variables

    //Constructor with no arguments
    public MiniScope(){}

    //Constructor with arguments instantiating associative classes
    public MiniScope(String theAppName, double theVersion){
        this.appName = theAppName;
        this.version = theVersion;
        miniScopeDataModel = new MiniScopeDataModel();
        miniScopeTimerTask = new MiniScopeTimerTask();
        miniScopeEventRelayer = new MiniScopeEventRelayer();
        scopeChannel = new Channel();
    }
    
    //setGUI sets a default GUI by using the data from miniScopeDataModel
    //Should REMtracker edit the GUI? NO for now - it should however display it
    //This GUI should leave left, right, top & bottom border blank for REMtracker to fill
    public void setGUI(){}
    
    
    
    
 
    
    


}
