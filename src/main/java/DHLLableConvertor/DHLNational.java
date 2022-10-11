package DHLLableConvertor;
import java.awt.image.BufferedImage;

public class DHLNational extends LabelType {
    BufferedImage bi;
    Dimensions header, securityCode , addresses, trackingNumber, barcodes;

    public DHLNational(BufferedImage bi) {
        this.bi = bi;
        int biHeight = bi.getHeight();
        this.header = new Dimensions(100, 230, 110, biHeight/2-449);
        this.securityCode = new Dimensions(220, 280, 310 , 366);
        this.addresses = new Dimensions(216, 640, 666 , 940);
        this.trackingNumber = new Dimensions(970, 230, 160 , biHeight/2-449);
        this.barcodes= new Dimensions(1486, 230, 852 , biHeight/2-449);
    }
}
