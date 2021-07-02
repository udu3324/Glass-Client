package org.udu3324.resources;

import java.awt.*;

public class DataValues {
    public String ver = "1.3"; //version
    public String proCode = "K7DQX8-T2HMZR-UT8K32-Y64AMF-MJLLWD"; //only udu3324 can use this code (don't try it)
    public String freeCode = "JYEG4B-QCUT9G-E82UX2-RNNN7C-VS5FNS"; //everyone can use this code

    //display size
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public int height = (int)size.getHeight();

    public Integer aiLVL = 3; //max level of ai used (cant go past 3)
    public Integer mR; //515
    public String compDat1 = "mcLT"; //mc load= true
    public String compDat2; //disable filter
    public String compDat3 = "en"; //lang english
    public String helloWorld = "c"; //c
    public String compDat4; //click listener true
    public String compDat5 = helloWorld+"CT"; //clickControl true
    public String compDat6; //m4 library enable
    public String compDat7; //tailer library enable
    public String compDat8; //ai API name
    public String compDat9; //ai API key

    {
        compDat4 = helloWorld + "lT";
        mR = aiLVL + 512;
        compDat2 = "dF";
        compDat6 = "m4E";
        compDat7 = "taE";
        compDat8 = "1s";
        compDat9 = "v0b9";
    }

    public String If1 = mR+compDat3+aiLVL+"-";
    public String I23 = compDat2+compDat1+"-";
    public String In3 = compDat9+compDat8+"-";
    public String nfo = compDat4+compDat5+"-";
    public String fo5 = compDat6+compDat7;
}
