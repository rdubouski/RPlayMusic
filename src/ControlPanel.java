import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;

public class ControlPanel {

    JFrame controlFrame;
    JButton playSound, stopSound;
    Thread playAudio;

    boolean checkPlay = false;
    public ControlPanel() {

        controlFrame = new JFrame();
        controlFrame.setTitle("PlayMusic");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setBounds(880, 0, 200, 30);
        //controlFrame.setLocationRelativeTo(null);
        controlFrame.setResizable(false);
        controlFrame.setLayout(null);
        controlFrame.setAlwaysOnTop(true);
        controlFrame.setUndecorated(true);

        playSound = new JButton("Старт");
        playSound.setBounds(0,0, 100, 30);
        playSound.setHideActionText(true);
        playSound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checkPlay) {
                    playAudio = new Thread(new PlayAudio());
                    playAudio.start();
                    checkPlay = true;
                }
            }
        });


        stopSound = new JButton("Стоп");
        stopSound.setBounds(100,0, 100, 30);
        stopSound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAudio.stop();
                checkPlay = false;
            }
        });

        controlFrame.add(playSound);
        controlFrame.add(stopSound);

        controlFrame.setVisible(true);

        stopSound.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

                controlFrame.setLocation(e.getXOnScreen(), e.getYOnScreen());
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }
}
