package frc.team8051.commands.drivebase;
import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.team8051.Robot;
import frc.team8051.subsystems.Drivebase;
// import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.PIDController;

public class PIDDrive extends PIDCommand {
    private Drivebase drivebase;
    private double distance;
    public PIDDrive(Drivebase drivebase, double distance) {
        super(0.30, 0.6, 0.0);
        this.drivebase = drivebase;
        this.distance = distance;

        setSetpoint(this.distance);
        getPIDController().setAbsoluteTolerance(0.1);
        getPIDController().setOutputRange(-0.5, 0.5);

    }

    public PIDDrive(double distance) {
        this(Robot.getInstance().getDrivebase(), distance);
    }

    @Override
    protected double returnPIDInput() {
        double val = (drivebase.getRightEncoder().getDistance() + drivebase.getLeftEncoder().getDistance())/2;
        System.out.println("encoder reads" + val + " set point " + getPIDController().getSetpoint());
        return val;
    }

    @Override
    protected void usePIDOutput(double output) {
        System.out.println("pid output " + output + " set point " + getPIDController().getSetpoint());
        drivebase.set(-output, -output);
    }

    @Override
    protected boolean isFinished() {
        System.out.println("isFinished");
        if(getPIDController().onTarget()) {
            drivebase.zeroEncoder();
            return true;
        }

        return false;
    }
}
