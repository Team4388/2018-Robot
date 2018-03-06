package org.usfirst.frc4388.robot.subsystems;

import org.usfirst.frc4388.robot.Robot;
import org.usfirst.frc4388.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LED extends Subsystem {
    
		
	private DoubleSolenoid Light;

	
	public LED() {
		try {
			Light = new DoubleSolenoid(1,2,3);					
		} 
		catch (Exception e) {
			System.err.println("An error occurred in the LED constructor");
		}
	}
	
	public void setLight(boolean state) {
		if (state==true) {
			Light.set(DoubleSolenoid.Value.kForward);
		}
		if (state==false) {
			Light.set(DoubleSolenoid.Value.kReverse);
		}
	}


	public void initDefaultCommand() {
    }
}
