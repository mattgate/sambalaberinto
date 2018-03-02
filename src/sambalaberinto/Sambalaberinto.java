package sambalaberinto;

import simbad.gui.Simbad;
import simbad.sim.*;
import javax.vecmath.Vector3d;
public class Sambalaberinto {


    /** Describe the robot */
    static public class Robot extends Agent {

        RangeSensorBelt sonars;
        CameraSensor camera;

        public Robot(Vector3d position, String name) {
            super(position, name);
            // Add camera
            camera = RobotFactory.addCameraSensor(this);
            // Add sonars
            sonars = RobotFactory.addSonarBeltSensor(this);
        }

        /** This method is called by the simulator engine on reset. */
        public void initBehavior() {
            // nothing particular in this case
        }

        /** This method is call cyclically (20 times per second)  by the simulator engine. */
        public void performBehavior() {

            // progress at 0.5 m/s
            setTranslationalVelocity(0.5);
            // frequently change orientation
            if ((getCounter() % 100) == 0)
                setRotationalVelocity(Math.PI / 2 * (0.5 - Math.random()));

            // print front sonar every 100 frames
            if (getCounter() % 100 == 0)
                System.out
                        .println("Sonar num 0  = " + sonars.getMeasurement(0));

        }
    }

    /** Describe the environement */
    static public class MyEnv extends EnvironmentDescription {
        public MyEnv() {
            light1IsOn = true;
            light2IsOn = false;
            Wall w1 = new Wall(new Vector3d(7, 0, 0), 14, 1, this);
            w1.rotate90(1);
            add(w1);
            Wall w2 = new Wall(new Vector3d(-7, 0, 0), 14, 1, this);
            w2.rotate90(1);
            add(w2);
            
            Wall w3 = new Wall(new Vector3d(0, 0, 7), 14, 1, this);
            add(w3);
            Wall w4 = new Wall(new Vector3d(2, 0, -7), 10, 1, this);
            add(w4);
            Wall w5 = new Wall(new Vector3d(-5, 0, 3.5), 7, 1, this);
            w5.rotate90(1);
            add(w5);
            Wall w6 = new Wall(new Vector3d(-5, 0, -6), 2, 1, this);
            w6.rotate90(1);
            add(w6);
            Wall w7 = new Wall(new Vector3d(-6, 0, -7), 2, 1, this);
            add(w7);
            Wall w8 = new Wall(new Vector3d(-5, 0, -2.5), 4, 1, this);
            add(w8);
            Wall w9 = new Wall(new Vector3d(0, 0, -5), 10, 1, this);
            add(w9);
            Wall w10 = new Wall(new Vector3d(-1, 0, -1.5), 7, 1, this);
            w10.rotate90(1);
            add(w10);
            Wall w11 = new Wall(new Vector3d(-3, 0, 1), 7, 1, this);
            w11.rotate90(1);
            add(w11);
            Wall w12 = new Wall(new Vector3d(3, 0, 4.5), 8, 1, this);
            add(w12);
            Wall w13 = new Wall(new Vector3d(1, 0, -1.5), 7, 1, this);
            w13.rotate90(1);
            add(w13);
            Wall w14 = new Wall(new Vector3d(3, 0, 2), 4, 1, this);
            add(w14);
            Wall w15 = new Wall(new Vector3d(5, 0, -0.5), 4, 1, this);
            add(w15);
            Wall w16 = new Wall(new Vector3d(3, 0, -1.5), 2, 1, this);
            w16.rotate90(1);
            add(w16);
            Wall w17 = new Wall(new Vector3d(5, 0, -4), 2, 1, this);
            w17.rotate90(1);
            add(w17);
            add(new Robot(new Vector3d(-6.5, 0, 6.5), "robot"));
           

        }
    }

    public static void main(String[] args) {
        // request antialising
        System.setProperty("j3d.implicitAntialiasing", "true");
        // create Simbad instance with given environment
        Simbad frame = new Simbad(new MyEnv(), false);
    }

} 