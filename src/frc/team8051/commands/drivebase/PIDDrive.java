package frc.team8051.commands.drivebase;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team8051.Robot;
import frc.team8051.sensors.DrivebaseEncoder;

public class PIDDrive extends PIDCommand {
    private DifferentialDrive drivebase;
    private double distance;
    private DrivebaseEncoder drivebaseEncoder;

    public PIDDrive(DifferentialDrive drivebase, DrivebaseEncoder drivebaseEncoder, double distance) {
        super(0.30, 0.6, 0.0);
        this.drivebase = drivebase;
        this.distance = distance;

        this.drivebaseEncoder = drivebaseEncoder;
        this.drivebaseEncoder.zeroEncoder();
        setSetpoint(this.distance);
        getPIDController().setAbsoluteTolerance(0.1);
        getPIDController().setOutputRange(-1, 1);

    }

    public PIDDrive(double distance) {
        this(Robot.getInstance().getDifferentialDrive(),
             Robot.getInstance().getDrivebaseEncoder(),
             distance);
    }

    @Override
    protected double returnPIDInput() {
        double val = (drivebaseEncoder.getLeftSensorReading() + drivebaseEncoder.getRightSensorReading())/2;
        System.out.println("encoder reads" + val + " set point " + getPIDController().getSetpoint());
        return val;
    }

    @Override
    protected void usePIDOutput(double output) {
        System.out.println("pid output " + output + " set point " + getPIDController().getSetpoint());
        drivebase.arcadeDrive(output, 0);
    }

    @Override
    protected boolean isFinished() {
        System.out.println("isFinished");
        if(getPIDController().onTarget()) {
            drivebaseEncoder.zeroEncoder();
                System.out.println("encoder left " + drivebaseEncoder.getLeftSensorReading() +
                    " encoder right " + drivebaseEncoder.getRightSensorReading());
            return true;
        }

        return false;
    }
}
