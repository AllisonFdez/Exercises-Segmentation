/*
* Wheel Exercise by Allison Fernandez L.
*/

import boofcv.io.image.ConvertBufferedImage;
import boofcv.io.image.UtilImageIO;
import boofcv.struct.image.GrayU8;
import boofcv.alg.filter.binary.BinaryImageOps;
import boofcv.gui.binary.VisualizeBinaryData;
import boofcv.gui.ListDisplayPanel;
import boofcv.gui.image.ShowImages;
import java.awt.image.BufferedImage;

import java.util.*;
import java.io.*;

public class wheelExercise {

    public static void main( String args[] ) {

        String inImg = args[0];
        String outImg = args[1];

        BufferedImage inImage = UtilImageIO.loadImage(inImg);
        GrayU8 inputImg = ConvertBufferedImage.convertFromSingle(inImage, null, GrayU8.class);
        GrayU8 inBinary = new GrayU8(inputImg.width, inputImg.height);

        GrayU8 openingImg = BinaryImageOps.dilate4(inputImg, 2, null);

        BufferedImage visualFiltered = VisualizeBinaryData.renderBinary(inputImg, false, null);
        BufferedImage visualFiltered2 = VisualizeBinaryData.renderBinary(openingImg, false, null);
        
        ListDisplayPanel panel = new ListDisplayPanel();
		//panel.addImage(visualBinary, "Binary Original");
		panel.addImage(visualFiltered, "Binary Filtered");
        panel.addImage(visualFiltered2, "Binary Filtered");
        ShowImages.showWindow(panel, "Binary Operations", true);
    }
} 