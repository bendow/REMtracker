package REMtracker.src.PKGminiscope;
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
 * @since   2018-NOV-20
 */
public class MiniScopeDataModel {

  //Global Variables
  public ChannelFunctions channelFunctions;
  public MiniScopeEnums miniScopeEnums;
  //Local Variables

  //Constructor with no arguments instantiates associative classes
    public MiniScopeDataModel(){
      channelFunctions = new ChannelFunctions();
      miniScopeEnums = new MiniScopeEnums();
    }
}
