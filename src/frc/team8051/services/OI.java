package frc.team8051.services;


import edu.wpi.first.wpilibj.Joystick;

public class MyOI {
    //public Joystick rightJoystick = new Joystick(0);
    //public Joystick leftJoystick = new Joystick(1);

    public Joystick joystick = new Joystick(1);

    public double getRightJoystick() {
        return joystick.getRawAxis(1);
    }

    public double getLeftJoystick(){
        return joystick.getRawAxis(5);
    }

    //public double getRightJoystick() {
        //return rightJoystick.getY();
   // }

    //public double getLeftJoystick() {
      //  return leftJoystick.getY();
    //}

}
