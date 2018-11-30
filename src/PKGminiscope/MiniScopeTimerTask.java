package REMtracker.src.PKGminiscope;

import javafx.animation.Animation;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


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
    MiniScopeTimerTask(){
        getSystemTime();
    }

    //Get the system time
  public void getSystemTime(){
      Date now = new Date();
      SimpleDateFormat dataFormatter = new SimpleDateFormat("H"); //Military time: "H". Std: "h"
      this.hour = Integer.parseInt(dataFormatter.format(now));
      dataFormatter = new SimpleDateFormat("mm");
      this.minute = Integer.parseInt(dataFormatter.format(now));
      dataFormatter = new SimpleDateFormat("ss");
      this.second = Integer.parseInt(dataFormatter.format(now));
      dataFormatter = new SimpleDateFormat("ms");
      this.millisecond = Integer.parseInt(dataFormatter.format(now));

      System.out.println("NanoTime: " + System.nanoTime());
      System.out.println("hour: " + hour);
      System.out.println("minute: " + minute);
      System.out.println("second: " + second);
      System.out.println("millisecond: " + millisecond);
      System.out.println("NanoTime: " + System.nanoTime());

     // double nanoseconds = (System.nanoTime() - (this.hour*this.minute*this.second*this.millisecond)) ;
     // System.out.println("Nanoseconds: " + nanoseconds);

  }

}
