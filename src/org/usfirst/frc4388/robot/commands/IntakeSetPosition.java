package org.usfirst.frc4388.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeSetPosition extends CommandGroup {

	public static enum IntakePosition { CUBE_INTAKE, CUBE_DEPLOY };

    public IntakeSetPosition(IntakePosition intakePosition) {
    	addParallel(new CarriageIntakeSetDeploy(0.5, 0.0, IntakePosition.CUBE_DEPLOY ));
       	addSequential(new IntakeSetPosition(intakePosition));
     }
}