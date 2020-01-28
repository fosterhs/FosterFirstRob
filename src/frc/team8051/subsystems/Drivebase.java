package frc.team8051.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivebase extends Subsystem {
    private final double wheelDiameter = 6.0/12.0; // unit in feet
    private final double pulsesPerRevo = 20;
    private final double gearRatio = 10.75;
    private final double distancePerPulse = (wheelDiameter * Math.PI)/pulsesPerRevo/gearRatio;

    private Encoder rightEncoder;
    private Encoder leftEncoder;

    private VictorSPX rightMotor;
    private VictorSPX leftMotor;



    public Drivebase() {
        rightMotor = new VictorSPX(14);
        leftMotor = new VictorSPX(15);

        rightEncoder = new Encoder(6, 7);
        leftEncoder = new Encoder(8, 9);

        rightEncoder.setReverseDirection(true);
        rightEncoder.setDistancePerPulse(distancePerPulse);
        leftEncoder.setDistancePerPulse(distancePerPulse);

        zeroEncoder();
    }


    public void set(double right, double left) {
        setRight(right);
        setLeft(left);
    }

    public void setRight(double x) {
        rightMotor.set(ControlMode.PercentOutput, x);
    }

    public void setLeft(double x) {
        leftMotor.set(ControlMode.PercentOutput, -x);
    }

    public void zeroEncoder() {
        rightEncoder.reset();
        leftEncoder.reset();
    }

    public Encoder getRightEncoder() {
        return rightEncoder;
    }

    public Encoder getLeftEncoder() {
        return leftEncoder;
    }

    @Override
    protected void initDefaultCommand() {

    }
}
