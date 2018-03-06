


package org.usfirst.frc4388.robot;

//
//import org.usfirst.frc4388.buttons.XBoxDPadTriggerButton;
import buttons.XBoxTriggerButton;
import org.usfirst.frc4388.controller.IHandController;
import org.usfirst.frc4388.controller.XboxController;
import org.usfirst.frc4388.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc4388.robot.subsystems.*;
import org.usfirst.frc4388.utility.MPSoftwarePIDController.MPSoftwareTurnType;
import org.usfirst.frc4388.robot.subsystems.Drive;
import org.usfirst.frc4388.utility.MPSoftwarePIDController.MPSoftwareTurnType;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;



public class OI 
{
		private static OI instance;
		
		private XboxController m_driverXbox;
		private XboxController m_operatorXbox;

		private OI() 
		{
		  try 
		  {
			// Driver controller
			m_driverXbox = new XboxController(RobotMap.DRIVER_JOYSTICK_1_USB_ID);
			m_operatorXbox = new XboxController(RobotMap.OPERATOR_JOYSTICK_1_USB_ID);
			
			//ELevator PID buttons
			
			//JoystickButton elevatorMaxScaleHeight = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.Y_BUTTON);
			//elevatorMaxScaleHeight.whenPressed(new PositionPIDMaxScaleHeight(50));
			
			//JoystickButton elevatorLowScaleHeight = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.X_BUTTON);
			//elevatorLowScaleHeight.whenPressed(new PositionPIDLowScaleHeight(50));
			
			//JoystickButton elevatorSwitchHeight = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.B_BUTTON);
			//elevatorSwitchHeight.whenPressed(new PositionPIDLowScaleHeight(50));
			
			
			/*
			JoystickButton elevatorLowestHeight = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.A_BUTTON);
			elevatorLowestHeight.whenPressed(new PositionPIDLowScaleHeight(50));
			*/
		
			
			
	        //JoystickButton shiftDrivetrain = new JoystickButton(m_driverXbox.getJoyStick(), XboxController.LEFT_BUMPER_BUTTON);
	        //shiftDrivetrain.whenPressed(new DriveSpeedShift(Drive.SpeedShiftState.HI));
	        //shiftDrivetrain.whenReleased(new DriveSpeedShift(Drive.SpeedShiftState.LO));
	        
	        //JoystickButton longShot = new JoystickButton(m_driverXbox.getJoyStick(), XboxController.RIGHT_BUMPER_BUTTON);
	        //longShot.whenPressed(new ShootOn(ShotState.FAR, ShooterFeed.SHOOTER_FEED_SHOOT_FAR_SPEED, false));
	        //longShot.whenReleased(new ShootOff());
	        
	        //XBoxTriggerButton shortShot = new XBoxTriggerButton(m_driverXbox, XBoxTriggerButton.RIGHT_TRIGGER);
	        //shortShot.whenPressed(new ShootOn(ShotState.CLOSE, ShooterFeed.SHOOTER_FEED_SHOOT_CLOSE_SPEED, false));
	        //shortShot.whenReleased(new ShootOff());
	        
			
			
	        XBoxTriggerButton CarriageIntake = new XBoxTriggerButton(m_operatorXbox, XBoxTriggerButton.LEFT_TRIGGER);
	        CarriageIntake.whenPressed(new IntakeSetSpeed(Carriage.CUBE_EJECT_SPEED));
	        CarriageIntake.whenReleased(new IntakeSetSpeed(0.0));
	        
	        XBoxTriggerButton CarriageEject = new XBoxTriggerButton(m_operatorXbox, XBoxTriggerButton.RIGHT_TRIGGER);
	        CarriageEject.whenPressed(new IntakeSetSpeed(Carriage.CUBE_INTAKE_SPEED));
	        CarriageEject.whenReleased(new IntakeSetSpeed(0.0));
	        
			
			
	        //JoystickButton gearIntakeDown = new JoystickButton(m_driverXbox.getJoyStick(), XboxController.X_BUTTON);
	        //gearIntakeDown.whenPressed(new IntakeSetPosition(IntakePosition.GEAR_INTAKE));
	        //gearIntakeDown.whenReleased(new IntakeSetPosition(IntakePosition.GEAR_PRESENT));
	       
	        //JoystickButton gearIntakeRetract = new JoystickButton(m_driverXbox.getJoyStick(), XboxController.Y_BUTTON);
	        //gearIntakeRetract.whenPressed(new IntakeSetPosition(IntakePosition.RETRACT));

	        //JoystickButton gearIntakePresent = new JoystickButton(m_driverXbox.getJoyStick(), XboxController.B_BUTTON);
	        //gearIntakePresent.whenPressed(new IntakeSetPosition(IntakePosition.GEAR_PRESENT));
	        
	        //JoystickButton gearIntakeDeploy = new JoystickButton(m_driverXbox.getJoyStick(), XboxController.A_BUTTON);
	        //gearIntakeDeploy.whenPressed(new IntakeSetPosition(IntakePosition.GEAR_DEPLOY));
	        
	        JoystickButton climbUp = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.X_BUTTON);
	        climbUp.whenPressed(new InitiateClimber(true));
	        climbUp.whenReleased(new InitiateClimber(false));
	        
	        JoystickButton shiftUp = new JoystickButton(m_driverXbox.getJoyStick(), XboxController.RIGHT_BUMPER_BUTTON);
	        shiftUp.whenPressed(new DriveSpeedShift(true));
	        shiftUp.whenPressed(new LEDIndicators(true));
	        
	        JoystickButton shiftDown = new JoystickButton(m_driverXbox.getJoyStick(), XboxController.LEFT_BUMPER_BUTTON);
	        shiftDown.whenPressed(new DriveSpeedShift(false));
	        shiftDown.whenPressed(new LEDIndicators(false));
	        
	        
	        //XBoxDPadTriggerButton climberReverse = new XBoxDPadTriggerButton(m_driverXbox, XBoxDPadTriggerButton.DOWN);
	        //climberReverse.whenPressed(new ClimberSetSpeed(0.48, 0.0));
	        //climberReverse.whenReleased(new ClimberSetSpeed(0.0, 0.0));
	        
	        //JoystickButton toggleShooter = new JoystickButton(m_driverXbox.getJoyStick(), XboxController.START_BUTTON);
	        //toggleShooter.whenPressed(new ShooterSetToggle(Shooter.SHOOTER_STAGE1_RPM_CLOSE, Shooter.SHOOTER_STAGE2_RPM_CLOSE)); 

	        JoystickButton openIntake = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.LEFT_BUMPER_BUTTON);
	        openIntake.whenPressed(new IntakePosition(true));
	        
