package REMtracker.src.PKGminiscope;
/**
 * MiniScopeTimerTask handles all time related items including following:
 * - keeps track of real-time
 * - compares the difference between two moments
 * - returns ms, us or ns
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since   2018-NOV-20
 */
public class MiniScopeTimerTask {

  //Global Variables
  public int hour;
  public int minute;
  public int second;
  public int millisecond;
  public int microsecond;

  //Constructor with no arguments
    MiniScopeTimerTask(){}

    //Get the system time
  public void getSystemTime(){}

}
