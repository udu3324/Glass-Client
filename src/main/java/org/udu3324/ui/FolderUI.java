package org.udu3324.ui;

import org.udu3324.start.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class FolderUI {
    public JPanel rootPanel;
    public JLabel descriptionLabel;
    public JPanel filePanel;
    public JButton confirmFileLocButton;
    public JTextField filePathTextField;
    public JButton fileExplorerButton;
    public String confirmedPath;
    public int areYouSure = 0;
    public FolderUI() {
        filePathTextField.setText(String.valueOf(Paths.get(System.getenv("APPDATA"), ".minecraft")));
        fileExplorerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(rootPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    filePathTextField.setText(String.valueOf(selectedFile));
                }
            }
        });
        confirmFileLocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmedPath = filePathTextField.getText();
                String confirmedPath2 = confirmedPath+"\\logs\\latest.log";
                File mcFileLocation = new File(confirmedPath2);
                System.out.println(confirmedPath2);
                if (mcFileLocation.exists()) {
                    System.out.println("this mc file path is valid");
                    try {
                        FileWriter myWriter = new FileWriter("conf.txt", true);
                        myWriter.write("Filepath = "+ confirmedPath +"\n"); //without \logs\latest.log
                        myWriter.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    confirmFileLocButton.setEnabled(false);
                    fileExplorerButton.setEnabled(false);
                    filePathTextField.setEnabled(false);
                    JFrame moduleUI = new JFrame("Setup | Module Selector");
                    URL iconURL = Main.class.getResource("logo-glass-client-square-16x16x.png");
                    ImageIcon icon = new ImageIcon(iconURL);
                    moduleUI.setIconImage(icon.getImage());
                    try {
                        moduleUI.setContentPane(new ModuleSelectorUI() .rootPanel);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    moduleUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    moduleUI.pack();
                    moduleUI.setLocationRelativeTo(null);
                    moduleUI.setResizable(false);
                    moduleUI.setVisible(false);

                    //checker
                    moduleUI.addWindowListener(new WindowAdapter() {
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

                    moduleUI.setVisible(true);
                } else {
                    System.out.println("this mc file path is invalid");
                    JOptionPane.showMessageDialog(rootPanel,
                            "The file path you provided does not link to mc or it's invalid.\n" +
                                    "Make sure you typed it right or entered the correct path to mc.",
                            "Hey!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        filePathTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmedPath = filePathTextField.getText();
                String confirmedPath2 = confirmedPath+"\\logs\\latest.log";
                File mcFileLocation = new File(confirmedPath2);
                System.out.println(confirmedPath2);
                if (mcFileLocation.exists()) {
                    System.out.println("this mc file path is valid");
                    try {
                        FileWriter myWriter = new FileWriter("conf.txt", true);
                        myWriter.write("Filepath = "+ confirmedPath +"\n"); //without \logs\latest.log
                        myWriter.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    confirmFileLocButton.setEnabled(false);
                    fileExplorerButton.setEnabled(false);
                    filePathTextField.setEnabled(false);
                    JFrame moduleUI = new JFrame("Setup | Module Selector");
                    URL iconURL = Main.class.getResource("logo-glass-client-square-16x16x.png");
                    ImageIcon icon = new ImageIcon(iconURL);
                    moduleUI.setIconImage(icon.getImage());
                    try {
                        moduleUI.setContentPane(new ModuleSelectorUI() .rootPanel);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    moduleUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    moduleUI.pack();
                    moduleUI.setLocationRelativeTo(null);
                    moduleUI.setResizable(false);
                    moduleUI.setVisible(false);

                    //checker
                    moduleUI.addWindowListener(new WindowAdapter() {
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

                    moduleUI.setVisible(true);
                } else {
                    System.out.println("this mc file path is invalid");
                    JOptionPane.showMessageDialog(rootPanel,
                            "The file path you provided does not link to mc or it's invalid.\n" +
                                    "Make sure you typed it right or entered the correct path to mc.",
                            "Hey!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