	        JoystickButton CloseIntake = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.RIGHT_BUMPER_BUTTON);
	        CloseIntake.whenPressed(new IntakePosition(false));
	     	        
	        //XBoxTriggerButton shortShotOperator = new XBoxTriggerButton(m_operatorXbox, XBoxTriggerButton.RIGHT_TRIGGER);
	        //shortShotOperator.whenPressed(new ShootOn(ShotState.CLOSE, ShooterFeed.SHOOTER_FEED_SHOOT_CLOSE_SPEED, true));
	        //shortShotOperator.whenReleased(new ShootOff());
	                
	        //XBoxTriggerButton intakeGearOperator = new XBoxTriggerButton(m_operatorXbox, XBoxTriggerButton.LEFT_TRIGGER);
	        //intakeGearOperator.whenPressed(new GearIntakeRollerSetSpeed(GearIntake.GEAR_INTAKE_LOAD_SPEED));
	        //intakeGearOperator.whenReleased(new GearIntakeRollerSetSpeed(0.0));
	                
	        //JoystickButton gearIntakeEjectOperator = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.LEFT_BUMPER_BUTTON);
	        //gearIntakeEjectOperator.whenPressed(new GearIntakeRollerSetSpeed(GearIntake.GEAR_INTAKE_EJECT_SPEED));
	        //gearIntakeEjectOperator.whenReleased(new GearIntakeRollerSetSpeed(0.0));
	        
	        //JoystickButton gearIntakeDownOperator = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.X_BUTTON);
	        //gearIntakeDownOperator.whenPressed(new IntakeSetPosition(IntakePosition.GEAR_INTAKE));
	        //gearIntakeDownOperator.whenReleased(new IntakeSetPosition(IntakePosition.GEAR_PRESENT));
	        
	        //JoystickButton gearIntakeRetractOperator = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.Y_BUTTON);
	        //gearIntakeRetractOperator.whenPressed(new IntakeSetPosition(IntakePosition.RETRACT));

	        //JoystickButton gearIntakePresentOperator = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.B_BUTTON);
	        //gearIntakePresentOperator.whenPressed(new IntakeSetPosition(IntakePosition.GEAR_PRESENT));
	                
	        //JoystickButton gearIntakeDeployOperator = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.A_BUTTON);
	        //gearIntakeDeployOperator.whenPressed(new IntakeSetPosition(IntakePosition.GEAR_DEPLOY));
	        
	        //XBoxDPadTriggerButton climberForwardOperator = new XBoxDPadTriggerButton(m_operatorXbox, XBoxDPadTriggerButton.UP);
	        //climberForwardOperator.whenPressed(new ClimberSetSpeed(ShooterFeed.CLIMB_SPEED, 0.0));
	        //climberForwardOperator.whenReleased(new ClimberSetSpeed(0.0, 0.0));
	        
	        //XBoxDPadTriggerButton climberReverseOperator = new XBoxDPadTriggerButton(m_operatorXbox, XBoxDPadTriggerButton.DOWN);
	        //climberReverseOperator.whenPressed(new ClimberSetSpeed(0.48, 0.0));
	        //climberReverseOperator.whenReleased(new ClimberSetSpeed(0.0, 0.0));
	        
	        //XBoxDPadTriggerButton hopperOpen = new XBoxDPadTriggerButton(m_operatorXbox, XBoxDPadTriggerButton.LEFT);
	        //hopperOpen.whenPressed(new ShooterSetHopperPosition(HopperState.OPEN));
	        
	        //XBoxDPadTriggerButton hopperClose = new XBoxDPadTriggerButton(m_operatorXbox, XBoxDPadTriggerButton.RIGHT);
	        //hopperClose.whenPressed(new ShooterSetHopperPosition(HopperState.CLOSE));
	        
	        //JoystickButton toggleShooterOperator = new JoystickButton(m_operatorXbox.getJoyStick(), XboxController.START_BUTTON);
	        //toggleShooterOperator.whenPressed(new ShooterSetToggle(Shooter.SHOOTER_STAGE1_RPM_CLOSE, Shooter.SHOOTER_STAGE2_RPM_CLOSE)); 
			
	        // Gear sensor switch 
