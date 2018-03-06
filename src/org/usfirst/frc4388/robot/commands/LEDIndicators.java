package org.usfirst.frc4388.robot.commands;

import org.usfirst.frc4388.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LEDIndicators extends Command
{
	boolean Light;
	
	public LEDIndicators(boolean Light) {
		this.Light=Light;
		requires(Robot.led);
	}

	@Override
	protected void initialize() {
		Robot.led.setLight(Light);
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