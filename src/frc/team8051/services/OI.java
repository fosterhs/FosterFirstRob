package frc.team8051.services;


import edu.wpi.first.wpilibj.Joystick;

public class OI {
    public Joystick joystick;
    public OI() {
        joystick = new Joystick(1);
    }

    public double gitRightXAxis() {
        return joystick.getRawAxis(4);
    }
    public double getRightYAxis() {
        return joystick.getRawAxis(5);
    }
    public double getLeftXAxis() {
        return joystick.getRawAxis(0);
    }
    public double getLeftYAxis() {
        return joystick.getRawAxis(1);
    }
}