//			GearSensorAnalogSwitch gearSwitch = new GearSensorAnalogSwitch();
//			gearSwitch.whenPressed(new IntakeSetPosition(IntakePosition.GEAR_PRESENT));
	        
	        // SmartDashboard
//			Button driveMP = new InternalButton();
//			driveMP.whenPressed(new DriveStraightMP(40, 20, true, false, 0));
//			SmartDashboard.putData("Drive Straight", driveMP);
	        
	        
			//SmartDashboard.putData("Drive Straight 30in", new DriveStraightMP(30, 20, true, true, 0));
			//SmartDashboard.putData("Drive Straight 60in", new DriveStraightMP(60, 20, true, true, 0));
	
	        //SmartDashboard.putData("Basic Straight 60in", new DriveStraightBasic(60, 30, true, true, 0));
			//SmartDashboard.putData("Basic Straight -60in", new DriveStraightBasic(-60, 30, true, true, 0));
			//SmartDashboard.putData("Turn abs 90 TANK", new DriveTurnBasic(true, 90, 90, MPSoftwareTurnType.TANK));
		//	SmartDashboard.putData("Turn rel -90 RIGHT ONLY", new DriveTurnBasic(false, -90, 90, MPSoftwareTurnType.RIGHT_SIDE_ONLY));
			//SmartDashboard.putData("RUN INTAKE", new IntakeSetSpeed(Carriage.CUBE_EJECT_SPEED));
		//	SmartDashboard.putData("Stop INTAKE", new IntakeSetSpeed(Carriage.CUBE_STOP_SPEED));
			//SmartDashboard.putData("move intake", new IntakePosition(true));
			//SmartDashboard.putData("move intake2", new IntakePosition(false));
			//SmartDashboard.putData("Move Stop", new ElevatorSetSpeed(ElevatorAuton.RAISE_ELEVATOR_SPEED));
	        
	        
			SmartDashboard.putData("move elevator", new ElevatorBasic(20));
	        
			///SmartDashboard.putData("Move Down", new ElevatorSetSpeed(ElevatorAuton.LOWER_ELEVATOR_SPEED));
			///SmartDashboard.putData("Move UP", new ElevatorSetSpeed(ElevatorAuton.STOP_ELEVATOR_SPEED));
			
			//SmartDashboard.putData("MP Move", new DriveStraightMP(-60, 30, true, true, 0)); // forward , back to right
			//SmartDashboard.putData("MP Move", new DriveStraightMP(-50, 30, true, true, 0)); // forward, back to the right
			//SmartDashboard.putData("MP Move", new DriveStraightMP(-40, 30, true, true, 0)); //same af -50
			//SmartDashboard.putData("MP Move", new DriveStraightMP(-30, 30, true, true, 0));// same as above shorter
			//SmartDashboard.putData("MP Move", new DriveStraightMP(-60, 20, true, true, 0));// could not break ininita
			//SmartDashboard.putData("MP Move", new DriveStraightMP(100, 20, true, true, 0));
			//SmartDashboard.putData("MP Move", new DriveStraightMP(-60, 30, true, true, 0));
			//SmartDashboard.putData("MP Move", new DriveStraightMP(-60, 30, true, true, 0));
			//SmartDashboard.putData("MP Move", new DriveStraightMP(-60, 30, true, true, 0));
			//SmartDashboard.putData("MP Move", new DriveStraightMP(-60, 30, true, true, 0));
			//SmartDashboard.putData("MP Move", new DriveStraightMP(-60, 30, true, true, 0));
			//SmartDashboard.putData("MP Move", new DriveStraightMP(-60, 30, true, true, 0));
			//SmartDashboard.putData("MP Move", new DriveStraightMP(-60, 30, true, true, 0));
			//SmartDashboard.putData("MP Move", new DriveStraightMP(-60, 30, true, true, 0));
			
			
			
			
			
			
			
			
			
	        //List<Waypoint> waypoints = new ArrayList<>();
	        //waypoints.add(new Waypoint(new Translation2d(0, 0), 35.0));
	        //waypoints.add(new Waypoint(new Translation2d(-35, 0), 35.0));
	        //Path.addCircleArc(waypoints, -30.0, 45.0, 10, "hopperSensorOn");
	        //waypoints.add(new Waypoint(new Translation2d(-85, -30), 35.0));

