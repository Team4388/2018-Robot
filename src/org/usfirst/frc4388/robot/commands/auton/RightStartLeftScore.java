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
public class RightStartLeftScore extends CommandGroup {
    
    public RightStartLeftScore()  //////////TUNEDISH AND ALMOST GOOD
    {
    	addSequential(new DriveGyroReset());
    	addSequential(new WaitCommand(.1));
    	addSequential(new DriveSpeedShift(true));
    	addSequential(new IntakePosition(true));
    	
    	
    	addSequential(new DriveStraightBasic(-215, 40, true, true, 0));
    	addSequential(new WaitCommand(.2));
    	addSequential(new ElevatorBasic(5));
    	addSequential(new DriveTurnBasic(true, 73, 150, MPSoftwareTurnType.TANK));
    	addSequential(new WaitCommand(.2));
    	addSequential(new DriveStraightBasic(155, 60, true, true, 0));
    	addSequential(new ElevatorBasic(30));
    	addSequential(new WaitCommand(.2));
    	addSequential(new DriveTurnBasic(true, -73, 150, MPSoftwareTurnType.TANK));
    	addParallel(new TimeoutBecaseYea());
    	addSequential(new DriveStraightBasic(10, 60, true, true, 0));
    	addSequential(new WaitCommand(3));
    	
    	
    	/*
    	
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_EJECT_SPEED));
    	//addSequential(new WaitCommand(.1));
    	addSequential(new IntakePosition(false));
    	addSequential(new DriveStraightBasic(5, 60, true, true, 0));
    	addSequential(new WaitCommand(.2));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
    	*/
    	
    	
    	addSequential(new DriveStraightBasic(-15, 60, true, true, 0));
    	addSequential(new DriveSpeedShift(false));
    	
    }
}
