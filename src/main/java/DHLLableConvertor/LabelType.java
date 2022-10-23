package DHLLableConvertor;

import java.awt.image.BufferedImage;

public class LabelType {
    public Dimensions header, securityCode , addresses, trackingNumber, barcodes;
    public LabelType( Dimensions header, Dimensions securityCode ,Dimensions addresses,Dimensions trackingNumber,Dimensions barcodes) {
        this.header = header;
        this.securityCode = securityCode;
        this.addresses = addresses;
        this.trackingNumber = trackingNumber;
        this.barcodes= barcodes;
    }

    public LabelType() {
    }
}
