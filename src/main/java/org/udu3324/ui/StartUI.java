package org.udu3324.ui;

import org.udu3324.resources.DataValues;
import org.udu3324.start.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class StartUI {
    DataValues val = new DataValues();
    public JPanel rootPanel;
    public JButton loginButton;
    public JTextField codeTextField;
    public JPanel titlePanel;
    public JPanel codePanel;
    public JLabel logoLabel;
    public JLabel versionLabel;
    public JLabel creditLabel;
    public JLabel descriptionLabel;
    public JLabel enterCodeLabel;
    public String codeEntered;
    String repoStatus = val.If1+val.I23+val.In3+val.nfo+val.fo5;
    public int setupSkip; //0 = no skip, 1 = skip
    public int areYouSure = 0;
    public File f = new File("conf.txt");
    public StartUI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException, IOException {
        //start startUI
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JFrame startUI = new JFrame("Glass Client v"+val.ver);
        URL iconURLe = Main.class.getResource("logo-glass-client-square-16x16x.png");
        assert iconURLe != null;
        ImageIcon icon1e = new ImageIcon(iconURLe);
        startUI.setIconImage(icon1e.getImage());
        startUI.setContentPane(rootPanel);
        startUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startUI.pack();
        startUI.setLocationRelativeTo(null);
        int width1 = startUI.getX();
        int height1 = startUI.getY();
        int height11 = val.height;
        startUI.setLocation( width1 , height11 );
        startUI.setResizable(false);
        startUI.setVisible(true);
        System.out.println("startUI loaded");

        while (height11 > height1) {
            Thread.sleep(2);
            startUI.setLocation( width1 , (height11 - 1) );
            height11 = height11 - 2;
        }

        //check for conf file
        if (f.exists()) {
            System.out.println("conf.txt file exists");
            setupSkip = 1;
        } else {
            System.out.println("conf.txt file does not exist");
            setupSkip = 0;
        }
        JFrame folderUI = new JFrame("Setup | File Selector");
        URL iconURL = Main.class.getResource("logo-glass-client-square-16x16x.png");
        assert iconURL != null;
        ImageIcon icon = new ImageIcon(iconURL);
        folderUI.setIconImage(icon.getImage());
        folderUI.setContentPane(new FolderUI() .rootPanel);
        folderUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        folderUI.pack();
        folderUI.setLocationRelativeTo(null);
        folderUI.setResizable(false);
        folderUI.setVisible(false);

        JFrame proUI = new JFrame("Glass Client v"+val.ver);
        URL iconURL1 = Main.class.getResource("logo-glass-client-square-16x16x.png");
        assert iconURL1 != null;
        ImageIcon icon1 = new ImageIcon(iconURL1);
        proUI.setIconImage(icon1.getImage());
        proUI.setContentPane(new ProUI() .rootPanel);
        proUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        proUI.pack();
        proUI.setLocationRelativeTo(null);
        proUI.setResizable(false);
        proUI.setVisible(false);

        JFrame demoUI = new JFrame("Glass Client v"+val.ver);
        URL iconURL11 = Main.class.getResource("logo-glass-client-square-16x16x.png");
        assert iconURL11 != null;
        ImageIcon icon11 = new ImageIcon(iconURL11);
        demoUI.setIconImage(icon11.getImage());
        demoUI.setContentPane(new DemoUI() .rootPanel);
        demoUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        demoUI.pack();
        demoUI.setLocationRelativeTo(null);
        demoUI.setResizable(false);
        demoUI.setVisible(false);

        //checker
        folderUI.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (areYouSure == 1) {
                    File myObj = new File("conf.txt");
                    if (myObj.delete()) {
                        System.out.println("Deleted the file: " + myObj.getName());
                    } else {
                        System.out.println("Failed to delete the file.");
                    }
                    System.exit(1);
                }
                JOptionPane.showMessageDialog(rootPanel,
                        "Are you sure you want to exit Glass Client?\n" +
                                "You will lose all your progress! Click\n" +
                                "the X again to exit Glass Client.");
                areYouSure = 1;
            }
        });
        proUI.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(rootPanel, "Use the \"Exit Client\" button instead. ");
            }
        });
        demoUI.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(rootPanel, "Use the \"Exit Client\" button instead. ");
            }
        });

        //set version label
        versionLabel.setText("v"+val.ver);

        //action listeners
        loginButton.addActionListener(e -> {
            codeEntered = codeTextField.getText();
            if (codeEntered.equals(val.freeCode)) {
                System.out.println("freeCode entered!");
                if (setupSkip == 0) {
                    folderUI.setVisible(true);
                    startUI.setVisible(false);
                    JOptionPane.showMessageDialog(rootPanel,
                            "Welcome to Glass Client v"+val.ver+" setup. (demo)");
                    //create file
                    try {
                        File myObj = new File("conf.txt");
                        if (myObj.createNewFile()) {
                            System.out.println("File created: " + myObj.getName());
                            FileWriter myWriter = new FileWriter("conf.txt", true);
                            myWriter.write("Code = "+ codeEntered +"\n");
                            myWriter.close();
                        } else {
                            System.out.println("File already exists.");
                        }
                    } catch (IOException b) {
                        System.out.println("An error occurred.");
                        b.printStackTrace();
                    }
                } else {
                    startUI.setVisible(false);
                    demoUI.setVisible(true);
                    JOptionPane.showMessageDialog(rootPanel,
                            "Welcome to Glass Client v"+val.ver+" Demo Edition.");
                }
            } else {
                if (codeEntered.equals(val.proCode)) {
                    System.out.println("proCode entered!");
                    try {
                        URI uri= new URI("https://www.youtube.com/watch?v=xvFZjo5PgG0");
                        java.awt.Desktop.getDesktop().browse(uri);
                    } catch (Exception a) {
                        a.printStackTrace();
                    }
                    System.out.println("lol, try harder");
                    System.exit(-1);
                    JOptionPane.showMessageDialog(rootPanel,
                            "Welcome to Glass Client v"+val.ver+". (pro)");
                } else {
                    if (codeEntered.equals(repoStatus)) {
                        System.out.println("repoStatus entered!");
                        if (setupSkip == 0) {
                            folderUI.setVisible(true);
                            startUI.setVisible(false);
                            JOptionPane.showMessageDialog(rootPanel,
                                    "Welcome to Glass Client v"+val.ver+" setup. (pro)");
                            //create file
                            try {
                                File myObj = new File("conf.txt");
                                if (myObj.createNewFile()) {
                                    System.out.println("File created: " + myObj.getName());
                                    FileWriter myWriter = new FileWriter("conf.txt", true);
                                    myWriter.write("Code = "+ codeEntered +"\n");
                                    myWriter.close();
                                } else {
                                    System.out.println("File already exists.");
                                }
                            } catch (IOException b) {
                                System.out.println("An error occurred.");
                                b.printStackTrace();
                            }
                        } else {
                            startUI.setVisible(false);
                            proUI.setVisible(true);
                            JOptionPane.showMessageDialog(rootPanel,
                                    "Welcome to Glass Client v"+val.ver+" Pro Edition.");
                        }
                    } else {
                        System.out.println("The code you entered is wrong!");
                        JOptionPane.showMessageDialog(rootPanel,
                                "The code you entered is wrong! Make sure you\n" +
                                        "typed in the right code as the code field is case/\n" +
                                        "space/everything sensitive.",
                                "Wrong Code!",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        codeTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("enter");
                codeEntered = codeTextField.getText();
                if (codeEntered.equals(val.freeCode)) {
                    System.out.println("freeCode entered!");
                    if (setupSkip == 0) {
                        folderUI.setVisible(true);
                        startUI.setVisible(false);
                        JOptionPane.showMessageDialog(rootPanel,
                                "Welcome to Glass Client v"+val.ver+" setup. (demo)");
                        //create file
                        try {
                            File myObj = new File("conf.txt");
                            if (myObj.createNewFile()) {
                                System.out.println("File created: " + myObj.getName());
                                FileWriter myWriter = new FileWriter("conf.txt", true);
                                myWriter.write("Code = "+ codeEntered +"\n");
                                myWriter.close();
                            } else {
                                System.out.println("File already exists.");
                            }
                        } catch (IOException b) {
                            System.out.println("An error occurred.");
                            b.printStackTrace();
                        }
                    } else {
                        startUI.setVisible(false);
                        demoUI.setVisible(true);
                        JOptionPane.showMessageDialog(rootPanel,
                                "Welcome to Glass Client v"+val.ver+" Demo Edition.");
                    }
                } else {
                    if (codeEntered.equals(val.proCode)) {
                        System.out.println("proCode entered!");
                        try {
                            URI uri= new URI("https://youtu.be/dQw4w9WgXcQ");
                            java.awt.Desktop.getDesktop().browse(uri);
                        } catch (Exception a) {
                            a.printStackTrace();
                        }
                        System.out.println("lol, try harder");
                        System.exit(-1);
                        JOptionPane.showMessageDialog(rootPanel,
                                "Welcome to Glass Client v"+val.ver+". (pro)");
                    } else {
                        if (codeEntered.equals(repoStatus)) {
                            System.out.println("repoStatus entered!");
                            if (setupSkip == 0) {
                                folderUI.setVisible(true);
                                startUI.setVisible(false);
                                JOptionPane.showMessageDialog(rootPanel,
                                        "Welcome to Glass Client v"+val.ver+" setup. (pro)");
                                //create file
                                try {
                                    File myObj = new File("conf.txt");
                                    if (myObj.createNewFile()) {
                                        System.out.println("File created: " + myObj.getName());
                                        FileWriter myWriter = new FileWriter("conf.txt", true);
                                        myWriter.write("Code = "+ codeEntered +"\n");
                                        myWriter.close();
                                    } else {
                                        System.out.println("File already exists.");
                                    }
                                } catch (IOException b) {
                                    System.out.println("An error occurred.");
                                    b.printStackTrace();
                                }
                            } else {
                                startUI.setVisible(false);
                                proUI.setVisible(true);
                                JOptionPane.showMessageDialog(rootPanel,
                                        "Welcome to Glass Client v"+val.ver+" Pro Edition.");
                            }
                        } else {
                            System.out.println("The code you entered is wrong!");
                            JOptionPane.showMessageDialog(rootPanel,
                                    "The code you entered is wrong! Make sure you\n" +
                                            "typed in the right code as the code field is case/\n" +
                                            "space/everything sensitive.",
                                    "Wrong Code!",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    }
}
