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

public class CenterRight2Cube extends CommandGroup {
    
    public CenterRight2Cube() 
    {
    	addSequential(new DriveGyroReset());
    	addSequential(new WaitCommand(.2));
    	addSequential(new IntakePosition(true));
    	addSequential(new DriveSpeedShift(true));
    	
    	addSequential(new DriveStraightBasic(-15, 60, true, true, 0));
    	addSequential(new DriveTurnBasic(true, -122, 150, MPSoftwareTurnType.TANK));
    	addSequential(new WaitCommand(.2));
    	addSequential(new DriveStraightBasic(55, 60, true, true, 0));
    	addSequential(new ElevatorBasic(25));
    	addSequential(new DriveTurnBasic(true, -39, 150, MPSoftwareTurnType.TANK));
    	addParallel(new TimeoutBecaseYea());
    	addSequential(new DriveStraightBasic(30, 40, true, true, 0));
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveStraightBasic(-20, 45, true, true, 0));
      	addSequential(new ElevatorBasic(3));
      	addSequential(new DriveTurnBasic(true, -75, 150, MPSoftwareTurnType.TANK));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_INTAKE_SPEED));
    	addSequential(new DriveStraightBasic(43, 45, true, true, 0));
    	addSequential(new WaitCommand(2));
    	addSequential(new IntakePosition(true));
    	addSequential(new DriveStraightBasic(-30, 45, true, true, 0));
    	addSequential(new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
    	addSequential(new ElevatorBasic(25));
      	addSequential(new DriveTurnBasic(true, 75, 150, MPSoftwareTurnType.TANK));
      	addParallel(new TimeoutBecaseYea());
    	addSequential(new DriveStraightBasic(20, 45, true, true, 0));
    	
    	addSequential(new WaitCommand(1));

    	addSequential(new DriveStraightBasic(-20, 45, true, true, 0));
    	
    	addSequential(new DriveSpeedShift(false));
    	
    }
}
