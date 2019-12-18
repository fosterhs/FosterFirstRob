package frc.team8051;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivebase extends Subsystem {
    VictorSPX rmotor = new VictorSPX(14);
    VictorSPX lmotor = new VictorSPX(15);

    public void setSpeed(double right, double left){

         rmotor.set(ControlMode.PercentOutput, right);
         lmotor.set(ControlMode.PercentOutput, left);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
