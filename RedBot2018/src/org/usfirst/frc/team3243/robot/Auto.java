package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.VictorSP;

public class Auto {
	
	public MotoController controller;
	long firstTimer;
	long startTimeDelay = 1000;
	boolean startAutoMode;
	boolean firstStep;
	boolean secondStep;
	
	/*
	VictorSP motor1 = new VictorSP(1);
	VictorSP motor2 = new VictorSP(2);
	VictorSP motor3 = new VictorSP(3);
	VictorSP motor4 = new VictorSP(4);
	PWMVictorSPX feeder2 = new PWMVictorSPX(8);
	PWMVictorSPX spinnerRight = new PWMVictorSPX(7);
	PWMVictorSPX spinnerLeft = new PWMVictorSPX(6);
	
	double setSpeed = 0.95;
	*/
	
	public Auto(MotoController controller) {
		this.controller = controller;
	}
	
	private long timeElapsedSinceStart() {
		return System.currentTimeMillis() - firstTimer;
	}
	
	public void autoDrive() {
		if(!startAutoMode) {
			startAutoMode = true;
			firstTimer = System.currentTimeMillis();
		} 
		
		if(timeElapsedSinceStart() > startTimeDelay && !firstStep) {
			firstStep = true;
			
			//Second step
			controller.drive(new Double[] {0.85, 0.85, 0.0, 0.0});
		}
		
		if(timeElapsedSinceStart() > startTimeDelay + 4000 && !secondStep) {
			secondStep = true;
			
			controller.drive(new Double[] {0.0, 0.0, 0.9, 0.9});
		}
		
	}
	
}
