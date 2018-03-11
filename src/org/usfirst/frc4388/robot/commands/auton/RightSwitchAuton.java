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
public class RightSwitchAuton extends CommandGroup {
    
    public RightSwitchAuton() {
    	addSequential(new DriveGyroReset());
    	addSequential(new DriveSpeedShift(true));
    	addSequential(new IntakePosition(true));
    	
    	
    	addSequential(new DriveStraightBasic(-140, 50, true, true, 0));
    	addSequential(new ElevatorBasic(30));
    	addSequential(new WaitCommand(.2));
    	addSequential(new DriveTurnBasic(true, 87, 150, MPSoftwareTurnType.TANK));
    	addSequential(new ElevatorBasic(30));
    	addSequential(new DriveStraightBasic(8, 50, true, true, 0));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_EJECT_SPEED));
    	//addSequential(new WaitCommand(.1));
    	addSequential(new IntakePosition(false));
    	addSequential(new WaitCommand(.5));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
    	addSequential(new DriveStraightBasic(-20, 50, true, true, 0));
    	addSequential(new DriveSpeedShift(false));

    	//addSequential(new DriveStraightMP(50, 10, true, true, 0));  // 95 for 112" greenville
       
    }
}
