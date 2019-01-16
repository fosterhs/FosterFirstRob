package frc.team1983;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1983.commands.TankDrive;
import frc.team1983.subsystems.Drivebase;

public class Robot extends TimedRobot {
    private OI oi;
    private Drivebase drivebase;
    private CameraServer cameraServer;
    private UsbCamera camera0;
    private UsbCamera camera1;

  @Override
  public void robotInit() {
      oi = new OI();
      drivebase = new Drivebase();
      cameraServer = CameraServer.getInstance();
      camera0 = cameraServer.startAutomaticCapture();
      camera1 = cameraServer.startAutomaticCapture();

      SmartDashboard.putBoolean("Camera 0", true);
      SmartDashboard.putBoolean("Camera 1", true);
  }

  @Override
  public void robotPeriodic() {
      Scheduler.getInstance().run();

      if(camera0.isEnabled() && !SmartDashboard.getBoolean("Camera 0", true))
          cameraServer.removeCamera(camera0.getName());
      else if(!camera0.isEnabled() && SmartDashboard.getBoolean("Camera 0", true))
          cameraServer.startAutomaticCapture(camera0.getName(), camera0.getPath());

      if(camera1.isEnabled() && !SmartDashboard.getBoolean("Camera 1", true))
          cameraServer.removeCamera(camera1.getName());
      else if(!camera1.isEnabled() && SmartDashboard.getBoolean("Camera 1", true))
          cameraServer.startAutomaticCapture(camera1.getName(), camera1.getPath());

  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
      Scheduler.getInstance().add(new TankDrive(drivebase, oi));
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testPeriodic() {
  }
}