//	        List<Waypoint> waypoints = new ArrayList<>();
//	        waypoints.add(new Waypoint(new Translation2d(-96, 0), 50.0));
//	        waypoints.add(new Waypoint(new Translation2d(0, 0), 35.0));
//	        waypoints.add(new Waypoint(new Translation2d(-96, 0), 50.0));
//	        waypoints.add(new Waypoint(new Translation2d(-61, 0), 50.0));
//	        waypoints.add(new Waypoint(new Translation2d(-84.93, -10.16), 50.0));
	        
//	        waypoints.add(new Waypoint(new Translation2d(-41, 0), 35.0));
//	        waypoints.add(new Waypoint(new Translation2d(-65, -23), 35.0));
//	        waypoints.add(new Waypoint(new Translation2d(-70, -39), 35.0));
	        
//	        waypoints.add(new Waypoint(new Translation2d(-29, 0), 40.0));
//	        Path.addCircleArc(waypoints, -30.0, 45.0, 10, null);
//	        waypoints.add(new Waypoint(new Translation2d(-68.6, -26.5), 40.0));
			
			//Button driveAP = new InternalButton();
			//driveAP.whenPressed(new DrivePathAdaptivePursuit(new Path(waypoints), true));
			//SmartDashboard.putData("Drive Adaptive Pursuit", driveAP);

			//Button driveMM = new InternalButton();
			//driveMM.whenPressed(new DriveStraightMM(10, 450, 450, true, false, 0));
			//SmartDashboard.putData("Drive StraightMM", driveMM);
			
			//Button turnRelativePID = new InternalButton();
			//turnRelativePID.whenPressed(new DriveRelativeTurnPID(-10, MPSoftwareTurnType.RIGHT_SIDE_ONLY));
			//SmartDashboard.putData("Turn Relative 10 PID", turnRelativePID);
			
			//Button turnRelativePID7 = new InternalButton();
			//turnRelativePID7.whenPressed(new DriveRelativeTurnPID(7, MPSoftwareTurnType.LEFT_SIDE_ONLY));
			//SmartDashboard.putData("Turn Relative 7 PID", turnRelativePID7);
			
			//Button turnRelativeMP = new InternalButton();
			//turnRelativeMP.whenPressed(new DriveRelativeTurnMP(10, Drive.MP_AUTON_MAX_TURN_RATE_DEG_PER_SEC, MPSoftwareTurnType.LEFT_SIDE_ONLY ));
			//SmartDashboard.putData("Turn Relative 10", turnRelativeMP);
			
			Button turnAbsoluteMP = new InternalButton();
			turnAbsoluteMP.whenPressed(new DriveAbsoluteTurnMP(45, Drive.MP_AUTON_MAX_TURN_RATE_DEG_PER_SEC, MPSoftwareTurnType.LEFT_SIDE_ONLY));
			SmartDashboard.putData("Turn Absolute 45", turnAbsoluteMP);

			Button turnRelativePID = new InternalButton();
			turnRelativePID.whenPressed(new DriveRelativeTurnPID(45, MPSoftwareTurnType.TANK));
			SmartDashboard.putData("Turn Relative 45", turnRelativePID);

