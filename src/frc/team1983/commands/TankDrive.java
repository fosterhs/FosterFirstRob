package frc.team1983.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1983.OI;
import frc.team1983.subsystems.Drivebase;

import static java.lang.Math.abs;

public class TankDrive extends Command {
    private Drivebase drivebase;
    private OI oi;

    public TankDrive(Drivebase drivebase, OI oi) {
        this.drivebase = drivebase;
        this.oi = oi;

        requires(drivebase);
    }

    @Override
    public void initialize()
    {
    }

    @Override
    public void execute()
    {
        drivebase.setLeft(oi.getY(OI.JoyList.LEFT) * abs(oi.getY(OI.JoyList.LEFT)));
        drivebase.setRight(oi.getY(OI.JoyList.RIGHT) * abs(oi.getY(OI.JoyList.RIGHT)));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
