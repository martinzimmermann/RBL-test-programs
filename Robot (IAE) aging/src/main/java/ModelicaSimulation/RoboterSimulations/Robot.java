package ModelicaSimulation.RoboterSimulations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.javafmi.wrapper.Simulation;

public class Robot {    
    private static final Robot instance = new Robot();
    
    //private constructor to avoid client applications to use constructor
    private Robot(){}

    //public static GeorgsRoboterSimulation getInstance(){
    public static Robot getInstance(){
        return instance;
    }

    Simulation simulation;
    double stepSize;
    int max_steps;
    int current_steps;

    ArrayList<Double> x_position;
    ArrayList<Double> y_position;

    public int ticksStraigth;
    public double deviationFromY; 
        
    public Double getXPos()
    {
        return x_position.get(x_position.size()-1);
    }

    public Double getYPos()
    {
        return y_position.get(y_position.size()-1);
    }

    public void initilizeSimulation(String pathtoFMU, double startTime, double stopTime, int steps)
    {
        simulation = new Simulation(pathtoFMU);
        simulation.init(startTime, stopTime);
        stepSize = (stopTime - startTime)/steps;
        max_steps = steps;
        current_steps = 0;

        x_position = new ArrayList<Double>();
        y_position = new ArrayList<Double>();
        ticksStraigth = 0;
        deviationFromY = 0;
    }


    public void driveNormal()
    {
        simulation.write("uL").with(3);
        simulation.write("uR").with(3);
        finishStep();
    }

    public void driveLeftHalf()
    {
        simulation.write("uL").with(1.5);
        simulation.write("uR").with(3);
        finishStep();
    }

    public void driveRightHalf()
    {
        simulation.write("uL").with(3);
        simulation.write("uR").with(1.5);
        finishStep();
    }

    private void finishStep() {
        simulation.doStep(stepSize);
        x_position.add(simulation.read("x").asDouble());
        y_position.add(simulation.read("y").asDouble());

        double epsilon = 0.01;
        double left = simulation.read("alphaL").asDouble();
        double right = simulation.read("alphaR").asDouble();

        if(Math.abs(left - right) < epsilon){
            ticksStraigth++;
        }
    
        double y = simulation.read("y").asDouble();
        deviationFromY += Math.abs(0 - y);
    }

    public enum DriveDirection {Straight, Left, Right}
    public DriveDirection getDrivingDirection(){
        double epsilon = 0.01;
        double left = simulation.read("alphaL").asDouble();
        double right = simulation.read("alphaR").asDouble();

        if(Math.abs(left - right) < epsilon){
            return DriveDirection.Straight;
        }            
        else if(left < right)
            return DriveDirection.Left;
        else
            return DriveDirection.Right;
    }
}