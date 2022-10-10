package DHLLableConvertor;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.awt.image.BufferedImage;
import org.apache.pdfbox.rendering.*;
import javax.imageio.*;
//import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) throws IOException {
// TODO add user prompt
        File file = new File("/Users/hanni/Downloads/DHL-Paketmarke_F34WAFNXQD9A_1_iFixit_GmbH__.pdf");
        PDDocument pd = PDDocument.load(file);
        Label.createLabel(pd);
    }

}