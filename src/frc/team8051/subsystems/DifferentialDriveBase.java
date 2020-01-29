package frc.team8051.subsystems;
import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
private VictorSPX rightMotor;
private VictorSPX leftMotor;
public class DifferentialDriveBase extends DifferntialDrive {

    public static final double kDefaultQuickStopAlpha;

    public static final double kDefaultQuickStopAlpha;


    public DifferentialDriveBase(SuperController rightmotor, SuperController leftmotor){
        rightMotor = new VictorSPX(14);
        leftMotor = new VictorSPX(15);
    }

    public void arcadeDrive(double xSpeed, double zRotation){
            xSpeed = 1.0;
            zRotation = 1.0;
    }

}
