package org.usfirst.frc4388.robot.commands;

import org.usfirst.frc4388.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakePosition extends Command
{
	public boolean position;
	
	public IntakePosition(boolean position) {
		this.position=position;
		requires(Robot.pnumatics);
	}

	@Override
	protected void initialize() {
		Robot.pnumatics.setIntake(position);
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
			
	}
}