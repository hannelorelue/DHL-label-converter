package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.awt.image.BufferedImage;
import org.apache.pdfbox.rendering.*;
import javax.imageio.*;
//import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("/Users/hanni/Downloads/DHL-Paketmarke_F34WAFNXQD9A_1_iFixit_GmbH__.pdf");
        PDDocument pd = PDDocument.load(file);
        PDFRenderer pr = new PDFRenderer (pd);
        BufferedImage bi = pr.renderImageWithDPI (0, 300);
        BufferedImage SubImg = bi.getSubimage(0, 230, bi.getWidth() , bi.getHeight()/2-450);

        BufferedImage header = bi.getSubimage(100, 230, 110, bi.getHeight()/2-450);
        BufferedImage securityCode = bi.getSubimage(220, 280, 315 , 365);
        BufferedImage addresses = bi.getSubimage(215, 640, 665 , 940);
        BufferedImage trackingNumber = bi.getSubimage(970, 230, 160 , bi.getHeight()/2-450);
        BufferedImage barcodes= bi.getSubimage(1485, 230, 850 , bi.getHeight()/2-450);

        File outputfile = new File("/Users/hanni/Programming/Java/test3/image.png");
        ImageIO.write(SubImg, "png", outputfile);
        // format 62mm x 180mm

        System.out.println("Width: " + bi.getWidth());
        System.out.println("Height: " + bi.getHeight());
        //
    }
    public static BufferedImage joinLabel(BufferedImage header, BufferedImage securityCode, BufferedImage addresses, BufferedImage trackingNumber, BufferedImage barcodes) {
        BufferedImage[] Images  = {header, securityCode, addresses, trackingNumber, barcodes};
        for (int i = 0; i < Images.length; i++) {

        }
//        int offset = 2;
//        int width = img1.getWidth() + img2.getWidth() + offset;
//        int height = Math.max(img1.getHeight(), img2.getHeight()) + offset;
        BufferedImage newImage = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g2 = newImage.createGraphics();
//        Color oldColor = g2.getColor();
//        g2.setPaint(Color.WHITE);
//        g2.fillRect(0, 0, width, height);
//        g2.setColor(oldColor);
//        g2.drawImage(img1, null, 0, 0);
//        g2.drawImage(img2, null, img1.getWidth() + offset, 0);
//        g2.dispose();
        return newImage;
    }

    // cut image

}