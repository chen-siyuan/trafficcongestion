/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleCar;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;

@ClassPreamble (
        author = "Daniel Chen",
        date = "01/14/2020",
        currentRevision = 3.1,
        lastModified = "02/14/2020",
        lastModifiedBy = "Daniel Chen"
)
public class Frame extends JFrame {
    
    private Board board;
    private boolean record;
    private int frameNumber;
    
    public Frame(boolean record, int frameNumber) {
        
        this.record = record;
        this.frameNumber = frameNumber;
        
        board = new Board(record, frameNumber);
        
    }
    
    public Board getBoard() {
        return board;
    }
    
    public void addVehicle(Vehicle vehicle) {
        board.addVehicle(vehicle);
    }
    
    public void addVehicles(Vehicle[] vehicles) {
        board.addVehicles(vehicles);
    }
    
    public void addVehicles(ArrayList<Vehicle> vehicles) {
        board.addVehicles(vehicles);
    }
    
    public void addObstacle(Obstacle obstacle) {
        board.addObstacle(obstacle);
    }
    
    public void addObstacles(Obstacle[] obstacles) {
        board.addObstacles(obstacles);
    }
    
    public void addObstacles(ArrayList<Obstacle> obstacles) {
        board.addObstacles(obstacles);
    }
    
    public void initUI() {
        
        add(board);
        
        setPreferredSize(new Dimension((int)Math.round(Main.FRAME_WIDTH * Main.PIXELS_PER_METER),
                (int)Math.round(Main.FRAME_HEIGHT * Main.PIXELS_PER_METER)));
        setResizable(false);
        pack();
        
        setTitle("Simple Car");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
