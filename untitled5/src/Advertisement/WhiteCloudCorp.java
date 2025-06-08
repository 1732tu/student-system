package Advertisement;

public class WhiteCloudCorp implements Advertisement{
    @Override
    public void showAdvertisement() {
        System.out.println("-----------");
        System.out.println("飞机中的战斗机");
        System.out.println("-----------");

    }

    @Override
    public String getCorName() {
        return "白云公司";
    }
}
