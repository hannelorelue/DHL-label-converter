package DHLLableConvertor;

public class DHLInternational extends LabelType {
    public Dimensions header, securityCode , addresses, trackingNumber, barcodes;

    private static Dimensions initHeader(){
        return new Dimensions(100, 230, 110, 3506/2-449);
    }
    private static Dimensions initSecurityCode(){
        return new Dimensions(220, 280, 310 , 366);
    }
    private static Dimensions initAddresses(){
        return new Dimensions(216, 640, 666 , 940);
    }

    private static Dimensions initTrackingNumber(){
        return new Dimensions(970, 230, 160 , 3506/2-449);
    }
    private static Dimensions initBarcodes(){
        return new Dimensions(1486, 230, 930 , 3506/2-449);
    }

    public DHLInternational() {
        super(initHeader(), initSecurityCode(), initAddresses(), initTrackingNumber(), initBarcodes());
    }
}

