/*
Code for controller
 */
package frc.team8051.services;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.team8051.constants.RobotMap;
import frc.team8051.commands.drivebase.RunTankDrive;
import frc.team8051.commands.drivebase.RunDifferentialDrive;
import frc.team8051.commands.drivebase.PIDDrive;

public class OI {
    //declaring button variables 1-8
    public JoystickButton buttonA, buttonB, buttonX, buttonY, buttonLB, buttonRB, buttonBACK, buttonSTART;

    //declaring joystick variable
    public Joystick joystick;
    public OI() {
        joystick = new Joystick(0);
        //setting button variables to numbers on controller
        buttonA = new JoystickButton(joystick, RobotMap.BUTTON_A);
        buttonB = new JoystickButton(joystick, RobotMap.BUTTON_B);
        buttonX = new JoystickButton(joystick, RobotMap.BUTTON_X);
        buttonY = new JoystickButton(joystick, RobotMap.BUTTON_Y);
        buttonLB = new JoystickButton(joystick, RobotMap.BUTTON_LB);
        buttonRB = new JoystickButton(joystick, RobotMap.BUTTON_RB);
        buttonBACK = new JoystickButton(joystick, RobotMap.BUTTON_BACK);
        buttonSTART = new JoystickButton(joystick, RobotMap.BUTTON_START);
    }

    public void initializeBind() {
        //when LB button is held, we can control joysticks/movement of robot
        System.out.println("binding command to button");
        buttonY.whenPressed(new PIDDrive(5.0f));
        buttonA.whenPressed(new PIDDrive(-5.0f));
    }
    public double getRightXAxis() { return joystick.getRawAxis(4); }
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
