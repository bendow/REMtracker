package REMtracker.src.PKGremtracker;

import REMtracker.src.PKGminiscope.MiniScope;
import REMtracker.src.PKGminiscope.MiniScopeDataModel;
import javafx.scene.chart.XYChart;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.FastFourierTransformer.*;
import org.apache.commons.math3.transform.TransformType;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * REMtrackerDataModel inherits from PKGminiscope's MiniScopeDataModel
 * One instance for "RAWdata" and another for "FFT"
 * This class also instantiates the WifiHandler & SerialHandler classes
 * Loads data from Serial to RAWdata
 * Loads data from RAWdata to FFT
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


    double[][] rawData;
    double[][] fftData;
    boolean fftDoneFlag = false;

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
        generateRandom2Ddouble();
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

    //************START OF MUTATOR METHODS************
    // This should be where the fftScopeModel gets changed to accomodate the FFT Graph
    public boolean updateFFTScopeModel(double[][] data, int numPackets){
        //Store the rawData and hold it
        rawData = data;
        //Getting the fftData ready
        fftData = new double[2][numPackets];

        //for (int i = 0; i < 2; i++) {
            for (int j = 0; j < (numPackets); j++) {
                fftData[0][j] = Math.abs(rawData[0][j]);
                fftData[1][j] = 0.0;
            }
       // }

        double voltageThreshold = 1.0;
        double magnitudeThreshold = 50.0;
        FastFourierTransformer.transformInPlace(fftData, DftNormalization.STANDARD, TransformType.FORWARD);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < (numPackets); j++) {
                fftData[i][j] = Math.ceil(Math.abs(fftData[i][j]));
            }
        }

        for (int j = 0; j < (numPackets); j++) {
            //Replacing the complex for magnitude
            fftData[1][j] = Math.sqrt(fftData[0][j] * fftData[0][j] + fftData[1][j] * fftData[1][j]);
        }


        if(rawData != fftData) {
            fftDoneFlag = true;

            //Update graph here
            rawScopeModel.series.getData().clear();
            fftScopeModel.series.getData().clear();
            fftScopeModel.yAxis.setLabel("Magnitude");
            fftScopeModel.xAxis.setLabel("Frequency");

            double delta = 0.1;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < (numPackets); j++) {
                    if (rawData[0][j] < voltageThreshold) {
                        //rawScopeModel.series.getData().add(new XYChart.Data(rawData[1][j] - delta, 0));
                        rawScopeModel.series.getData().add(new XYChart.Data(rawData[1][j], rawData[0][j]));
                        //rawScopeModel.series.getData().add(new XYChart.Data(rawData[1][j] + delta, 0));
                    }

                    if(j!=0) {
                        //yAxis = Magnitude, xAxis = Frequency
                        fftScopeModel.series.getData().add(new XYChart.Data(fftData[0][j] - delta, 0));
                        fftScopeModel.series.getData().add(new XYChart.Data(Math.abs(fftData[0][j]), fftData[1][j]));
                        fftScopeModel.series.getData().add(new XYChart.Data(fftData[0][j] + delta, 0));

                        //yAxis = Freq, xAxis = Time
                        //fftScopeModel.series.getData().add(new XYChart.Data(rawData[1][j] - delta, 0));
                        //fftScopeModel.series.getData().add(new XYChart.Data(rawData[1][j], Math.abs(fftData[0][j] )));
                        //fftScopeModel.series.getData().add(new XYChart.Data(rawData[1][j] + delta, 0));
                        System.out.println("fftData[" + i + "][" + j + "] = " + fftData[i][j]);
                    }
                }
            }
        }
        else
            fftDoneFlag = false;
        return fftDoneFlag;
    }
    //*************END OF MUTATOR METHODS*************

    // This is a random data generator for a 2 dimensional double datatype
    // This will be used to test the FFT
    public void generateRandom2Ddouble() {
        Random rnd = new Random(); //Creating a Random object
        int sizeOfArray = 10;
        int numRows = 2;
        int numColumns = 512;
        int timeCounter = 1;
        double[][] dummyData = new double[numRows][numColumns];
        for (int i = 0; i < (numRows); i++) {
            for (int j = 0; j < (numColumns); j++) {
                //Assuming Row 0 is Voltage & Row 1 is Time
                if (i == 0) {
                    dummyData[i][j] = Math.abs(rnd.nextDouble()); //Returns a random double value between 0.0 & 1.0
                    System.out.println("dummyData[" + i + "][" + j + "] = " + dummyData[i][j]);
                } else if (i == 1) { //This is the Time part of the data
                    dummyData[i][j] = timeCounter++;
                    System.out.println("dummyData[" + i + "][" + j + "] = " + dummyData[i][j]);
                } else {
                    dummyData[i][j] = 0.0;
                    System.out.println("dummyData[" + i + "][" + j + "] = " + dummyData[i][j]);
                }
            }
        }
        updateFFTScopeModel(dummyData, numColumns);
    }



}