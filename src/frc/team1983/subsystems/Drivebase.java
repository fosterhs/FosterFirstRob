package frc.team1983.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivebase extends Subsystem
{
    private static final int LEFT1_PORT = 13;
    private static final boolean LEFT1_REVERSED = false;
    private static final int LEFT2_PORT = 14;
    private static final boolean LEFT2_REVERSED = false;
    private static final int LEFT3_PORT = 15;
    private static final boolean LEFT3_REVERSED = false;
    private static final int RIGHT1_PORT = 1;
    private static final boolean RIGHT1_REVERSED = false;
    private static final int RIGHT2_PORT = 0;
    private static final boolean RIGHT2_REVERSED = false;
    private static final int RIGHT3_PORT = 2;
    private static final boolean RIGHT3_REVERSED = false;

    private TalonSRX left1, left2, left3, right1, right2, right3;
    //private CANSparkMax left1, left2, left3, right1, right2, right3;

    public Drivebase()
    {
        left1 = new TalonSRX(LEFT1_PORT);
        left2 = new TalonSRX(LEFT2_PORT);
        left3 = new TalonSRX(LEFT3_PORT);

//        left1 = new CANSparkMax(LEFT1_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);
//        left2 = new CANSparkMax(LEFT2_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);
//        left3 = new CANSparkMax(LEFT3_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);

        left1.setInverted(LEFT1_REVERSED);
        left2.setInverted(LEFT2_REVERSED);
        left3.setInverted(LEFT3_REVERSED);

        left2.follow(left1);
        left3.follow(left1);

        right1 = new TalonSRX(RIGHT1_PORT);
        right2 = new TalonSRX(RIGHT2_PORT);
        right3 = new TalonSRX(RIGHT3_PORT);

//        right1 = new CANSparkMax(RIGHT1_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);
//        right2 = new CANSparkMax(RIGHT2_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);
//        right3 = new CANSparkMax(RIGHT3_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);

        right1.setInverted(RIGHT1_REVERSED);
        right2.setInverted(RIGHT2_REVERSED);
        right3.setInverted(RIGHT3_REVERSED);

        right2.follow(right1);
        right3.follow(right1);
    }

    public void setLeft(double percentOutput)
    {
        left1.set(ControlMode.PercentOutput, percentOutput);
//        left1.set(percentOutput);
    }

    public void setRight(double percentOutput)
    {
        right1.set(ControlMode.PercentOutput, percentOutput);
//        right1.set(percentOutput);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
