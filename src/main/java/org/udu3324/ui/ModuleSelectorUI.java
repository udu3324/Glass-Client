package org.udu3324.ui;

import org.udu3324.resources.DataValues;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ModuleSelectorUI {
    DataValues val = new DataValues();
    File obj = new File("conf.txt");
    private JPanel modulePanel;
    private JPanel blatantModulePanel;
    private JLabel titleLabel1;
    private JCheckBox critCheckBox;
    private JCheckBox reachCheckBox;
    private JCheckBox killAuraCheckBox;
    private JCheckBox triggerCheckBox;
    private JCheckBox aimBotCheckBox;
    private JPanel autoModulePanel;
    private JLabel titleLabel2;
    private JCheckBox autoHealCheckBox;
    private JCheckBox autoFishCheckBox;
    private JCheckBox autoBowCheckBox;
    private JCheckBox autoAimCheckBox;
    private JCheckBox autoEatCheckBox;
    private JPanel assistAIModulePanel;
    private JLabel titleLabel3;
    private JCheckBox pvpAICheckBox;
    private JCheckBox lagAICheckBox;
    private JCheckBox bowAICheckBox;
    private JCheckBox aimAICheckBox;
    private JCheckBox bridgeAICheckBox;
    private JPanel exploitModulePanel;
    private JLabel titleLabel4;
    private JCheckBox scaffoldCheckBox;
    private JCheckBox chestStealerCheckBox;
    private JCheckBox jeasusCheckBox;
    private JCheckBox dupeCheckBox;
    private JCheckBox timerCheckBox;
    private JPanel renderModulePanel;
    private JLabel titleLabel5;
    private JCheckBox antiFallDMGCheckBox;
    private JCheckBox bhopCheckBox;
    private JCheckBox jumpCheckBox;
    private JCheckBox speedCheckBox;
    private JCheckBox antiKBCheckBox;
    private JPanel specificModulePanel;
    private JLabel titleLabel6;
    private JCheckBox bedBreakAICheckBox;
    private JCheckBox autoCrystalCheckBox;
    private JCheckBox autoPyroCheckBox;
    private JCheckBox autoShinitoCheckBox;
    private JCheckBox autoSRageCheckBox;
    private JButton confirmButton;
    private JLabel descriptionLabel;
    public JPanel rootPanel;
    public String oneUnconverted;
    {
        Scanner s = new Scanner(obj);
        oneUnconverted = s.nextLine();
        s.close();
    }
    public String convertedCode = oneUnconverted.substring(7);


    public ModuleSelectorUI() throws FileNotFoundException {
        System.out.println(convertedCode);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter myWriter = new FileWriter("conf.txt", true);
                    //blatant
                    if (killAuraCheckBox.isSelected()) {
                        myWriter.write("6CLt9CnaRp"+"\n");
                    }
                    if (reachCheckBox.isSelected()) {
                        myWriter.write("sj8a7iEGHR"+"\n");
                    }
                    if (critCheckBox.isSelected()) {
                        myWriter.write("2FB7oQ5cPG"+"\n");
                    }
                    if (aimBotCheckBox.isSelected()) {
                        myWriter.write("cqoL2ZYUTv"+"\n");
                    }
                    if (triggerCheckBox.isSelected()) {
                        myWriter.write("gAwivu9wkV"+"\n");
                    }

                    //auto
                    if (autoEatCheckBox.isSelected()) {
                        myWriter.write("uMi9Rzfuuu"+"\n");
                    }
                    if (autoAimCheckBox.isSelected()) {
                        myWriter.write("jQPCQqaDGc"+"\n");
                    }
                    if (autoBowCheckBox.isSelected()) {
                        myWriter.write("HdnGEDjZXR"+"\n");
                    }
                    if (autoFishCheckBox.isSelected()) {
                        myWriter.write("NBHu5sELDT"+"\n");
                    }
                    if (autoHealCheckBox.isSelected()) {
                        myWriter.write("iamgobTMQP"+"\n");
                    }

                    //assist/ai
                    if (aimAICheckBox.isSelected()) {
                        myWriter.write("QP5bdhxbto"+"\n");
                    }
                    if (bowAICheckBox.isSelected()) {
                        myWriter.write("Xj7aFXqr6i"+"\n");
                    }
                    if (bridgeAICheckBox.isSelected()) {
                        myWriter.write("CN3j9azonm"+"\n");
                    }
                    if (lagAICheckBox.isSelected()) {
                        myWriter.write("HVQrigrrNW"+"\n");
                    }
                    if (pvpAICheckBox.isSelected()) {
                        myWriter.write("3ht2dDqxiF"+"\n");
                    }

                    //exploits
                    if (jeasusCheckBox.isSelected()) {
                        myWriter.write("uvqVhCfqUh"+"\n");
                    }
                    if (chestStealerCheckBox.isSelected()) {
                        myWriter.write("DfkZQSfGqs"+"\n");
                    }
                    if (scaffoldCheckBox.isSelected()) {
                        myWriter.write("xgrsYsjL2m"+"\n");
                    }
                    if (timerCheckBox.isSelected()) {
                        myWriter.write("6XBjs2BsDM"+"\n");
                    }
                    if (dupeCheckBox.isSelected()) {
                        myWriter.write("dGYrGcxAvU"+"\n");
                    }

                    //render
                    if (speedCheckBox.isSelected()) {
                        myWriter.write("LGGNWadPCR"+"\n");
                    }
                    if (jumpCheckBox.isSelected()) {
                        myWriter.write("xa6AHnMady"+"\n");
                    }
                    if (bhopCheckBox.isSelected()) {
                        myWriter.write("A8e4DzVtQc"+"\n");
                    }
                    if (antiFallDMGCheckBox.isSelected()) {
                        myWriter.write("i9sH4h6XdM"+"\n");
                    }
                    if (antiKBCheckBox.isSelected()) {
                        myWriter.write("7255r2s4Cn"+"\n");
                    }

                    //specific
                    if (autoCrystalCheckBox.isSelected()) {
                        myWriter.write("Qu2nMLe2N6"+"\n");
                    }
                    if (autoSRageCheckBox.isSelected()) {
                        myWriter.write("RmFsAZmpyP"+"\n");
                    }
                    if (autoShinitoCheckBox.isSelected()) {
                        myWriter.write("R378LHsCsx"+"\n");
                    }
                    if (autoPyroCheckBox.isSelected()) {
                        myWriter.write("eU6VFNK3s3"+"\n");
                    }
                    if (bedBreakAICheckBox.isSelected()) {
                        myWriter.write("XvUBpT8CP3"+"\n");
                    }
                    myWriter.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                confirmButton.setEnabled(false);
                killAuraCheckBox.setEnabled(false);
                reachCheckBox.setEnabled(false);
                critCheckBox.setEnabled(false);
                aimBotCheckBox.setEnabled(false);
                triggerCheckBox.setEnabled(false);
                autoEatCheckBox.setEnabled(false);
                autoAimCheckBox.setEnabled(false);
                autoBowCheckBox.setEnabled(false);
                autoFishCheckBox.setEnabled(false);
                autoHealCheckBox.setEnabled(false);
                aimAICheckBox.setEnabled(false);
                bowAICheckBox.setEnabled(false);
                bridgeAICheckBox.setEnabled(false);
                lagAICheckBox.setEnabled(false);
                pvpAICheckBox.setEnabled(false);
                jeasusCheckBox.setEnabled(false);
                chestStealerCheckBox.setEnabled(false);
                scaffoldCheckBox.setEnabled(false);
                timerCheckBox.setEnabled(false);
                dupeCheckBox.setEnabled(false);
                speedCheckBox.setEnabled(false);
                jumpCheckBox.setEnabled(false);
                bhopCheckBox.setEnabled(false);
                antiFallDMGCheckBox.setEnabled(false);
                antiKBCheckBox.setEnabled(false);
                autoCrystalCheckBox.setEnabled(false);
                autoSRageCheckBox.setEnabled(false);
                autoShinitoCheckBox.setEnabled(false);
                autoPyroCheckBox.setEnabled(false);
                bedBreakAICheckBox.setEnabled(false);

                JOptionPane.showMessageDialog(rootPanel,
                        "There will be a conf.txt to skip setup. Please \n" +
                        "do not modify or change anything in it! \n\n" +
                        "To start using Glass Client v"+val.ver+", press Okay and open the \n" +
                        "GlassClient.jar again. Then proceed to enter your code \nonce again.",
                        "Setup Complete!",
                        JOptionPane.PLAIN_MESSAGE);
                System.exit(1);
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (convertedCode.contains(val.freeCode)) {
                    JOptionPane.showMessageDialog(rootPanel, "You can not use this module as it \nis only for Pro users only!");
                    triggerCheckBox.setSelected(false);
                    aimBotCheckBox.setSelected(false);
                    autoHealCheckBox.setSelected(false);
                    pvpAICheckBox.setSelected(false);
                    lagAICheckBox.setSelected(false);
                    bridgeAICheckBox.setSelected(false);
                    dupeCheckBox.setSelected(false);
                    timerCheckBox.setSelected(false);
                    antiKBCheckBox.setSelected(false);
                    bedBreakAICheckBox.setSelected(false);
                    autoPyroCheckBox.setSelected(false);
                    autoShinitoCheckBox.setSelected(false);
                }
            }
        };
        triggerCheckBox.addActionListener(listener);
        aimBotCheckBox.addActionListener(listener);
        autoHealCheckBox.addActionListener(listener);
        pvpAICheckBox.addActionListener(listener);
        lagAICheckBox.addActionListener(listener);
        bridgeAICheckBox.addActionListener(listener);
        dupeCheckBox.addActionListener(listener);
        timerCheckBox.addActionListener(listener);
        antiKBCheckBox.addActionListener(listener);
        bedBreakAICheckBox.addActionListener(listener);
        autoPyroCheckBox.addActionListener(listener);
        autoShinitoCheckBox.addActionListener(listener);
    }

}
