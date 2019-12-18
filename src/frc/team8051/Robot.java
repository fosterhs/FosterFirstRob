package frc.team8051;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import com.ctre.phoenix.motorcontrol.ControlMode;
import  com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Robot extends TimedRobot {
  private MyOI oi = new MyOI();
  private Drivebase drivebase = new Drivebase();
  private TankDrive td = new TankDrive(drivebase, oi);
  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {
    Scheduler.getInstance().run();
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
    Scheduler.getInstance().add(td);
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testPeriodic() {
  }
}
