package frc.team8051.commands.drivebase;

import edu.wpi.first.wpilibj.command.Command;
import frc.team8051.services.OI;
import frc.team8051.subsystems.Drivebase;
import frc.team8051.Robot;

public class RunTankDrive extends Command {
    protected Drivebase drivebase;
    protected OI oi;

    public RunTankDrive(Drivebase drivebase, OI oi) {
        //requires(drivebase);
        this.oi = oi;
        this.drivebase = drivebase;
    }

    public RunTankDrive() {
        this(Robot.getInstance().getDrivebase(), Robot.getInstance().getOI());
    }

    public void execute() {
        drivebase.set(oi.getRightYAxis(), oi.getLeftYAxis());
        //if(drivebase == null) System.out.println("drivebase is null");
        //if(oi == null) System.out.println("oi is null");
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
    // call

    // is finished


}
