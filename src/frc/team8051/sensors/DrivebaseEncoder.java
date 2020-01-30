package frc.team8051.sensors;

import edu.wpi.first.wpilibj.Encoder;

public class DrivebaseEncoder {
    private final double wheelDiameter = 6.0/12.0; // unit in feet
    private final double pulsesPerRevo = 20;
    private final double gearRatio = 10.75;
    private final double distancePerPulse = (wheelDiameter * Math.PI)/pulsesPerRevo/gearRatio;

    private Encoder rightEncoder;
    private Encoder leftEncoder;

    public DrivebaseEncoder() {
        rightEncoder = new Encoder(6, 7);
        leftEncoder = new Encoder(8, 9);

        rightEncoder.setReverseDirection(true);

        rightEncoder.setDistancePerPulse(distancePerPulse);
        leftEncoder.setDistancePerPulse(distancePerPulse);
    }

    public double getLeftSensorReading() {
        return leftEncoder.getDistance();
    }

    public double getRightSensorReading() {
        return rightEncoder.getDistance();
    }

    public void zeroEncoder() {
        leftEncoder.reset();
        rightEncoder.reset();
    }

    public double getDistancePerPulse() {
        return distancePerPulse;
    }
}
