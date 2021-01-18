package stopwatch;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Stopwatch {

    static int time = 0;
    static boolean running;
    static Thread t1, t2;

    public static void main(String[] args) {

        t1 = new Thread(new Runnable() {
            public void run() {
                app();
            }
        });
        t1.start();
    }

    public static void app() {
        JFrame frame = new JFrame("StopWatch");
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);

        //sets up label to refresh every second
        JLabel label = new JLabel();
        label.setFont(new Font("Comic sans", Font.PLAIN, 60));
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(Integer.toString(time));
                System.out.println("i");
            }
        });
        timer.start();
        //start button
        JButton b1 = new JButton("Start");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t2 = new Thread(new Runnable() {
                    public void run() {
                        timing();
                    }
                });
                t2.start();
                System.out.println("g");
            }
        });
        //stop button
        JButton b2 = new JButton("Stop");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stop();
                System.out.println("h");
            }
        });
        //reset button
        JButton b3 = new JButton("Reset");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset();
                System.out.println("l");
            }
        });

        b1.setBounds(1, 1, 100, 100);
        b2.setBounds(102, 1, 100, 100);
        b3.setBounds(203, 1, 100, 100);
        label.setBounds(440, 440, 100, 100);
        frame.add(label);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);

    }

    public static void timing() {
        while (running) {
            try {
                Thread.sleep(1000);
                System.out.println(time);
            } catch (Exception e) {
                e.printStackTrace();
            }
            time++;
            System.out.println("j");

        }
    }

    public static void start() {

    }

    public static void stop() {
        running = false;
    }

    public static void reset() {
        time = 0;
    }

}
