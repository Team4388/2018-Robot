package org.usfirst.frc4388.robot.commands.auton;


import org.usfirst.frc4388.robot.commands.DriveGyroReset;
import org.usfirst.frc4388.robot.commands.DriveSpeedShift;
import org.usfirst.frc4388.robot.commands.DriveStraightBasic;

import org.usfirst.frc4388.robot.commands.IntakePosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossTheBaseLine extends CommandGroup {
    
    public CrossTheBaseLine() {
    	
    	addSequential(new DriveGyroReset());
    	addSequential(new DriveSpeedShift(true));
    	addSequential(new IntakePosition(true));
    	addSequential(new DriveStraightBasic(-90, 60, true, true, 0));
    	addSequential(new DriveSpeedShift(false));

       
    }
}
