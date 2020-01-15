package frc.team8051.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team8051.services.OI;
import frc.team8051.subsystems.Drivebase;

public class RunTankDrive extends Command {
    private Drivebase drivebase;
    private OI oi;

    public RunTankDrive(Drivebase drivebase, OI oi) {
        this.oi = oi;
        this.drivebase = drivebase;
    }

    public void execute(){

    }
    @Override
    protected boolean isFinished() {
        return false;
    }
    // call

    // is finished


}
