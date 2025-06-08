package Advertisement;

public class BlackLandCorp implements Advertisement{

    @Override
    public void showAdvertisement() {
        System.out.println("劳动是爹，土地是妈");
    }

    @Override
    public String getCorName() {
        return "黑土地公司";
    }
}

