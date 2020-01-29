package frc.team8051.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// Wrapper Class for differential drivebase
public class DifferentialDriveBase {
    private final WPI_VictorSPX leftMotor = new WPI_VictorSPX(15);
    private final WPI_VictorSPX rightMotor = new WPI_VictorSPX(14);
    private DifferentialDrive differentialDrive;
    private static DifferentialDriveBase instance;

    private DifferentialDriveBase() {
        differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
    }

    public static DifferentialDriveBase getInstance() {
        if(instance == null) {
            instance = new DifferentialDriveBase();
        }

        return instance;
    }

    public DifferentialDrive getDifferentialDrive() {
        return instance.differentialDrive;
    }
}
