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
public class Cube2Left extends CommandGroup {
    
    public Cube2Left() {
    	addSequential(new DriveGyroReset());
    	addSequential(new WaitCommand(.2));
    	addSequential(new DriveSpeedShift(true));
    	addSequential(new IntakePosition(true));
    	
    	addSequential(new DriveStraightBasic(-300, 70, true, true, 0));
    	addSequential(new DriveStraightBasic(1, 30, true, true, 0));
    	addSequential(new ElevatorBasic(70)); 
    	addSequential(new DriveTurnBasic(true, -90, 100, MPSoftwareTurnType.TANK));
    	addSequential(new WaitCommand(.5));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_EJECT_SPEED));
    	addSequential(new WaitCommand(.1));
    	addSequential(new IntakePosition(false));
    	addSequential(new WaitCommand(.5));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
    	
    	addSequential(new DriveStraightBasic(-10, 30, true, true, 0));
    	addParallel(new ElevatorBasic(4));
    	
    	//////////////////////////////////////////////////////////////////////////
    	addSequential(new DriveTurnBasic(true, 69, 100, MPSoftwareTurnType.TANK));
    	//////////////////////////////////////////////////////////////////////////
    	
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_INTAKE_FAST_SPEED));
    	
    	/////////////////////////////////////////////////////////////
    	addSequential(new DriveStraightBasic(10, 30, true, true, 0));
    	addSequential(new DriveStraightBasic(80, 60, true, true, 0));
    	addSequential(new DriveStraightBasic(33, 20, true, true, 0));
    	/////////////////////////////////////////////////////////////
    	addSequential(new WaitCommand(.5));
    	addSequential(new IntakePosition(true));
    	//addSequential(new WaitCommand(.3));
    	addSequential(new WaitCommand(.2));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
    	addParallel(new TimeoutBecaseYea());
    	addSequential(new ElevatorBasic(28));
    	/////////////////////////////////////////////////////////////
    	addSequential(new DriveStraightBasic(6, 50, true, true, 0));
    	/////////////////////////////////////////////////////////////
    	addSequential(new WaitCommand(1.5));
    	addSequential(new DriveStraightBasic(-20, 40, true, true, 0));
    	addSequential(new ElevatorBasic(5));
    	
    	
    	addSequential(new DriveSpeedShift(false));

    	      
    }
}