package DHLLableConvertor;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

public class Label {
    PDDocument pd;
    PDFRenderer pr = new PDFRenderer (pd);
    BufferedImage bi = pr.renderImageWithDPI (0, 300);
    BufferedImage header = bi.getSubimage(100, 230, 110, bi.getHeight()/2-449);
    BufferedImage securityCode = bi.getSubimage(220, 280, 310 , 366);
    BufferedImage addresses = bi.getSubimage(216, 640, 666 , 940);
    BufferedImage trackingNumber = bi.getSubimage(970, 230, 160 , bi.getHeight()/2-449);
    BufferedImage barcodes= bi.getSubimage(1486, 230, 852 , bi.getHeight()/2-449);

    File outputfile = new File("/Users/hanni/Programming/Java/test3/lable.png");
    BufferedImage ni = joinLabel(header, securityCode, addresses, trackingNumber, barcodes);
    ImageIO.write(ni, "png", outputfile);
    // format 62mm x 180mm
    System.out.println("Width: " + bi.getWidth());
    System.out.println("Height: " + bi.getHeight());
    public static BufferedImage joinLabel(BufferedImage header, BufferedImage securityCode, BufferedImage addresses, BufferedImage trackingNumber, BufferedImage barcodes) {
        BufferedImage[] Images  = {header, securityCode, addresses, trackingNumber, barcodes};
        for (int i = 0; i < Images.length; i++) {
            Images[i] = rotate(Images[i], 90);
        }
        int width = 2613;
        int height = 900;
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, width, height);
        g2.drawImage(scale(Images[0], 1300), null, 0, 0);
        g2.drawImage(scale(Images[1], 400), null, 900, 120);
        g2.drawImage(scale(Images[2], 750), null, 0, 120);
        g2.drawImage(scale(Images[3], 1300), null, 0, 695);
        g2.drawImage(Images[4], null, width/2, 0);
        g2.dispose();
        return newImage;
    }

    private static BufferedImage rotate(BufferedImage bimg, double angle) {
        int w = bimg.getWidth();
        int h = bimg.getHeight();
        BufferedImage rotated = new BufferedImage(h, w, bimg.getType());
        Graphics2D graphic = rotated.createGraphics();
        graphic.setPaint(Color.WHITE);
        graphic.translate(-(w - h) / 2, (h - w) / 2);
        graphic.rotate(Math.toRadians(angle), Math.ceil(h/2), Math.ceil(w/2));
        graphic.drawImage(bimg, null, 0, 0);
        graphic.dispose();
        return rotated;
    }

    private static BufferedImage scale(BufferedImage before, int newWidth) {
        int w = before.getWidth();
        int h = before.getHeight();
        int aspectRatio = w/h;
        // Create a new image of the proper size
        int w2 = newWidth;
        int h2 = w2/aspectRatio;
        double scale = (double) w2/w;
        BufferedImage after = new BufferedImage(w2, h2, BufferedImage.TYPE_INT_ARGB);
        AffineTransform scaleInstance = AffineTransform.getScaleInstance(scale, scale);
        AffineTransformOp scaleOp = new AffineTransformOp(scaleInstance, AffineTransformOp.TYPE_BILINEAR);
        Graphics2D g2 = (Graphics2D) after.getGraphics();
        g2.drawImage(before, scaleOp, 0, 0);
        g2.dispose();
        return after;
    }
}
