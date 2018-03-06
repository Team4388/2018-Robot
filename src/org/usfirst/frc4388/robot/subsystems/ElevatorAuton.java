
package org.usfirst.frc4388.robot.subsystems;

import org.usfirst.frc4388.robot.RobotMap;
import org.usfirst.frc4388.robot.commands.*;
import org.usfirst.frc4388.robot.subsystems.Drive.DriveControlMode;
import org.usfirst.frc4388.utility.CANTalonEncoder;
import org.usfirst.frc4388.utility.ControlLoopable;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4388.robot.OI;
import org.usfirst.frc4388.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.SensorCollection;



/**
 *
 */
public class ElevatorAuton extends Subsystem {

	private WPI_TalonSRX ElevatorRight;
	private WPI_TalonSRX ElevatorLeft;
	public static final double RAISE_ELEVATOR_SPEED = 1;
	public static final double LOWER_ELEVATOR_SPEED = -1;
	public static final double STOP_ELEVATOR_SPEED = 0;
	LimitSwitchSource limitSwitchSource;
	public boolean pressed;
	SensorCollection isPressed;
	/////^^^^^^^^^ replace this line with the modes we need
	
	
	private boolean isFinished;
	//private CarriageControlMode controlMode = CarriageControlMode.JOYSTICK;
	private double PeriodMs;
	
	
	
	
	public ElevatorAuton() {
		try {
			ElevatorLeft = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR1_ID);
			ElevatorRight = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR2_ID);
			ElevatorRight.setInverted(false);
			ElevatorLeft.setInverted(false);
			
			
		
			
			//carriageLeft.set(CurrentLimit, value);
			
			ElevatorRight.set(ControlMode.Follower, ElevatorLeft.getDeviceID());
		}
		catch (Exception e) {
			System.err.println("An error occurred in the elevator constructor");
			
			
		}
    }
	
	public void setRaiseSpeed(double raiseSpeed) {
			ElevatorLeft.set(-raiseSpeed);
    }
		
      //  public synchronized void setControlMode(CarriageControlMode controlMode) {
     	//	this.controlMode = controlMode;
    	//	if (controlMode == CarriageControlMode.JOYSTICK) {
    			
    		//	carriageLeft.set(ControlMode.PercentOutput, 0);	//TODO URGENT: make sure not called when robot moving
    		//	carriageRight.set(ControlMode.PercentOutput, 0);	
    	//	}
 //   }

    	

		@Override
		/*public void controlLoopUpdate() {
			pressed = false;
    		isPressed = ElevatorLeft.getSensorCollection();
			
			elevator_input = Robot.oi.getOperatorJoystick().getRawAxis(RobotMap.OPERATOR_JOYSTICK_1_USB_ID);
			System.err.println(isPressed.isFwdLimitSwitchClosed());
			if (isPressed.isFwdLimitSwitchClosed() == true) {
				ElevatorLeft.set(0);
				ElevatorRight.set(0);
				pressed = true;
			} else {

				ElevatorLeft.set(elevator_input);
				ElevatorRight.set(elevator_input);
				pressed = false;
			}
		}
		*/

	    public void periodic() {
	   
	    }


		@Override
	//	public void setPeriodMs(long periodMs) {
		//	this.PeriodMs = periodMs;
	//	}
    	public void initDefaultCommand() {
    	}
    	public void isFinished() {
    	}
    	
    	

		
}

