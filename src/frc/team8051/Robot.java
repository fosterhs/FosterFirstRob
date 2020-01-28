package frc.team8051;
import frc.team8051.subsystems.Drivebase;
import frc.team8051.commands.drivebase.RunDifferentialDrive;
import frc.team8051.commands.drivebase.RunTankDrive;
import frc.team8051.commands.drivebase.DriveStraight;
import frc.team8051.commands.drivebase.PIDDrive;

import frc.team8051.services.OI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {
  private static Robot robot;
  private Drivebase drivebase;
  private OI oi;
  Robot() {
      robot = this;
      drivebase = new Drivebase();
      oi = new OI();
      oi.initializeBind();
  }

  @Override
  public void robotInit() {

  }

  @Override
  public void robotPeriodic() {
    System.out.println(drivebase.getLeftEncoder().getDistance() + " left encoder reading");
    System.out.println(drivebase.getRightEncoder().getDistance() + " right encoder reading");
    System.out.println(oi.getRightYAxis() + " oi right Y axis");
    System.out.println(oi.getLeftYAxis() + " oi left Y axis");
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {
    System.out.println("Running teleopInit()");
    drivebase.zeroEncoder();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {

  }

  public static Robot getInstance() {
    if(robot == null)
      robot = new Robot();
    return robot;
  }

  public OI getOI() {
    return oi;
  }

  public Drivebase getDrivebase() {
    return drivebase;
  }


}
