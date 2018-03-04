package org.usfirst.frc.team2073.robot.subsystems;

import org.usfirst.frc.team2073.robot.OI;
import org.usfirst.frc.team2073.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorSubsystem extends Subsystem {

	private TalonSRX motor; 
	private Joystick joystick; 
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(OI.driveWithJoystick);
        motor = RobotMap.roboMapMotor;
        joystick = OI.getJoystick();
    }
    
    public void driveWithJoystick() {
    	setSpeedWithJoystick(joystick.getRawAxis(1));
    }
    
    
    public void printValues() {
    	System.out.println("Speed: " + OI.joystick.getY());
    }
    
    
    public void fullPower() {
    	if(joystick.getY() > 0) {
    		motor.set(ControlMode.PercentOutput, 1);
    	}else {
    		//It's negative.
    		motor.set(ControlMode.PercentOutput, -1);
    	}
    }
    
    
    public void halfPower() {
    	if(joystick.getY() > 0) {
        	motor.set(ControlMode.PercentOutput, .5);
        }else {
        		//It's negative.
        		motor.set(ControlMode.PercentOutput, -.5);
        	}
    }
    
    
    public void stop() {
    	motor.set(ControlMode.PercentOutput, 0);
    	System.out.println("You have been stopped!");
    }
    
    public void setSpeedWithJoystick(double speed) {
    	motor.set(ControlMode.PercentOutput, speed);
    }
    
}

