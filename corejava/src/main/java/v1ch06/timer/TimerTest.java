package v1ch06.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/11/27 18:30
 */
public class TimerTest {
    public static void main(String[] args) {
        var listener = new TimePrinter();

        var timer = new Timer(1000, listener);
        timer.start();

        JOptionPane.showConfirmDialog(null, "Quit program");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is " + Instant.ofEpochMilli(e.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}