// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// random comment
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new DrivetrainSubsystem. */

  private final WPI_TalonSRX motor = new WPI_TalonSRX(6);
  
  public DrivetrainSubsystem() {
    motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.DrivetrainConstants.kEncoderIdxPID, Constants.DrivetrainConstants.kEncoderTimeoutPIDMs);
    motor.setSensorPhase(true);
    motor.config_kP(Constants.DrivetrainConstants.kEncoderIdxPID, Constants.DrivetrainConstants.kEncoderPPID,Constants.DrivetrainConstants.kEncoderTimeoutPIDMs);
    motor.config_kI(Constants.DrivetrainConstants.kEncoderIdxPID,Constants.DrivetrainConstants.kEncoderIPID,Constants.DrivetrainConstants.kEncoderTimeoutPIDMs);
    motor.config_kD(Constants.DrivetrainConstants.kEncoderIdxPID, Constants.DrivetrainConstants.kEncoderDPID,Constants.DrivetrainConstants.kEncoderTimeoutPIDMs);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double currentVelocity = motor.getSelectedSensorVelocity();
    double currentRPM = currentVelocity*600/Constants.DrivetrainConstants.kEncoderCountPerRev;
    SmartDashboard.putNumber("Current RPM", currentRPM);
  }

  public void setSpeed(double speed){
    motor.set(ControlMode.PercentOutput, speed);
    
  }

  public void setRPM(double targetRPM){

    double targetVelocity_UnitsPer100ms = (targetRPM / 600) * Constants.DrivetrainConstants.kEncoderCountPerRev;

    motor.set(ControlMode.Velocity, targetVelocity_UnitsPer100ms);
        
   
  }

}
