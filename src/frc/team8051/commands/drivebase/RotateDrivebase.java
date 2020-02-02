package frc.team8051.commands.drivebase;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team8051.Robot;
import frc.team8051.sensors.Gyro;


public class RotateDrivebase extends PIDCommand {
    private DifferentialDrive drivebase;
    private double degree;
    private Gyro gyro;
    public RotateDrivebase(DifferentialDrive drivebase, Gyro gyro, double degree) {
        super(0.30, 0, 0);
        // p = .3 for speed 1 and -1

        this.drivebase = drivebase;
        this.degree = degree;
        this.gyro = gyro;
    }

    public RotateDrivebase(double degree) {
        this(Robot.getInstance().getDifferentialDrive(), Robot.getInstance().getGyro(), degree);
    }

    @Override
    protected void initialize() {
        gyro.reset();
        gyro.setPIDSourceType(PIDSourceType.kDisplacement);
//        double setpoint = degree % 360;
//        setpoint = setpoint > 180 ? setpoint - 360 : setpoint;
//        setpoint = setpoint < -180 ? setpoint + 360 : setpoint;

        getPIDController().setInputRange(-180, 180);
        getPIDController().setOutputRange(-.5, .5);
        getPIDController().setSetpoint(180);
        getPIDController().setAbsoluteTolerance(2);
        getPIDController().setContinuous(true);

    }

    @Override
    protected double returnPIDInput() {
        double gyroValue = gyro.pidGet();
        System.out.println("<RotateDrivebase> gyro value " + gyroValue);
        System.out.println("<RotateDrivebase> current angle " + gyro.getAngle());
        System.out.println("<RotateDrivebase> set point value " + getPIDController().getSetpoint());

        return gyroValue;
    }

    @Override
    protected void usePIDOutput(double output) {
        System.out.println("<RotateDrivebase> pid output " + output);
         drivebase.tankDrive(output, -output);
    }

    @Override
    protected boolean isFinished() {
        return getPIDController().onTarget();
    }

}
