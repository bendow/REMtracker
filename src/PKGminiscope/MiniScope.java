package REMtracker.src.PKGminiscope;
/**
 * MiniScope instantiates other framework classes such as:
 * (MiniScopeDataModel, MiniScopeTimerTask, Channel & MiniScopeEventRelayer)
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

        setGraph();
        setMenu();
        setScope("Raw Data");
    }
    //Creates a scope
    public void setScope(String scopeName){}

    //Sets a standard menu with buttons, sliders
    public void setMenu(){}

    //Sets the graph
    public void setGraph(){}


}
