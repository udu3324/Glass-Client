package org.udu3324.ui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ProUI {
    public JPanel rootPanel;
    private JPanel titlePanel;
    private JLabel logoLabel;
    private JLabel descriptionLabel;
    private JPanel actionPanel;
    private JPanel statusPanel;
    private JPanel optionsPanel;
    private JPanel clientStatusPanel;
    private JPanel mcStatusPanel;
    private JLabel mcStatusLabel;
    private JLabel mcLabel;
    private JLabel clientLabel;
    private JLabel clientStatusLabel;
    private JLabel optionsLabel;
    private JButton exitClientButton;
    private JButton moduleEditorButton;
    private JButton toggleClientButton;
    private JButton githubLinkButton;
    public Integer switchInt = 0;
    public String oneUnconverted;
    public String oneUnconverted2 = "9q348tyh89efu1hg0984gju9h103948gu";
    public String convertedFileLoc = "9q348tyh89efu1hg0984gju9h103948gu";
    Color red = new Color(187, 47,45);
    Color yellow = new Color(255, 207, 0);
    Color slightGreen = new Color(188,255,0);
    Color green = new Color(2, 186, 2);

    public Integer e3 = 0;
    public ProUI() throws FileNotFoundException {
        File f = new File("conf.txt");
        if (f.exists()) {
            File obj = new File("conf.txt");
            Scanner s = new Scanner(obj);
            oneUnconverted = s.nextLine();
            oneUnconverted2 = s.nextLine();
            s.close();
        }
        convertedFileLoc = oneUnconverted2.substring(11)+"\\logs\\latest.log";
        toggleClientButton.addActionListener(e -> {
            if (switchInt == 0) {
                //offline to online
                Timer timer1 = new Timer();
                TimerTask task1 = new TimerTask() {
                    @Override
                    public void run() {
                        toggleClientButton.setEnabled(false);
                        clientStatusLabel.setText("Attaching Game Hook");
                        clientStatusPanel.setBackground(yellow);
                    }
                };
                Timer timer2 = new Timer();
                TimerTask task2 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Encrypting API Key");
                        clientStatusPanel.setBackground(yellow);
                    }
                };
                Timer timer3 = new Timer();
                TimerTask task3 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Sending Req Packets");
                        clientStatusPanel.setBackground(yellow);
                    }
                };
                Timer timer4 = new Timer();
                TimerTask task4 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Receiving Data");
                        clientStatusPanel.setBackground(yellow);
                    }
                };
                Timer timer5 = new Timer();
                TimerTask task5 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Saving Data [#--]");
                        clientStatusPanel.setBackground(slightGreen);
                    }
                };
                Timer timer6 = new Timer();
                TimerTask task6 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Saving Data [##-]");
                        clientStatusPanel.setBackground(slightGreen);
                    }
                };
                Timer timer7 = new Timer();
                TimerTask task7 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Saving Data [###]");
                        clientStatusPanel.setBackground(slightGreen);
                    }
                };
                Timer timer8 = new Timer();
                TimerTask task8 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Online");
                        clientStatusPanel.setBackground(green);
                        toggleClientButton.setEnabled(true);
                    }
                };
                timer1.schedule(task1, 0);
                timer2.schedule(task2, 1000);
                timer3.schedule(task3, 2500);
                timer4.schedule(task4, 4100);
                timer5.schedule(task5, 6100);
                timer6.schedule(task6, 9600);
                timer7.schedule(task7, 12600);
                timer8.schedule(task8, 16400);
                switchInt = 1;
            } else {
                //online to offline
                Timer timerTimer1 = new Timer();
                TimerTask taskTask1 = new TimerTask() {
                    @Override
                    public void run() {
                        toggleClientButton.setEnabled(false);
                        clientStatusLabel.setText("Unhooking To Game");
                        clientStatusPanel.setBackground(slightGreen);
                    }
                };
                Timer timerTimer2 = new Timer();
                TimerTask taskTask2 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Closing API Session");
                        clientStatusPanel.setBackground(slightGreen);
                    }
                };
                Timer timerTimer3 = new Timer();
                TimerTask taskTask3 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Deleting Resources [---]");
                        clientStatusPanel.setBackground(yellow);
                    }
                };
                Timer timerTimer4 = new Timer();
                TimerTask taskTask4 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Deleting Resources [#--]");
                        clientStatusPanel.setBackground(yellow);
                    }
                };
                Timer timerTimer5 = new Timer();
                TimerTask taskTask5 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Deleting Resources [##-]");
                        clientStatusPanel.setBackground(yellow);
                    }
                };
                Timer timerTimer6 = new Timer();
                TimerTask taskTask6 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Deleting Resources [###]");
                        clientStatusPanel.setBackground(yellow);
                    }
                };
                Timer timerTimer7 = new Timer();
                TimerTask taskTask7 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Offline");
                        clientStatusPanel.setBackground(red);
                        toggleClientButton.setEnabled(true);
                    }
                };
                timerTimer1.schedule(taskTask1, 0);
                timerTimer2.schedule(taskTask2, 1000);
                timerTimer3.schedule(taskTask3, 2500);
                timerTimer4.schedule(taskTask4, 4100);
                timerTimer5.schedule(taskTask5, 6100);
                timerTimer6.schedule(taskTask6, 9600);
                timerTimer7.schedule(taskTask7, 12600);
                switchInt = 0;
            }
        });
        moduleEditorButton.addActionListener(e -> JOptionPane.showMessageDialog(rootPanel,
                "The module editor is currently in progress.\n" +
                        "Alternatively, delete conf.txt to do the\n" +
                        "Glass Client setup again."));
        githubLinkButton.addActionListener(e -> {
            try {
                URI uri= new URI("https://github.com/udu3324");
                Desktop.getDesktop().browse(uri);
            } catch (Exception a) {
                a.printStackTrace();
            }
        });
        exitClientButton.addActionListener(e -> {
            if (switchInt == 0) {
                //offline to online
                System.exit(1);
            } else {
                toggleClientButton.setEnabled(false);
                moduleEditorButton.setEnabled(false);
                githubLinkButton.setEnabled(false);
                exitClientButton.setEnabled(false);
                //online to offline
                Timer timerTimer1 = new Timer();
                TimerTask taskTask1 = new TimerTask() {
                    @Override
                    public void run() {
                        toggleClientButton.setEnabled(false);
                        clientStatusLabel.setText("Unhooking To Game");
                        clientStatusPanel.setBackground(slightGreen);
                    }
                };
                Timer timerTimer2 = new Timer();
                TimerTask taskTask2 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Closing API Session");
                        clientStatusPanel.setBackground(slightGreen);
                    }
                };
                Timer timerTimer3 = new Timer();
                TimerTask taskTask3 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Deleting Resources [---]");
                        clientStatusPanel.setBackground(yellow);
                    }
                };
                Timer timerTimer4 = new Timer();
                TimerTask taskTask4 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Deleting Resources [#--]");
                        clientStatusPanel.setBackground(yellow);
                    }
                };
                Timer timerTimer5 = new Timer();
                TimerTask taskTask5 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Deleting Resources [##-]");
                        clientStatusPanel.setBackground(yellow);
                    }
                };
                Timer timerTimer6 = new Timer();
                TimerTask taskTask6 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Deleting Resources [###]");
                        clientStatusPanel.setBackground(yellow);
                    }
                };
                Timer timerTimer7 = new Timer();
                TimerTask taskTask7 = new TimerTask() {
                    @Override
                    public void run() {
                        clientStatusLabel.setText("Offline");
                        clientStatusPanel.setBackground(red);
                        toggleClientButton.setEnabled(true);
                    }
                };
                Timer timerTimer8 = new Timer();
                TimerTask taskTask8 = new TimerTask() {
                    @Override
                    public void run() {
                        System.exit(1);
                    }
                };
                timerTimer1.schedule(taskTask1, 0);
                timerTimer2.schedule(taskTask2, 1000);
                timerTimer3.schedule(taskTask3, 2500);
                timerTimer4.schedule(taskTask4, 4100);
                timerTimer5.schedule(taskTask5, 6100);
                timerTimer6.schedule(taskTask6, 9600);
                timerTimer7.schedule(taskTask7, 12600);
                timerTimer8.schedule(taskTask8, 13700);
            }
        });
        System.out.println(convertedFileLoc);
        TimerTask task = new FileWatcher(new File(convertedFileLoc)) {
            public void onChange(File file) {
                if (e3 == 0) {
                    mcStatusLabel.setText("Online");
                    mcStatusPanel.setBackground(green);

                    System.out.println("file change detected");

                    e3 = 1;

                    java.util.Timer e1 = new java.util.Timer();
                    TimerTask e2 = new TimerTask() {
                        @Override
                        public void run() {
                            mcStatusLabel.setText("Offline");
                            mcStatusPanel.setBackground(red);

                            System.out.println("code ran");
                            e3 = 0;
                        }
                    };

                    e1.schedule(e2, 300000);
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task ,new Date(),1 );
    }
}
