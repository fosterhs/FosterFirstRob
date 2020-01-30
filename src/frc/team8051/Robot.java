package frc.team8051;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team8051.commands.drivebase.TestDrive;
import frc.team8051.sensors.DrivebaseEncoder;
import frc.team8051.subsystems.DifferentialDriveBase;
import frc.team8051.subsystems.Drivebase;
import frc.team8051.services.OI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;;

public class Robot extends TimedRobot {
  private static Robot robot;
  private Drivebase drivebase;
  private OI oi;
  private TestDrive testDrive;
  private DifferentialDriveBase differentialDriveBase;
  private DrivebaseEncoder drivebaseEncoder;

  Robot() {
    robot = this;
    oi = new OI();
    drivebaseEncoder = new DrivebaseEncoder();
    differentialDriveBase = new DifferentialDriveBase();
  }

  @Override
  public void robotInit() {
    oi.initializeBind();
    testDrive = new TestDrive();

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
    Scheduler.getInstance().add(testDrive);
  }

  @Override
  public void teleopPeriodic() {
//    System.out.println("encoder left " + drivebaseEncoder.getLeftSensorReading() +
//                    " encoder right " + drivebaseEncoder.getRightSensorReading());
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

  public DifferentialDrive getDifferentialDrive() {
    return differentialDriveBase.getDifferentialDrive();
  }

  public DrivebaseEncoder getDrivebaseEncoder() {
    return drivebaseEncoder;
  }
}
