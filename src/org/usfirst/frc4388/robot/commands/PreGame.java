package org.usfirst.frc4388.robot.commands;


import org.usfirst.frc4388.robot.commands.DriveGyroReset;
import org.usfirst.frc4388.robot.commands.DriveSpeedShift;
import org.usfirst.frc4388.robot.commands.DriveStraightBasic;

import org.usfirst.frc4388.robot.commands.IntakePosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PreGame extends CommandGroup {
    
    public PreGame() {
    	
    	addSequential(new DriveSpeedShift(true));
    	addSequential(new IntakePosition(true));
    	addSequential(new DriveStraightBasic(-10, 50, true, true, 0));


       
    }
}
