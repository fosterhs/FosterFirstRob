package frc.team8051;
import frc.team8051.subsystems.Drivebase;
import frc.team8051.commands.RunTankDrive;
import frc.team8051.commands.RunDifferentialDrive;
import frc.team8051.services.OI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import com.ctre.phoenix.motorcontrol.ControlMode;
import  com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Robot extends TimedRobot {
  private Drivebase drivebase = new Drivebase();
  private OI oi = new OI();
  private RunDifferentialDrive diffDrive = new RunDifferentialDrive(drivebase, oi);
  // private RunTankDrive td = new RunTankDrive(drivebase, oi);
  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {

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
    Scheduler.getInstance().add(diffDrive);
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
