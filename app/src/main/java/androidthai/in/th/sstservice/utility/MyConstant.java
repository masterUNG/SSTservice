package androidthai.in.th.sstservice.utility;

/**
 * Created by masterung on 20/12/2017 AD.
 */

public class MyConstant {

//    About URL
    private String urlPostUserString = "http://androidthai.in.th/sst/addDataMaster.php";
    private String urlGetUserString = "http://androidthai.in.th/sst/getAllDataMaster.php";


    //    About Array
    private String[] userColumnStrings = new String[]{"id", "Name", "User", "Password"};


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
