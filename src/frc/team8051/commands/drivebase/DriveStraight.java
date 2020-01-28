package frc.team8051.commands.drivebase;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import frc.team8051.subsystems.Drivebase;

public class DriveStraight extends Command {
    private Drivebase drivebase;
    private double desiredDistance;
    private final double wheelDiameter = 6.0/12.0; // unit in feet
    private final double pulsesPerRevo = 20;
    private final double gearRatio = 10.75;
    private final double distancePerPulse = (wheelDiameter * Math.PI)/pulsesPerRevo/gearRatio;

    Encoder left;
    Encoder right;
    // gear ratio -> 10.75

    public DriveStraight(Drivebase drivebase, double distance){
        this.drivebase = drivebase;
        this.desiredDistance = distance;
        right = new Encoder(6, 7);
        left = new Encoder(8, 9);
        right.setDistancePerPulse(distancePerPulse);
        left.setDistancePerPulse(distancePerPulse);
        right.setReverseDirection(true);
        resetEncoder();
    }
    public void resetEncoder() {
        right.reset();
        left.reset();
    }
    @Override
    public void execute() {
        System.out.println("left " + left.getDistance() + " ft");
        System.out.println("right " + right.getDistance() + " ft");
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
