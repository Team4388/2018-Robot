
package org.usfirst.frc4388.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import org.usfirst.frc4388.controller.Robot.OperationMode;
import org.usfirst.frc4388.robot.commands.*;
import org.usfirst.frc4388.robot.commands.auton.*;
import org.usfirst.frc4388.robot.OI;
import org.usfirst.frc4388.robot.subsystems.*;
import org.usfirst.frc4388.utility.ControlLooper;
import org.usfirst.frc4388.robot.subsystems.Drive;
import org.usfirst.frc4388.robot.subsystems.Carriage;
import org.usfirst.frc4388.robot.subsystems.LED;
import org.usfirst.frc4388.robot.subsystems.Drive.DriveControlMode;;

public class Robot extends IterativeRobot 
{

	public static OI oi;
	
	public static final Drive drive = new Drive();


    public static final Carriage carriage = new Carriage();
    public static final Elevator elevator = new Elevator();
    
    
    public static final LED led = new LED();

    public static final Climber climber = new Climber();
    public static final Pnumatics pnumatics = new Pnumatics();
	public static final long periodMS = 10;
	public static final ControlLooper controlLoop = new ControlLooper("Main control loop", periodMS);

	public static enum OperationMode { TEST, COMPETITION };
	public static OperationMode operationMode = OperationMode.TEST;

	private SendableChooser<OperationMode> operationModeChooser;
	private SendableChooser<Command> RRautonTaskChooser;
	private SendableChooser<Command> RLautonTaskChooser;
	private SendableChooser<Command> LRautonTaskChooser;
	private SendableChooser<Command> LLautonTaskChooser;

    private Command RRautonomousCommand;
    private Command RLautonomousCommand;
    private Command LRautonomousCommand;
    private Command LLautonomousCommand;
    
