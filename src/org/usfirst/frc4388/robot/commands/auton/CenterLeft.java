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
public class CenterLeft extends CommandGroup {
    
    public CenterLeft() 
    {
    	addSequential(new DriveGyroReset());
    	addSequential(new WaitCommand(.2));
    	addSequential(new IntakePosition(true));
    	addSequential(new DriveSpeedShift(true));
    	
    	addSequential(new DriveStraightBasic(-15, 30, true, true, 0));
    	addSequential(new DriveTurnBasic(true, 115, 150, MPSoftwareTurnType.TANK));
    	addSequential(new WaitCommand(.2));
    	addSequential(new ElevatorBasic(30));
    	addSequential(new DriveTurnBasic(true, 32, 150, MPSoftwareTurnType.TANK));
    	addParallel(new TimeoutBecaseYea());
    	addSequential(new DriveStraightBasic(25, 60, true, true, 0));
    	
    	addSequential(new WaitCommand(3));
    	addSequential(new DriveStraightBasic(-20, 45, true, true, 0));
      	addSequential(new ElevatorBasic(10));
    	addSequential(new DriveSpeedShift(false));
    }
}
