// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class SpinRPMCommand extends Command {
  private DrivetrainSubsystem dSub;
  private double speedRPM;
  /** Creates a new RotateSpeedCommand. */
  public SpinRPMCommand(double speedRPM, DrivetrainSubsystem dSub) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.speedRPM = speedRPM;
    this.dSub = dSub;
    addRequirements(dSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    dSub.setRPM(speedRPM);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