    public void robotInit() 
    {
    	//Printing game data to riolog
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	System.out.println(gameData);
    	CameraServer.getInstance().startAutomaticCapture();
    	CameraServer.getInstance().putVideo("res", 300, 220);
    	
      try {
		oi = OI.getInstance();
		
    	controlLoop.addLoopable(drive);
    	controlLoop.addLoopable(elevator);
			

        operationModeChooser = new SendableChooser<OperationMode>();
	    operationModeChooser.addDefault("Test", OperationMode.TEST);
	    operationModeChooser.addObject("Competition", OperationMode.COMPETITION);
		SmartDashboard.putData("Operation Mode", operationModeChooser);
		
		
		
		
		
		RRautonTaskChooser = new SendableChooser<Command>();
		
		RRautonTaskChooser.addDefault("Choose RR Program", new CrossTheBaseLine());
		
		
		RRautonTaskChooser.addObject("Right too 2 Cube Scale", new Cube2Right());		
		RRautonTaskChooser.addObject("Center too right 2 Cube", new CenterRight2Cube());
		RRautonTaskChooser.addObject("Left to Right Switch", new LeftStartRightScore());
		RRautonTaskChooser.addObject("Center to Right Switch", new CenterRight());
		RRautonTaskChooser.addObject("Right to Right Switch", new RightSwitchAuton());
		RRautonTaskChooser.addObject("Right to Right tall boi", new ScaleFrom3());

		
		SmartDashboard.putData("RRAuton Task", RRautonTaskChooser);
		
		
		
		
		
		RLautonTaskChooser = new SendableChooser<Command>();
		
		RLautonTaskChooser.addDefault("Choose RL Program", new CrossTheBaseLine());
		

		RLautonTaskChooser.addObject("Left to Right Switch", new LeftStartRightScore());
		RLautonTaskChooser.addObject("Left to Left tall boi", new ScaleFrom1());
		RLautonTaskChooser.addObject("Center too right 2 Cube", new CenterRight2Cube());
		RLautonTaskChooser.addObject("Center to Right Switch", new CenterRight());
		RLautonTaskChooser.addObject("Right to Right Switch", new RightSwitchAuton());
		RLautonTaskChooser.addObject("Left to left 2 Cube Scale", new Cube2Left());
		
		
		
		SmartDashboard.putData("RLAuton Task", RLautonTaskChooser);
		
		
		
		
		
		
		LLautonTaskChooser = new SendableChooser<Command>();
		
		LLautonTaskChooser.addDefault("Choose LL Program", new CrossTheBaseLine());
		

		LLautonTaskChooser.addObject("Left to Left tall boi", new ScaleFrom1());
		LLautonTaskChooser.addObject("Left to Left Switch", new LeftSwitchAuton());
		LLautonTaskChooser.addObject("Center too 2 left cube", new CenterLeft2Cube());
		LLautonTaskChooser.addObject("Center to Left Switch", new CenterLeft());
		LLautonTaskChooser.addObject("Right to Left Switch", new RightStartLeftScore());
		LLautonTaskChooser.addObject("Left to left 2 Cube Scale", new Cube2Left ());

		
		SmartDashboard.putData("LLAuton Task", LLautonTaskChooser);
		
		
		LRautonTaskChooser = new SendableChooser<Command>();
		
		LRautonTaskChooser.addDefault("Choose LR Program", new CrossTheBaseLine());
		
	
		LRautonTaskChooser.addObject("Left to Left Switch", new LeftSwitchAuton());
		LRautonTaskChooser.addObject("Right to 2 Cube Scale", new Cube2Right());	
		LRautonTaskChooser.addObject("Center to Left Switch", new CenterLeft());
		LRautonTaskChooser.addObject("Center too left 2 cube", new CenterLeft2Cube());
		LRautonTaskChooser.addObject("Right to Left Switch", new RightStartLeftScore());
		LRautonTaskChooser.addObject("Right To Right tall boi", new ScaleFrom3());
		
		
		SmartDashboard.putData("LRAuton Task", LRautonTaskChooser);




		
		//ledLights.setAllLightsOn(false);
      } catch (Exception e) {
    		System.err.println("An error occurred in robotInit()");
      }
    }
	
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		updateStatus();
	}

    public void autonomousInit() {    	
    	updateChoosers();
    	
    	controlLoop.start();
    	drive.endGyroCalibration();
    	drive.resetEncoders();
    	drive.resetGyro();
    	drive.setIsRed(getAlliance().equals(Alliance.Red));
        
        
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
        if (gameData.length() > 0) {
        	if (gameData.charAt(0) == 'L') {
        		if (gameData.charAt(1) == 'L') {
        			if (LLautonomousCommand != null) {
        				LLautonomousCommand.start();
        			}
        		} else {
        			if (LRautonomousCommand != null) {
        				LRautonomousCommand.start();
        			}
        		}
        	} else {
        		if (gameData.charAt(1) == 'L') {
  				  	if (RLautonomousCommand != null) {
  				  		RLautonomousCommand.start();
  				  	}
        		} else {
        			if (RRautonomousCommand != null) {
        				RRautonomousCommand.start();
        			}
  			  	}
        	}
		}
	}

    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
		updateStatus();
    }

    public void teleopInit() {
        if (RRautonomousCommand != null) RRautonomousCommand.cancel();
        if (RLautonomousCommand != null) RLautonomousCommand.cancel();
        if (LRautonomousCommand != null) LRautonomousCommand.cancel();
        if (LLautonomousCommand != null) LLautonomousCommand.cancel();
        drive.setToBrakeOnNeutral(false);	
    	updateChoosers();
        controlLoop.start();
    	drive.resetEncoders();
    	drive.endGyroCalibration();

        updateStatus();
    }


    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
		updateStatus();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
		updateStatus();
   }
    
    private void updateChoosers() {
		operationMode = (OperationMode)operationModeChooser.getSelected();
		RRautonomousCommand = (Command)RRautonTaskChooser.getSelected();
		RLautonomousCommand = (Command)RLautonTaskChooser.getSelected();
		LRautonomousCommand = (Command)LRautonTaskChooser.getSelected();
		LLautonomousCommand = (Command)LLautonTaskChooser.getSelected();
    }
    
    public Alliance getAlliance() {
    	return m_ds.getAlliance();
    }
    
    public void updateStatus() {
    	drive.updateStatus(operationMode);
    	elevator.updateStatus(operationMode);

   }

}

