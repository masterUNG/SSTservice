package androidthai.in.th.sstservice.utility;

/**
 * Created by masterung on 20/12/2017 AD.
 */

public class MyConstant {

    //    About URL
    private String urlPostUserString = "http://androidthai.in.th/sst/addDataMaster.php";
    private String urlGetUserString = "http://androidthai.in.th/sst/getAllDataMaster.php";
    private String urlGetFoodString = "http://androidthai.in.th/sst/getAllFoodMaster.php";


    //    About Array
    private String[] userColumnStrings = new String[]{
            "id",
            "Name",
            "User",
            "Password"};

    private String[] foodColumnStrings = new String[]{
            "id",
            "Category",
            "BarCode",
            "QRcode",
            "NameFood",
            "Price",
            "Detail",
            "ImagePath"};


    public String[] getFoodColumnStrings() {
        return foodColumnStrings;
    }

    public String getUrlGetFoodString() {
        return urlGetFoodString;
    }

    public String[] getUserColumnStrings() {
        return userColumnStrings;
    }

    public String getUrlGetUserString() {
        return urlGetUserString;
    }

    public String getUrlPostUserString() {
        return urlPostUserString;
    }
}   // Main Class
