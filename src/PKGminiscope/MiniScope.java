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
    public String appName;
    public double version;
    public MiniScopeDataModel miniScopeDataModel;
    public MiniScopeTimerTask miniScopeTimerTask;
    public MiniScopeEventRelayer miniScopeEventRelayer;
    public Channel scopeChannel;
    
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
}
