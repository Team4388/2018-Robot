package org.usfirst.frc4388.robot.commands.auton;

import org.usfirst.frc4388.robot.commands.DriveAbsoluteTurnMP;
import org.usfirst.frc4388.robot.commands.DriveGyroReset;
import org.usfirst.frc4388.robot.commands.DriveSpeedShift;
import org.usfirst.frc4388.robot.commands.DriveStraightBasic;
import org.usfirst.frc4388.robot.commands.DriveStraightMP;
import org.usfirst.frc4388.robot.commands.DriveTurnBasic;
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
public class RightSwitchForward extends CommandGroup {
    
    public RightSwitchForward() {
    	addSequential(new DriveGyroReset());
    	addSequential(new IntakePosition(true));
    	addSequential(new DriveStraightBasic(-25, 25, true, true, 0));
    	addSequential(new DriveTurnBasic(true, 178, 90, MPSoftwareTurnType.TANK));
    	addSequential(new DriveGyroReset());
    	addSequential(new WaitCommand(.1));
    	addSequential(new DriveStraightBasic(125, 30, true, true, 0));
    	addSequential(new DriveGyroReset());
    	addSequential(new WaitCommand(.1));
    	addSequential(new DriveTurnBasic(true, -90, 90, MPSoftwareTurnType.TANK));
    	//addSequential(new DriveStraightBasic(5, 20, true, true, 0));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_EJECT_SPEED));
    	addSequential(new WaitCommand(.6));
    	addSequential(new IntakePosition(false));
    	addSequential(new WaitCommand(.9));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));

    	//addSequential(new DriveStraightMP(60, 10, true, true, 0));  // 95 for 112" greenville
       
    }
}