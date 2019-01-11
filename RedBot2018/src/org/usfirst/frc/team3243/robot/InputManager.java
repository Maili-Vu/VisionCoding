package org.usfirst.frc.team3243.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;

public class InputManager {
	//Joystick variable
	Joystick inOne = new Joystick(0);
	Joystick inTwo = new Joystick(0);
	Joystick inThree = new Joystick(0);
	//drive variable
	Double[] stickData = new Double[6];
	boolean calibrator, calibrator2, BANA, visionButton = false;	//Set adjustment speed for spinners into the trashcan
	
	//flyWheels variables
	boolean greenLeft = false;
	boolean greenRight = false;
	double increaseSpeed = 0.5;
	double newSpeed = 0;
	//feeder variables
	boolean inner = false;
	boolean downer = false;
	double goUp = 0.3;
	boolean push = false;
	
	//driving variable
	public Double[] getMoveInput() {
		stickData[0] = inOne.getRawAxis(0); 
		stickData[1] = inOne.getRawAxis(1)*0.6;	//Left Drive
		stickData[2] = inOne.getRawAxis(2);	//Feeder
		stickData[3] = inOne.getRawAxis(3);	//Spinners
		stickData[4] = inOne.getRawAxis(4);
		stickData[5] = inOne.getRawAxis(5)*0.71;	//Right Drive 1.18
		
		return stickData;
	}

	public boolean getSpinnerTrash() {
		
		calibrator = inTwo.getRawButton(1);
		
		return calibrator;
	}
	
	public boolean getSpinnerPool() {
		
		calibrator2 = inThree.getRawButton(2);
		
		return calibrator2;
	}
	
	public boolean getINBanana() {
		
		BANA = inOne.getRawButton(5);
		
		return BANA;
	}
	
	public boolean getOUTBanana() {
		
		BANA = inOne.getRawButton(6);
		
		return BANA;
	}
	//
	public boolean getVision() {
		
		visionButton = inOne.getRawButton(9);
		
		return visionButton;
	}
	
}
	
/*	
	//flyWheel method
	public double flyWheels() {
		greenLeft = inOne.getRawButton(2);
		greenRight = inOne.getRawButton(3);
		if(greenLeft == true) {
			if(increaseSpeed <= 1) {
			increaseSpeed = increaseSpeed + 0.05;
			}
		} else if (greenRight == true) {
			if(increaseSpeed >= 0) {
			increaseSpeed  = increaseSpeed - 0.05;
			}
		}
		return increaseSpeed ;
	}
	public boolean wheelActive() {
		push = inOne.getRawButton(8);
		return push;
	}
	
	
	//feeder method
	public double feederCalibrate() {
		inner = inOne.getRawButton(5);
		downer = inOne.getRawButton(7);
		if(inner == true) {
			goUp = goUp + 0.05;
		} else if (downer == true) {
			goUp = goUp - 0.05;
		}
		return goUp;
	}
	public boolean feederActive() {
		push = inOne.getRawButton(1);
		return push;
	}
	
}
*/