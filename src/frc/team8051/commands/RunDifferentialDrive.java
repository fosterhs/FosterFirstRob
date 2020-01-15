package frc.team8051.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team8051.services.OI;
import frc.team8051.subsystems.Drivebase;

public class RunDifferentialDrive extends Command {
    private Drivebase drivebase;
    private OI oi;

    public RunDifferentialDrive(Drivebase drivebase, OI oi) {
        this.drivebase = drivebase;
        this.oi = oi;
    }
    public double range(double x) {
        return x < -1.0 ? -1.0 : (x > 1.0 ? 1.0 : x);
    }

    public void execute() {
        double x = oi.getLeftXAxis();
        double y = oi.getLeftYAxis();
        double rightPower = y + x;
        double leftPower = y - x;
        drivebase.set(range(rightPower), range(leftPower));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
