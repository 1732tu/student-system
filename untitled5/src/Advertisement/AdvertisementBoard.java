package Advertisement;

public class AdvertisementBoard {
    Advertisement adver;

    public void setAdver(Advertisement adver) {
        this.adver = adver;
    }
    public void show(){
        if(adver==null){
            System.out.println("广告招商");
        }else{
            adver.showAdvertisement();
        }
    }
}
