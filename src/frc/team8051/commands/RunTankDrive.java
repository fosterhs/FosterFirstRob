package frc.team8051.commands.drivebase;

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
        // double d1 = oi.getRightJoystick();
        // double d2 = oi.getLeftJoystick();
        // System.out.println(d1 + " " + d2);
        drivebase.setSpeed(oi.getRightJoystick(), oi.getLeftJoystick());
    }
    @Override
    protected boolean isFinished() {
        return false;
    }
    // call

    // is finished


}
