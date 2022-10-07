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


       // File outputfile = new File("/Users/hanni/Programming/Java/test3/image.png");
        //ImageIO.write(SubImg, "png", outputfile);

        File outputfile = new File("/Users/hanni/Programming/Java/test3/lable.png");
        BufferedImage ni = joinLabel(header, securityCode, addresses, trackingNumber, barcodes);
        ImageIO.write(ni, "png", outputfile);
        // format 62mm x 180mm

        System.out.println("Width: " + bi.getWidth());
        System.out.println("Height: " + bi.getHeight());
        //
    }
    public static BufferedImage joinLabel(BufferedImage header, BufferedImage securityCode, BufferedImage addresses, BufferedImage trackingNumber, BufferedImage barcodes) {
        BufferedImage[] Images  = {header, securityCode, addresses, trackingNumber, barcodes};
        for (int i = 0; i < Images.length; i++) {
            Images[i] = rotate(Images[i], 90);
        }
        int width = 2613;
        int height = 900;
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
//       Color oldColor = g2.getColor();
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, width, height);
  //      g2.setColor(oldColor);
        g2.drawImage(Images[4], null, 0, 0);
//        g2.drawImage(img2, null, img1.getWidth() + offset, 0);
        g2.dispose();
        return newImage;
    }

    public static BufferedImage rotate(BufferedImage bimg, double angle) {
        int w = bimg.getWidth();
        int h = bimg.getHeight();
        BufferedImage rotated = new BufferedImage(h, w, bimg.getType());
        Graphics2D graphic = rotated.createGraphics();
        graphic.translate(-(w - h) / 2, (h - w) / 2);
        graphic.rotate(Math.toRadians(angle), h/2, w/2);
        graphic.drawImage(bimg, null, 0, 0);
        graphic.dispose();
        return rotated;
    }

    // cut image

}