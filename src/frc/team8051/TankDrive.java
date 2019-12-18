package frc.team8051;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {
    private Drivebase drivebase;
    private MyOI oi;

    public TankDrive(Drivebase drivebase, MyOI oi) {
        this.oi = oi;
        this.drivebase = drivebase;
    }

    public void execute(){
        drivebase.setSpeed(oi.getRightJoystick(), oi.getLeftJoystick());
    }
    @Override
    protected boolean isFinished() {
        return false;
    }
    // call

    // is finished


}
