package REMtracker.src.PKGremtracker;
/**
 * SerialHandler sends AT Commands to the ESP-12S
 * Identifies if the USART to TTL controller is connected which is used for initial programming
 * Receives signals data from the ESP-12S module
 *
 * JSerial was going to be used but had some issues with native calls so moving to jSerialComm
 * http://fazecast.github.io/jSerialComm/
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since   2018-NOV-22
 */

import com.fazecast.jSerialComm.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;


public class SerialHandler {

    //Constructor with no arguments
    public SerialHandler() {
        System.out.println("Inside SerialHandler");
        SerialPort[] commPorts = SerialPort.getCommPorts();
        String[] names = new String[commPorts.length];
        for (int i = 0; i < commPorts.length; i++) {
            names[i] = commPorts[i].getSystemPortName();
            System.out.println("CommPort: " + commPorts[i]);
            System.out.println("DescriptivePortName: " + commPorts[i].getDescriptivePortName());
            System.out.println("PortDescription: " + commPorts[i].getPortDescription() );
            System.out.println("SystemPortName: " + commPorts[i].getSystemPortName());
            System.out.println("");
        }


    }





}
