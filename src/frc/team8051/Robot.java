package frc.team8051;
import frc.team8051.subsystems.Drivebase;
import frc.team8051.commands.drivebase.RunDifferentialDrive;
import frc.team8051.commands.drivebase.RunTankDrive;
import frc.team8051.services.OI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {
  private static Robot robot = null;
  private Drivebase drivebase;
  private OI oi;
  // private RunDifferentialDrive diffDrive = new RunDifferentialDrive(drivebase, oi);
  private RunTankDrive tankDrive;

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
    //Scheduler.getInstance().add(diffDrive);
    //Scheduler.getInstance().add(tankDrive);
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
    // System.out.println("Running Oi");
    return oi;
  }

  public Drivebase getDrivebase() {
    return drivebase;
  }


}
