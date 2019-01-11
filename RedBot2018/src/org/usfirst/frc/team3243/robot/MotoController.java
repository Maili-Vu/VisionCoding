package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.PWMVictorSPX;

public class MotoController {

	VictorSP motor1 = new VictorSP(1);
	VictorSP motor2 = new VictorSP(2);
	VictorSP motor3 = new VictorSP(3);
	VictorSP motor4 = new VictorSP(4);
	PWMVictorSPX feeder2 = new PWMVictorSPX(8);
	PWMVictorSPX spinnerRight = new PWMVictorSPX(7);
	PWMVictorSPX spinnerLeft = new PWMVictorSPX(6);
	PWMVictorSPX BB = new PWMVictorSPX(9);
	
	Float[] alter = new Float[2];


	//drive method4
	void drive(Double[] val) {
		
		motor1.set(-.70*val[1]);
		motor2.set(-.70*val[1]);
		motor3.set(.70*val[5]);
		motor4.set(.70*val[5]);
		
		spinnerRight.set(0.85*val[3]);
		spinnerLeft.set(-0.85*val[3]);
		feeder2.set(0.5*val[2]);
		
	}
	
	void BBSpitter(boolean out, boolean in) {
		
		double setSpitter = 0.5;
		double setSpitterTwo = 1.0;
		//ben changed this code for a horn
		if(out == true && in == false) {
			BB.set(setSpitter);
		}else if(out == false && in == false) {
			BB.set(0);
		}
		
		if(in == true && out == false) {
			BB.set(setSpitterTwo);
		}else if(in == false && out == false) {
			BB.set(0);
		}
		
	}
	
	void spinnersTrashPool(Double[] val, boolean go, boolean in) {
		
		double setSpeedTrash = 0.57;
		double setSpeedPool = 0.75;
		
		if(go == true && in == false) {
			spinnerRight.set(setSpeedTrash);
			spinnerLeft.set(-setSpeedTrash);
		} else if(go == false && in == false) {
			spinnerRight.set(0.85*val[3]);
			spinnerLeft.set(-0.85*val[3]);
		}
		
		if(in == true && go == false) {
			spinnerRight.set(setSpeedPool);
			spinnerLeft.set(-setSpeedPool);
		} else if(in == false && go == false) {
			spinnerRight.set(0.85*val[3]);
			spinnerLeft.set(-0.85*val[3]);
		}
	}
	
	
	//flyWheel method
	void demWheels (boolean ditch, double speedy) {
		if(ditch == true) {
			//left.set(-speedy);
			//right.set(speedy);
		} else if(ditch == false) {
			//left.set(0);
			//right.set(0);
		}
	}
	
	//feeder method
	/*void feederSpatter (boolean what, double inner) {
		if(what == true) {
			feeder2.set(inner);
		} else if(what == false) {
			feeder2.set(0);
		}
	}*/
	
	public void setVision(boolean value, NetworkTable tx) {
		float Kp = -0.1f;
		float min_command = 0.05f;
		double x = tx.getDouble(0.0);	//This is the line that is having errors...

		NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

		if (value == true)
		{
		        float heading_error = (float) -x;
		        float steering_adjust = 0.0f;
		        if (x > 1.0)
		        {
		                steering_adjust = Kp*heading_error - min_command;
		        }
		        else if (x < 1.0)
		        {
		                steering_adjust = Kp*heading_error + min_command;
		        }
		        motor1.set(alter[0] += steering_adjust);
		        motor3.set(alter[1] -= steering_adjust);
		}
	}
	
}
