package frc.team8051.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivebase extends Subsystem {
    VictorSPX rightMotor = new VictorSPX(14);
    VictorSPX leftMotor = new VictorSPX(15);

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

    @Override
    protected void initDefaultCommand() {

    }
}
