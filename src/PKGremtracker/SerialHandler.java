package REMtracker.src.PKGremtracker;
/**
 * SerialHandler sends AT Commands to the ESP-12S
 * Identifies if the USART to TTL controller is connected which is used for initial programming
 * Receives signals data from the ESP-12S module
 * <p>
 * JSerial was going to be used but had some issues with native calls so moving to jSerialComm
 * http://fazecast.github.io/jSerialComm/
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since 2018-NOV-22
 */

import com.fazecast.jSerialComm.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;


public class SerialHandler {
    SerialPort[] commPorts;
    byte[] messgae2User;
    byte[] message2Device;
    int baudrate;

    //Constructor with no arguments
    public SerialHandler() {
        System.out.println("Inside SerialHandler");
        commPorts = SerialPort.getCommPorts();
        String[] names = new String[commPorts.length];
        for (int i = 0; i < commPorts.length; i++) {
            names[i] = commPorts[i].getSystemPortName();
            System.out.println("CommPort: " + commPorts[i] + ", i = " + i);
            System.out.println("DescriptivePortName: " + commPorts[i].getDescriptivePortName());
            System.out.println("PortDescription: " + commPorts[i].getPortDescription());
            System.out.println("SystemPortName: " + commPorts[i].getSystemPortName());
            System.out.println("");
        }

    }

    public enum endLine {
        BOTH_NL_and_CR,
        CARRIAGE_RETURN,
        NEWLINE,
        NO_LINE_ENDING
    }

    public void isCommPortAvailable(int port) {
        Boolean availableStatus = commPorts[2].isOpen();
        if (availableStatus)
            System.out.println("Com port [" + port + "] is not Open");
        else
            System.out.println("Comm port [" + port + "] is Open with " +
                    commPorts[port].getPortDescription());
    }

    public void openPort(int port) {
        byte[] byteArray;
        long alongVar = 1;
        commPorts[port].openPort();

        System.out.println("Current BaudRate: " + commPorts[port].getBaudRate());
        byteArray = new byte[commPorts[port].bytesAvailable()];
        System.out.println("Number of Bytes available: " + byteArray.length);
        //byteArray[0] = 110;
        //commPorts[port].writeBytes(byteArray, alongVar);
        //byteArray = new byte[commPorts[port].bytesAvailable()];
        //System.out.println("Number of Bytes available: " + byteArray.length);
        //commPorts[port].readBytes(byteArray, alongVar);

        commPorts[port].closePort();

    }


}
