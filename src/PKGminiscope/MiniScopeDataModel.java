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
  private scopeName;

  //Constructor with no arguments instantiates associative classes
    public MiniScopeDataModel(){
      channelFunctions = new ChannelFunctions();
      miniScopeEnums = new MiniScopeEnums();
    }
  
  //Set up a default scope with all buttons, sliders, graph, etc...
  public void setScope(String aScopeName){
  this.scopeName = aScopeName;
  }
  
  //Let the scope be renamed
  public void setScopeName(String theScopeName){
    this.scopeName = theScopeName;
  }
  
  //Get the name of the current Scope
  public String getScopeName(){
    return this.scopeName;
  }
  
  //Should the data be handled in REMtrackerDataModel leaving the MiniScopeDataModel as a framework?
  //I'm thinking that MiniScopeDataModel creates variables like arrays to store data but are empty for REMtrackerDataModel to fill.
  
  //setColors sets the text, background and foreground color
  //setCursors sets both cursors for Vertical and Horizontal
  //toggleText toggles the visibility of the text section underneath the graph
  //setGraph sets the graph
  //setButtons sets all of the buttons, sizes, label, visibility and position
  
  
  
}
