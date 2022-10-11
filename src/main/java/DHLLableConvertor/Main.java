package DHLLableConvertor;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import org.apache.pdfbox.rendering.*;
import javax.imageio.*;
//import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) throws IOException {
// TODO add user prompt
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter path of the DHLlabel pdf: ");

        String filePath = userInput.nextLine();
      //  File file = new File("/Users/hanni/Downloads/DHL-Paketmarke_F34WAFNXQD9A_1_iFixit_GmbH__.pdf");
        File file = new File(filePath);
        PDDocument pd = PDDocument.load(file);
        Label.createLabel(pd, "DHLNational");
    }

}