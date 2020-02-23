/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleCar;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;

@ClassPreamble (
        author = "Daniel Chen",
        date = "01/14/2020",
        currentRevision = 7,
        lastModified = "02/23/2020",
        lastModifiedBy = "Daniel Chen"
)
public class Main {
    
    public static final String ASSETS_ADDRESS = "assets/";
    public static final String OUTPUT_ADDRESS = "output/";
    
    public static final Color BOARD_COLOR = new Color(214, 232, 202);
    
    public static final Color SLOW_VEHICLE_COLOR = new Color(255, 0, 0);
    public static final Color FAST_VEHICLE_COLOR = new Color(0, 0, 255);
    
    public static final double PIXELS_PER_METER = 80. / 3;
    public static final double MILLISECONDS_PER_SECOND = 1000; //use this to change display render speed

    public static final double PANEL_WIDTH = 1000. / PIXELS_PER_METER; //meter
    public static final double PANEL_HEIGHT = 600. / PIXELS_PER_METER; //meter
    public static final double FRAME_WIDTH = PANEL_WIDTH;
    public static final double FRAME_HEIGHT = PANEL_HEIGHT;
    public static final double INTERVAL = 0.01;//second
    public static final double THRESHOLD = 0.5;
    
    /**
     * 
     * @param vehiclesMap a HashMap object specifying the number of cars and buses wanted
     * @return an ArrayList object containing the specified number of cars and buses
     */
    public static ArrayList<Vehicle> getVehiclesList(HashMap vehiclesMap) {
        
        ArrayList<Vehicle> vehiclesList = new ArrayList<Vehicle>();
        
        vehiclesList.addAll(Car.getCarsList((int)vehiclesMap.get("car")));
        vehiclesList.addAll(Bus.getBusesList((int)vehiclesMap.get("bus")));
        
        return vehiclesList;
    }
    
    public static ArrayList<Obstacle> getObstaclesList(HashMap obstaclesMap) {
        
        ArrayList<Obstacle> obstaclesList = new ArrayList<Obstacle>();
        
        obstaclesList.addAll(Pedestrian.getPedestriansList((int)obstaclesMap.get("pedestrian")));
        
        return obstaclesList;
    }
    
    public static void main(String[] args) {
        
//        Road road = new Road(new Size(Math.sqrt(5), Math.sqrt(20)), new Position(2.5, 2), Velocity.velocityFromComponents(-1, 2), 2);
//        Road road = new Road(new Size(Math.sqrt(10), Math.sqrt(40)), new Position(3.5, 2.5), Velocity.orientationFromComponents(1, 3), 4);

//        Lane lane = new Lane(new Size(Math.sqrt(5), Math.sqrt(5)), new Position(-0.5, -0.5), Velocity.orientationFromComponents(1, 2));
//        
//        System.out.println(lane.getDetectionPosition().getXPosition());
//        System.out.println(lane.getDetectionPosition().getYPosition());
//        
//        System.out.println(lane.onLane(new Position(-1, -1)));
//        System.out.println(lane.inRange(new Position(-1, -1)));
//        
//        System.out.println(lane.onLane(new Position(2, -2)));
//        System.out.println(lane.inRange(new Position(2, -2)));
//        
//        System.out.println(lane.onLane(new Position(1, 1)));
//        System.out.println(lane.inRange(new Position(1, 1)));
        
        HashMap vehiclesMap = new HashMap();
        
        vehiclesMap.put("car", 1);
        vehiclesMap.put("bus", 0);
        
        ArrayList<Vehicle> vehiclesList = getVehiclesList(vehiclesMap);
        
//        vehiclesList.get(0).setPosition(new Position(50 / PIXELS_PER_METER, 250 / PIXELS_PER_METER)); // 1
//        vehiclesList.get(0).setVelocity(new Velocity(10, Math.PI * 0 / 2));
        
//        vehiclesList.get(0).setPosition(new Position(350 / PIXELS_PER_METER, 50 / PIXELS_PER_METER)); // 2
//        vehiclesList.get(0).setVelocity(new Velocity(10, Math.PI * 1 / 2));
        
//        vehiclesList.get(0).setPosition(new Position(950 / PIXELS_PER_METER, 350 / PIXELS_PER_METER)); // 3
//        vehiclesList.get(0).setVelocity(new Velocity(10, Math.PI * 2 / 2));
//        
        vehiclesList.get(0).setPosition(new Position(250 / PIXELS_PER_METER, 550 / PIXELS_PER_METER));
        vehiclesList.get(0).setVelocity(new Velocity(10, Math.PI * 3 / 2));
        
//        HashMap obstaclesMap = new HashMap();
//        
//        obstaclesMap.put("pedestrian", 1);
//        
//        ArrayList<Obstacle> obstaclesList = getObstaclesList(obstaclesMap);
//        
//        obstaclesList.get(0).setPosition(new Position(20, 10));
//        obstaclesList.get(0).setVelocity(new Velocity(5, Math.PI * 3 / 2));
//        obstaclesList.get(0).setPath(new Path(true,
//                new Position(20, 10),
//                new Position(17, 10),
//                new Position(17, 2),
//                new Position(10, 2),
//                new Position(10, 12),
//                new Position(15, 12),
//                new Position(15, 7),
//                new Position(20, 7)));
        
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                Frame frame = new Frame(false, 250);
                
                frame.addVehicles(vehiclesList);
//                frame.addObstacles(obstaclesList);
                
                frame.initUI();
                frame.setVisible(true);

            }
            
        });

    }
    
}
