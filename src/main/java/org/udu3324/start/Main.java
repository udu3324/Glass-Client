package org.udu3324.start;

import org.udu3324.resources.DataValues;
import org.udu3324.ui.StartUI;
import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        DataValues val = new DataValues();
        new StartUI();
        System.out.println("GlassClient v"+val.ver+" has started.");
    }
}