//			Button gyroReset = new InternalButton();
//			gyroReset.whenPressed(new DriveGyroReset());
//			SmartDashboard.putData("Gyro Reset", gyroReset);
			SmartDashboard.putData("Reset Gyro", new DriveGyroReset());
			//SmartDashboard.putData("reset Encoders", new drive.resetEncoders());


			// Camera
			//Button cameraUpdateDashboard = new InternalButton();
			//cameraUpdateDashboard.whenPressed(new CameraUpdateDashboard());
			//SmartDashboard.putData("Camera Update", cameraUpdateDashboard);
			
			//Button cameraSaveImage = new InternalButton();
			//cameraSaveImage.whenPressed(new CameraSaveImage());
			//SmartDashboard.putData("Camera Save", cameraSaveImage);
			
			//Button cameraTurnToBestTarget = new InternalButton();
			//cameraTurnToBestTarget.whenPressed(new CameraTurnToBestTarget());
			//SmartDashboard.putData("Camera Turn To Best", cameraTurnToBestTarget);
			
			//Button cameraUpdateBestTarget = new InternalButton();
			//cameraUpdateBestTarget.whenPressed(new CameraUpdateBestTarget());
			//SmartDashboard.putData("Camera Update Best", cameraUpdateBestTarget);
			
			//Button incrementCameraOffsetPos = new InternalButton();
			//incrementCameraOffsetPos.whenPressed(new CameraIncrementOffset(0.5));
			//SmartDashboard.putData("Camera Offset Pos", incrementCameraOffsetPos);
			
			//Button incrementCameraOffsetNeg = new InternalButton();
			//incrementCameraOffsetNeg.whenPressed(new CameraIncrementOffset(-0.5));
			//SmartDashboard.putData("Camera Offset Neg", incrementCameraOffsetNeg);
			
//			Button cameraReadImage = new InternalButton();
//			cameraReadImage.whenPressed(new CameraReadAndProcessImage());
//			SmartDashboard.putData("Camera Read", cameraReadImage);
//			
//			Button cameraReadImageTurnToBestTarget = new InternalButton();
//			cameraReadImageTurnToBestTarget.whenPressed(new CameraReadImageTurnToBestTarget());
//			SmartDashboard.putData("Camera Read Turn", cameraReadImageTurnToBestTarget);
//			
//			Button magicCarpetOn05 = new InternalButton();
//			magicCarpetOn05.whenPressed(new ZarkerFeedSetSpeed(0.5));
//			SmartDashboard.putData("Magic Carpet 0.5", magicCarpetOn05);
	//
//			Button magicCarpetOff = new InternalButton();
//			magicCarpetOff.whenPressed(new ZarkerFeedSetSpeed(0.0));
//			SmartDashboard.putData("Magic Carpet Off", magicCarpetOff);
	//
//			Button shooterFeedOn10 = new InternalButton();
//			shooterFeedOn10.whenPressed(new ShooterFeedSetSpeed(1.0));
//			SmartDashboard.putData("Shooter Feed 1.0", shooterFeedOn10);
	//
