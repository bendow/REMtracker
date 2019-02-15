# REMtracker

There are 2 main software packages:
- miniscope
- remtracker

Package "miniscope" contains the following classes:
- Miniscope
- MiniScopeDataModel
- MiniScopeTimerTask
- Channel
- ChannelFunctions
- MiniScopeEnum
- MiniScopeEventRelayer

Package "remtracker" contains the following classes:
- REMtracker
- REMtrackerDataModel
- REMtrackerPane
- WiFiHandler
- SerialHandler

Resources:
Java - Documentation Comments
https://www.tutorialspoint.com/java/java_documentation.htm

ESP8266 AT Instruction set
https://drive.google.com/drive/u/2/folders/1UKcb2f6W9_U75VAvVoi7ugga1rY4GP-t

Troubleshooting:
If you get an error: "package name does not correspond to the file path"
    then, create a Folder named REMtracker inside the src folder
    and place the packages inside it (PKGminiscope & PKGremtracker)

If you have a problem with "import com.fazecast.jSerialComm.*;" 
   then, download the JAR file from: http://fazecast.github.io/jSerialComm/binaries/jSerialComm-2.4.0.jar
   and add it as a dependecy in File>Project Structure>Modules>Dependencies and hit the Green Plus symbol
