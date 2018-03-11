package org.usfirst.frc4388.robot.commands.auton;


import org.usfirst.frc4388.robot.commands.DriveGyroReset;
import org.usfirst.frc4388.robot.commands.DriveSpeedShift;
import org.usfirst.frc4388.robot.commands.DriveStraightBasic;
import org.usfirst.frc4388.robot.commands.DriveStraightBasicAbs;
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
public class CenterLeftAbs extends CommandGroup {
    
    public CenterLeftAbs() 
    {
    	addSequential(new DriveGyroReset());
    	addSequential(new IntakePosition(true));
    	addSequential(new DriveSpeedShift(true));
    	
    	addSequential(new DriveStraightBasicAbs(-15, 50, true, true, 0));
    	addSequential(new DriveTurnBasic(true, 130, 300, MPSoftwareTurnType.TANK));
    	addSequential(new DriveStraightBasicAbs(53, 50, true, true, 130));
    	addSequential(new ElevatorBasic(20));
    	addSequential(new DriveTurnBasic(true, 164.5, 300, MPSoftwareTurnType.TANK));
    	addSequential(new DriveStraightBasicAbs(19, 50, true, true, 164.5));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_EJECT_SPEED));
    	//addSequential(new WaitCommand(.1));
    	addSequential(new IntakePosition(false));
    	addSequential(new WaitCommand(.2));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
    	addSequential(new DriveStraightBasicAbs(-20, 50, true, true, 164.5));
      	addSequential(new ElevatorBasic(10));
    	addSequential(new DriveSpeedShift(false));
    }
}