//			Button shooterFeedOn05 = new InternalButton();
//			shooterFeedOn05.whenPressed(new ShooterFeedSetSpeed(0.5));
//			SmartDashboard.putData("Shooter Feed 0.5", shooterFeedOn05);
	//
//			Button shooterFeedOff = new InternalButton();
//			shooterFeedOff.whenPressed(new ShooterFeedSetSpeed(0.0));
//			SmartDashboard.putData("Shooter Feed Off", shooterFeedOff);
	//
//			Button shooterStage2RPMOnDash = new InternalButton();
//			shooterStage2RPMOnDash.whenPressed(new ShooterStage2SetRpmDashboard());
//			SmartDashboard.putData("Shooter Stage 2 Dash RPM", shooterStage2RPMOnDash);
	//
//			Button shooterStage2On10 = new InternalButton();
//			shooterStage2On10.whenPressed(new ShooterStage2SetSpeed(1.0));
//			SmartDashboard.putData("Shooter Stage 2 - 1.0", shooterStage2On10);
	//
//			Button shooterStage2On09 = new InternalButton();
//			shooterStage2On09.whenPressed(new ShooterStage2SetSpeed(0.9));
//			SmartDashboard.putData("Shooter Stage 2 - 0.9", shooterStage2On09);
	//
//			Button shooterStage2On08 = new InternalButton();
//			shooterStage2On08.whenPressed(new ShooterStage2SetSpeed(0.8));
//			SmartDashboard.putData("Shooter Stage 2 - 0.8", shooterStage2On08);
	//
//			Button shooterStage2On07 = new InternalButton();
//			shooterStage2On07.whenPressed(new ShooterStage2SetSpeed(0.7));
//			SmartDashboard.putData("Shooter Stage 2 - 0.7", shooterStage2On07);
	//
//			Button shooterStage2On06 = new InternalButton();
//			shooterStage2On06.whenPressed(new ShooterStage2SetSpeed(0.6));
//			SmartDashboard.putData("Shooter Stage 2 - 0.6", shooterStage2On06);
	//
//			Button shooterStage2On05 = new InternalButton();
//			shooterStage2On05.whenPressed(new ShooterStage2SetSpeed(0.5));
//			SmartDashboard.putData("Shooter Stage 2 - 0.5", shooterStage2On05);
	//
//			Button shooterStage2Off = new InternalButton();
//			shooterStage2Off.whenPressed(new ShooterStage2SetSpeed(0.0));
//			SmartDashboard.putData("Shooter Stage 2 - Off", shooterStage2Off);
//			
//			Button shooterStage1RPMOnDash = new InternalButton();
//			shooterStage1RPMOnDash.whenPressed(new ShooterStage1SetRpmDashboard());
//			SmartDashboard.putData("Shooter Stage 1 Dash RPM", shooterStage1RPMOnDash);
	//
//			Button shooterStage1On05 = new InternalButton();
//			shooterStage1On05.whenPressed(new ShooterStage1SetSpeed(0.5));
//			SmartDashboard.putData("Shooter Stage 1 - 0.5", shooterStage1On05);
//			
//			Button shooterStage1Off = new InternalButton();
//			shooterStage1Off.whenPressed(new ShooterStage1SetSpeed(0.0));
//			SmartDashboard.putData("Shooter Stage 1 - Off", shooterStage1Off);
//			
//			Button shooterBothRPMOnDash = new InternalButton();
//			shooterBothRPMOnDash.whenPressed(new ShooterSetRpmDashboard());
//			SmartDashboard.putData("Shooter Both Dash RPM", shooterBothRPMOnDash);
	//
//			Button shooterBothVBusOnDash = new InternalButton();
//			shooterBothVBusOnDash.whenPressed(new ShooterSetSpeedDashboard());
//			SmartDashboard.putData("Shooter Both Dash VBus", shooterBothVBusOnDash);
	//
//			Button allButLiftOff = new InternalButton();
//			allButLiftOff.whenPressed(new ShooterAllOff());
//			SmartDashboard.putData("Shooter All Off", allButLiftOff);
//			
//			Button allButLiftOn = new InternalButton();
//			allButLiftOn.whenPressed(new ShooterAllOn());
//			SmartDashboard.putData("Shooter All On", allButLiftOn);
	//
