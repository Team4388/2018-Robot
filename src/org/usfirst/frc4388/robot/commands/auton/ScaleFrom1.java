package org.usfirst.frc4388.robot.commands.auton;


import org.usfirst.frc4388.robot.commands.DriveGyroReset;
import org.usfirst.frc4388.robot.commands.DriveSpeedShift;
import org.usfirst.frc4388.robot.commands.DriveStraightBasic;

import org.usfirst.frc4388.robot.commands.DriveTurnBasic;
import org.usfirst.frc4388.robot.commands.ElevatorBasic;

import org.usfirst.frc4388.robot.commands.IntakePosition;
import org.usfirst.frc4388.robot.commands.IntakeSetSpeed;
import org.usfirst.frc4388.robot.subsystems.Carriage;

import org.usfirst.frc4388.utility.MPSoftwarePIDController.MPSoftwareTurnType;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ScaleFrom1 extends CommandGroup {
    
    public ScaleFrom1() {
    	addSequential(new DriveGyroReset());
    	addSequential(new WaitCommand(.2));
    	addSequential(new DriveSpeedShift(true));
    	addSequential(new IntakePosition(true));
    	
    	
    	//addSequential(new DriveStraightBasic(-10, 50, true, true, 0));
    	
    	addSequential(new DriveStraightBasic(-280, 65, true, true, 0));
    	addSequential(new ElevatorBasic(75));
    	addSequential(new DriveStraightBasic(-30, 20, true, true, 0)); 
    	addSequential(new DriveTurnBasic(true, -80, 100, MPSoftwareTurnType.TANK));
    	//addSequential(new DriveStraightBasic(5, 20, true, true, 0));
    	addSequential(new WaitCommand(.5));
    	addSequential(new DriveStraightBasic(15, 25, true, true, 0));
    	
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_EJECT_SPEED));
    	//addSequential(new WaitCommand(.1));
    	addSequential(new IntakePosition(false));
    	addSequential(new WaitCommand(.5));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
    	
    	
    	addSequential(new DriveStraightBasic(-20, 20, true, true, 0));
    	addSequential(new ElevatorBasic(10));
    	addSequential(new DriveTurnBasic(true, 85, 100, MPSoftwareTurnType.TANK));
    	addSequential(new DriveStraightBasic(70, 20, true, true, 0));
    	
    	addSequential(new DriveSpeedShift(false));

    	//addSequential(new DriveStraightMP(60, 10, true, true, 0));  // 95 for 112" greenville
       
    }
}
