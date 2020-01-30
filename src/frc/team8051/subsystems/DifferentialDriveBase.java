package frc.team8051.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// Wrapper Class for differential drivebase
public class DifferentialDriveBase extends Subsystem {
    private final WPI_VictorSPX leftMotor = new WPI_VictorSPX(15);
    private final WPI_VictorSPX rightMotor = new WPI_VictorSPX(14);
    private DifferentialDrive differentialDrive;

    public DifferentialDriveBase() {
        System.out.println("new differentialDrivebase");
        differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
    }

    @Override
    protected void initDefaultCommand() {

    }

    public DifferentialDrive getDifferentialDrive() {
        return differentialDrive;
    }
}