//			Button hopperShake = new InternalButton();
//			hopperShake.whenPressed(new ShooterSetHopperShake(2, 10, 1));
//			SmartDashboard.putData("Hopper Shake Button", hopperShake);
	//
//			Button intakeOn10 = new InternalButton();
//			intakeOn10.whenPressed(new GearIntakeRollerSetSpeed(1.0));
//			SmartDashboard.putData("Intake 1.0", intakeOn10);
	//
//			Button intakeOn08 = new InternalButton();
//			intakeOn08.whenPressed(new GearIntakeRollerSetSpeed(0.8));
//			SmartDashboard.putData("Intake 0.8", intakeOn08);
	//
//			Button intakeOn05 = new InternalButton();
//			intakeOn05.whenPressed(new GearIntakeRollerSetSpeed(0.5));
//			SmartDashboard.putData("Intake 0.5", intakeOn05);
	//
//			Button intakeOn04 = new InternalButton();
//			intakeOn04.whenPressed(new GearIntakeRollerSetSpeed(0.4));
//			SmartDashboard.putData("Intake 0.4", intakeOn04);
	//
//			Button intakeOff = new InternalButton();
//			intakeOff.whenPressed(new GearIntakeRollerSetSpeed(0.0));
//			SmartDashboard.putData("Intake Off", intakeOff);
	//
//			Button shooterShotPositionClose = new InternalButton();
//			shooterShotPositionClose.whenPressed(new ShooterSetShotPosition(Shooter.ShotState.CLOSE));
//			SmartDashboard.putData("Shooter Close Shot", shooterShotPositionClose);
//			
//			Button shooterShotPositionFar = new InternalButton();
//			shooterShotPositionFar.whenPressed(new ShooterSetShotPosition(Shooter.ShotState.FAR));
//			SmartDashboard.putData("Shooter Far Shot", shooterShotPositionFar);
//			
//			Button climberOn08 = new InternalButton();
//			climberOn08.whenPressed(new ClimberSetSpeed(0.8, 0.0));
//			climberOn08.whenReleased(new ClimberSetSpeed(0.0, 0.0));
//			SmartDashboard.putData("Climber 0.8", climberOn08);
	//
//			Button climberSetMaxAmps = new InternalButton();
//			climberSetMaxAmps.whenPressed(new ClimberSetMaxAmps(0.8, 20));
//			SmartDashboard.putData("Climber Max Amps", climberSetMaxAmps);
//			
	        //jaci.pathfinder.Waypoint[] points = new jaci.pathfinder.Waypoint[] {
	        //        new jaci.pathfinder.Waypoint(0, 0, 0),
	        //        new jaci.pathfinder.Waypoint(-90, -16, Pathfinder.d2r(-45))
	        //};

	        //PathGenerator path = new PathGenerator(points, 0.01, 160, 200.0, 700.0);		
			
			//Button pathTest = new InternalButton();
			//pathTest.whenPressed(new DrivePathMP(path));
			//SmartDashboard.putData("Path Test", pathTest);

//			Button ledsOn = new InternalButton();
//			ledsOn.whenPressed(new LEDLightsSet(true));
//			SmartDashboard.putData("LEDs On", ledsOn);
//			
//			Button ledsOff = new InternalButton();
//			ledsOff.whenPressed(new LEDLightsSet(false));
//			SmartDashboard.putData("LEDs Off", ledsOff);
//			
//	        Button intakeGearRoller = new InternalButton();
//	        intakeGearRoller.whenPressed(new GearIntakeRollerSetSpeed(0.3));
//			SmartDashboard.putData("Gear Intake Clean Speed", intakeGearRoller);
	//
//	        Button intakeGearStopRoller = new InternalButton();
//	        intakeGearStopRoller.whenPressed(new GearIntakeRollerSetSpeed(0.0));
//			SmartDashboard.putData("Gear Intake Clean Off Speed", intakeGearStopRoller);
		  } catch (Exception e) {
			  System.err.println("An error occurred in the OI constructor");
		  }
		}
		
		public static OI getInstance() {
			if(instance == null) {
				instance = new OI();
			}
			return instance;
		}

		public IHandController getDriverController() {
			return m_driverXbox;
		}

		public IHandController getOperatorController() 
		{
			return m_operatorXbox;
		}

		public Joystick getOperatorJoystick()
		{
			return m_operatorXbox.getJoyStick();
		}
	}

