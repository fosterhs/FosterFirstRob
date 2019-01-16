package frc.team1983;

import edu.wpi.first.wpilibj.Joystick;

import java.util.HashMap;

public class OI {
    private Joystick left, right, panel;
    private HashMap<JoyList, Joystick> JoyMap;

    public static int Y_AXIS = 0;
    public static int X_AXIS = 1;

    public OI()
    {
        left = new Joystick(JoyList.LEFT.PORT);
        right = new Joystick(JoyList.RIGHT.PORT);
        panel = new Joystick(JoyList.PANEL.PORT);
    }

    public double getX(JoyList joystick)
    {
        return JoyMap.get(joystick).getX();
    }

    public double getY(JoyList joystick)
    {
        return JoyMap.get(joystick).getY();
    }

    public enum JoyList
    {
        LEFT(0),
        RIGHT(1),
        PANEL(2)
        ;

        public int PORT;
        JoyList(int port)
        {
            this.PORT = port;
        }
    }
}
