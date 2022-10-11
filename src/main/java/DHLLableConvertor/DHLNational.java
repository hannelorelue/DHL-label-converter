package DHLLableConvertor;
import java.awt.image.BufferedImage;

public class DHLNational extends LabelType {
    BufferedImage bi;
    int biHeight = bi.getHeight();
    Dimensions header = new Dimensions(100, 230, 110, biHeight/2-449);
    Dimensions securityCode = new Dimensions(220, 280, 310 , 366);
    Dimensions addresses = new Dimensions(216, 640, 666 , 940);
    Dimensions trackingNumber = new Dimensions(970, 230, 160 , biHeight/2-449);
    Dimensions barcodes= new Dimensions(1486, 230, 852 , biHeight/2-449);

    public DHLNational(BufferedImage bi) {
        this.bi = bi;
    }
}
