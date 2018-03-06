package org.usfirst.frc4388.robot.commands.auton;

import org.usfirst.frc4388.robot.commands.DriveAbsoluteTurnMP;
import org.usfirst.frc4388.robot.commands.DriveGyroReset;
import org.usfirst.frc4388.robot.commands.DriveSpeedShift;
import org.usfirst.frc4388.robot.commands.DriveStraightBasic;
import org.usfirst.frc4388.robot.commands.DriveStraightMP;
import org.usfirst.frc4388.robot.commands.DriveTurnBasic;
import org.usfirst.frc4388.robot.commands.ElevatorBasic;
import org.usfirst.frc4388.robot.commands.IntakePosition;
import org.usfirst.frc4388.robot.commands.IntakeSetSpeed;
import org.usfirst.frc4388.robot.subsystems.Carriage;
import org.usfirst.frc4388.robot.subsystems.Drive;
import org.usfirst.frc4388.utility.MPSoftwarePIDController.MPSoftwareTurnType;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class RightStartLeftScore extends CommandGroup {
    
    public RightStartLeftScore() {
    	
    	addSequential(new DriveGyroReset());
    	addSequential(new DriveSpeedShift(true));
    	addSequential(new DriveSpeedShift(true));
    	addSequential(new IntakePosition(true));
    	addSequential(new DriveStraightBasic(-215, 60, true, true, 0));
    	addSequential(new ElevatorBasic(5));
    	addSequential(new DriveTurnBasic(true, 87, 300, MPSoftwareTurnType.TANK));
    	addSequential(new DriveStraightBasic(150, 60, true, true, 0));
    	addSequential(new ElevatorBasic(30));
    	addSequential(new DriveTurnBasic(true, -87, 300, MPSoftwareTurnType.TANK));
    	addSequential(new DriveStraightBasic(3, 60, true, true, 0));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_EJECT_SPEED));
    	//addSequential(new WaitCommand(.1));
    	addSequential(new IntakePosition(false));
    	addSequential(new WaitCommand(.2));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
    	addSequential(new DriveStraightBasic(-10, 60, true, true, 0));
    	//addSequential(new DriveStraightMP(60, 10, true, true, 0));  // 95 for 112" greenville
       
    }
}
