// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkLimitSwitch;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

// This code was modified by: Nick Dupre

public class Robot extends TimedRobot {
  
  private CANSparkMax armMotor; // Create a variable "armMotor" for the arm motor
  private SparkLimitSwitch fwdLimitSwitch; // Create a variable "fwdLimitSwitch" for the forward limit switch
  private SparkLimitSwitch revLimitSwitch; // Create a variable "revLimitSwitch" for the rev limit switch

  private XboxController controller; // Create a variable "controller" for the Xbox controller

  @Override
  public void robotInit() {

    armMotor = new CANSparkMax(0, MotorType.kBrushless); // Store an instance of CANSparkMax in the armMotor variable
    armMotor.restoreFactoryDefaults(); // Restore motor to factory defaults to avoid runaway robots
    fwdLimitSwitch = armMotor.getForwardLimitSwitch(SparkLimitSwitch.Type.kNormallyOpen); // Get the fwd limit switch from the motor and store it
    revLimitSwitch = armMotor.getReverseLimitSwitch(SparkLimitSwitch.Type.kNormallyClosed); // Same for the reverse limit switch

    // Enable the limit switches
    fwdLimitSwitch.enableLimitSwitch(true);
    revLimitSwitch.enableLimitSwitch(false);

  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

    double joystick = controller.getLeftY(); // Create local variable "joystick" which gets the value of the controller's left joystick Y axis (-1.0 to +1.0)
    joystick *= 0.2; // Scale joystick value to 20%
    armMotor.set(joystick); // Set motor speed to the joystick value

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
