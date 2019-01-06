package REMtracker.src.PKGminiscope;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * MiniScopeTimerTask handles all time related items including following:
 * - keeps track of real-time
 * - compares the difference between two moments
 * - returns ms, us or ns
 * <p>
 * NOTE: Nyquist Theorem states that the Sampling Frequency should be 2 * max Frequency of data
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since 2018-NOV-20
 */
public class MiniScopeTimerTask {

    //Global Variables
    public int hour;
    public int minute;
    public int second;
    public int millisecond;

    //Local Variables
    private double samplingFrequency;
    private double dataMaxFrequency;

    //Constructor with no arguments
    MiniScopeTimerTask() {
        getSystemTime();
    }

    /*
     * getSystemTime updates the Military Hour, Minute, Second and Millisecond variables and are publicly available
     * System.currentTimeMillis() and System.nanoTime() may have discrepancies and thus are left out
     */
    public void getSystemTime() {
        Date now = new Date();
        SimpleDateFormat dataFormatter = new SimpleDateFormat("H"); //Military time: "H". Std: "h"
        this.hour = Integer.parseInt(dataFormatter.format(now));
        dataFormatter = new SimpleDateFormat("mm");
        this.minute = Integer.parseInt(dataFormatter.format(now));
        dataFormatter = new SimpleDateFormat("ss");
        this.second = Integer.parseInt(dataFormatter.format(now));
        dataFormatter = new SimpleDateFormat("SSSS");
        this.millisecond = Integer.parseInt(dataFormatter.format(now));


        //Printing out for testing purposes
        //System.out.println("hour: " + hour);
        //System.out.println("minute: " + minute);
        //System.out.println("second: " + second);
        //System.out.println("millisecond: " + millisecond);

        //System.out.println("NanoTime: " + System.nanoTime());
        //System.out.println("Current time in milliseconds: " + System.currentTimeMillis());
    }

    public void setSamplingFreq(double sampleFreq) {
        this.samplingFrequency = sampleFreq;
    }

    public double getSamplingFrequency() {
        return this.samplingFrequency;
    }

    public void setDataMaxFreq(double dataMaxFreq) {
        this.dataMaxFrequency = dataMaxFreq;
    }

    public double getDataMaxFrequency() {
        return this.dataMaxFrequency;
    }


}
