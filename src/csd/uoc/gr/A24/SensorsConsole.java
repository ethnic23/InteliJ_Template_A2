package csd.uoc.gr.A24;

import csd.uoc.gr.A21.LaserSensor;
import csd.uoc.gr.A21.Sensor;
import csd.uoc.gr.A21.SensorLine;
import csd.uoc.gr.A21.TemperatureSensor;
import csd.uoc.gr.A22.HomeSecurity;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Takes as input an array of sensorlines and for each one of them
 * it shows each sensor as a button that toggles their violation status
 * @author tzitzik
 *
 */
class SensorsConsole extends JFrame {
    SensorLine[] sensorLines;
    void fill() {
        for (int i=0;i<sensorLines.length;i++) { // for each sensor line
            final SensorLine sl = sensorLines[i];
            JPanel sensorlinePanel = new JPanel(new GridLayout(0,4,5,5)); // rows, columns, int hgap,int vgap)
            sensorlinePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), sl.getId()));
//add(new JLabel(sl.getName()));
            for (final Sensor s: sl.getSensors()) { // gets the array of active sensors
                final JButton t = new JButton(s.getId()); // creation of button
                t.setToolTipText(s.toString());
                t.setOpaque(true);
                t.setBackground(s.getViolation()? Color.RED: Color.GREEN);
                t.addActionListener( // addition of the behavior of the button
                        new ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent e) {
                                s.seton(true); // optional: sets the sensor on
                                s.setViolation(!s.getViolation()); // toggles the violation status
                                t.setLabel(s.getId()); // updates the button's label
                                t.setBackground(s.getViolation()? Color.RED: Color.GREEN);
                                t.setToolTipText(s.toString());
                            }
                        }
                );
                sensorlinePanel.add(t); // adds the button to the panel
                add(sensorlinePanel); // adds the panel to the jframe
            }
        }
        setVisible(true); // makes the jframe visible
    }
    SensorsConsole(String title, SensorLine[] sensorLines) {
        this.sensorLines = sensorLines;
        this.setTitle(title);
        setBounds(200,100,800,600); //x, y, width, height)
        setLayout(new GridLayout(0,1)); // rows, columns
        setVisible(true);
        fill();
    }
}
/**
 * Graphical User Interface for the Alarm Controller
 * @author tzitzik
 *
 */
class AlarmConsole extends JFrame {
    HomeSecurity homeSecurityController ;
    JLabel labelStatus ;
    JLabel labelLog ;
    JButton buttonArm ;
    JButton buttonStay;
    JButton buttonDisarm ;
    JButton buttonChangeCode ;
    JTextField inputField;
    AlarmConsole(HomeSecurity homeSecurityController ) throws Exception {

    }
}
//===================
/**
 * The entire application comprising sensor simulator and graphical alarm console
 * @author tzitzik
 *
 */
class SensorsGUIapp {
    public static void main(String[] args) throws Exception {
        System.out.println("SENSORS GUI");
// A. CREATION OF SENSORS
        int K = 3; // number of sensor lines to be created
        int M = 4; // number of sensors per line
        SensorLine[] internallines = new SensorLine[K]; // internal sensor lines
        SensorLine[] externallines = new SensorLine[K]; // external sensor lines
// creation of internal and sensor lines
        for(int i=0;i<K;i++){
                internallines[i]=new SensorLine(1,M);
                externallines[i]=new SensorLine(2,M);
        }
// B. PASSES THE ARRAY OF SENSORS TO TWO SensorConsoles
        SensorsConsole internalSensorsConsole = new SensorsConsole("Internal Sensor Lines", internallines);
        SensorsConsole externalSensorsConsole = new SensorsConsole("External Sensor Lines", externallines);
// C. CREATION OF HomeSecurityController (from Askisi 2)
        HomeSecurity homeSecurityController = new HomeSecurity(internallines,externallines);
// D. PASSES HomeSecurityController TO AlarmConsole
        AlarmConsole alarmConsole = new AlarmConsole(homeSecurityController);
    }
}