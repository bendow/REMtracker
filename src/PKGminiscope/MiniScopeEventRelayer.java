package REMtracker.src.PKGminiscope;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * MiniScopeEventRelayer handles any and all mouse and keyboard input
 * - Mouse: HoverOver, Clicked, Hold, Release, DoubleClick, Wheel, RightClick, LeftClick, Left&RightMouseButton
 * - Keyboard: Shortcut Keys, Sticky Keys, StandardKeys, NumpadKeys, FunctionKeys
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since   2018-NOV-20
 */
public class MiniScopeEventRelayer {
    MiniScopeDataModel dataModel;
  //Constructor with no arguments
   MiniScopeEventRelayer(){}

    public MiniScopeEventRelayer(MiniScopeDataModel aModel){
       dataModel = new MiniScopeDataModel();
       this.dataModel = aModel;

       setButtonListeners();
    }
    public void setButtonListeners(){
        dataModel.getBtn_Channel().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dataModel.getBtn_Channel().setText("Hello");
            }
        });
    }


}
