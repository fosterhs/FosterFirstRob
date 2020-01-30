package frc.team8051.commands.drivebase;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team8051.Robot;
import frc.team8051.services.OI;
import frc.team8051.subsystems.DifferentialDriveBase;

public class TestDrive extends Command {
    private OI oi;
    private DifferentialDrive differentialDrive;
    public TestDrive(OI oi, DifferentialDrive differentialDrive) {
        this.oi = oi;
        this.differentialDrive = differentialDrive;
        System.out.println("instantiating <TestDrive>");
        System.out.println("<TestDrive> oi " + oi == null);
        System.out.println("<TestDrive> differentialDrive " + differentialDrive == null);
    }

    public TestDrive() {
        this(Robot.getInstance().getOI(), Robot.getInstance().getDifferentialDrive());
    }

    @Override
    protected void execute() {
        System.out.println("executing TestDrive");
        System.out.println("<TestDrive> oi " + oi == null);
        System.out.println("<TestDrive> differentialDrive " + differentialDrive == null);
        double leftYAxis = -oi.getLeftYAxis();
        double rightYAxis = -oi.getRightYAxis();
        double deadZone = 0.0078125;
        if(Math.abs(leftYAxis) <= deadZone) leftYAxis = 0;
        if(Math.abs(rightYAxis) <= deadZone) rightYAxis = 0;
        System.out.println("left y axis: " + leftYAxis + " right y axis: " + rightYAxis);
        // differentialDrive.tankDrive(leftYAxis, rightYAxis);
        differentialDrive.arcadeDrive(rightYAxis, leftYAxis);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }
}
