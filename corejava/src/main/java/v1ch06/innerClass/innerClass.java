package v1ch06.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class innerClass {

    public static void main(String[] args) {
        TalKingClock talKingClock = new TalKingClock(1000, true);
        talKingClock.start();

        JOptionPane.showConfirmDialog(null, "Quit program");
        System.exit(0);
    }
}

class TalKingClock {

    private int interval;
    private boolean beep;

    public TalKingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        TimerPrinter timerPrinter = new TimerPrinter();
        Timer timer = new Timer(interval, timerPrinter);
        timer.start();
    }

    public class TimerPrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
