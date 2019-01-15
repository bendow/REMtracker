package REMtracker.src.PKGremtracker;

import REMtracker.src.PKGminiscope.MiniScope;
import REMtracker.src.PKGminiscope.MiniScopeDataModel;

/**
 * REMtrackerDataModel inherits from PKGminiscope's MiniScopeDataModel
 * One instance for "RAWdata" and another for "DFT"
 * This class also instantiates the WifiHandler & SerialHandler classes
 * Loads data from Serial to RAWdata
 * Loads data from RAWdata to DFT
 * Future work can include:
 *  - creating, saving & loading profiles
 *  - saving for each profile
 *
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since   2018-NOV-22
 */
public class REMtrackerDataModel {
    private MiniScope rawDataScope = new MiniScope();
    private MiniScope fftScope = new MiniScope();

    private MiniScopeDataModel rawScopeModel;
    private MiniScopeDataModel fftScopeModel;

    //Constructor with no arguments
    public REMtrackerDataModel(){}

    public REMtrackerDataModel(MiniScope rawScope, MiniScope fftScope){
        setMiniScope(rawScope);
        setREMtrackerScope(fftScope);
        setRawScopeModel(rawScope.getMiniScopeDataModel());
        setFFTScopeModel(fftScope.getMiniScopeDataModel());

        rawScopeModel.stylizeGUI();
        rawScopeModel.initScope("Raw Data");
        fftScopeModel.initScope("FFT Data");
        shiftScopes();
    }





    //************START OF GETTER METHODS************

    public MiniScopeDataModel getFFTScopeModel() {
        return fftScopeModel;
    }
    public MiniScopeDataModel getRawScopeModel() {
        return rawScopeModel;
    }

    //*************END OF GETTER METHODS*************


    //************START OF SETTER METHODS************
    public void setMiniScope(MiniScope aScope){
        this.rawDataScope = aScope;
    }
    public void setREMtrackerScope(MiniScope aScope){
        this.fftScope = aScope;
    }
    public void setRawScopeModel(MiniScopeDataModel aModel){rawScopeModel = aModel;}
    public void setFFTScopeModel(MiniScopeDataModel aModel){fftScopeModel = aModel;}
    //*************END OF SETTER METHODS*************


    //************START OF HELPER METHODS************
    public void shiftScopes(){
        this.rawScopeModel.movethisScope(-300,0);
        this.fftScopeModel.movethisScope(300,0);
    }
    //*************END OF HELPER METHODS*************
}
