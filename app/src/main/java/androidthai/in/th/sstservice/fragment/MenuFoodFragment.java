package androidthai.in.th.sstservice.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import androidthai.in.th.sstservice.MainActivity;
import androidthai.in.th.sstservice.R;
import androidthai.in.th.sstservice.utility.FoodAdapter;
import androidthai.in.th.sstservice.utility.GetDataFromServer;
import androidthai.in.th.sstservice.utility.MyConstant;

/**
 * Created by masterung on 21/12/2017 AD.
 */

public class MenuFoodFragment extends Fragment {

    //    Explicit
    private String[] loginStrings;

    public static MenuFoodFragment menuFoodInstance(String[] loginStrings) {

        MenuFoodFragment menuFoodFragment = new MenuFoodFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Login", loginStrings);
        menuFoodFragment.setArguments(bundle);
        return menuFoodFragment;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get Value From Argument
        getValueFromArgument();

//        Create Toolbar
        createToolbar();

//        Create ListView
        createListView();

    }   // Main Method

    private void createListView() {

        ListView listView = getView().findViewById(R.id.listViewFood);
        MyConstant myConstant = new MyConstant();
        String tag = "21DecV1";
        String[] columnStrings = myConstant.getFoodColumnStrings();

        try {

            GetDataFromServer getDataFromServer = new GetDataFromServer(getContext());
            getDataFromServer.execute(myConstant.getUrlGetFoodString());
            String jsonString = getDataFromServer.get();
            Log.d(tag, "JSON ==> " + jsonString);

            JSONArray jsonArray = new JSONArray(jsonString);

            String[] idStrings = new String[jsonArray.length()];
            String[] categoryStrings = new String[jsonArray.length()];
            String[] barcodeStrings = new String[jsonArray.length()];
            String[] qrcodeStrings = new String[jsonArray.length()];
            String[] nameFoodStrings = new String[jsonArray.length()];
            String[] priceStrings = new String[jsonArray.length()];
            String[] detailStrings = new String[jsonArray.length()];
            String[] imagePathStrings = new String[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i += 1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                idStrings[i] = jsonObject.getString(columnStrings[0]);
                categoryStrings[i] = jsonObject.getString(columnStrings[1]);
                barcodeStrings[i] = jsonObject.getString(columnStrings[2]);
                qrcodeStrings[i] = jsonObject.getString(columnStrings[3]);
                nameFoodStrings[i] = jsonObject.getString(columnStrings[4]);
                priceStrings[i] = jsonObject.getString(columnStrings[5]);
                detailStrings[i] = jsonObject.getString(columnStrings[6]);
                imagePathStrings[i] = jsonObject.getString(columnStrings[7]);

            }   //for

            FoodAdapter foodAdapter = new FoodAdapter(getActivity(),
                    imagePathStrings, nameFoodStrings, priceStrings);
            listView.setAdapter(foodAdapter);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void createToolbar() {

        Toolbar toolbar = getView().findViewById(R.id.toolbarMenuFoodFragment);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

//        SetUp Title and SubTitle
        ((MainActivity) getActivity()).getSupportActionBar()
                .setTitle(loginStrings[1]);
        ((MainActivity) getActivity()).getSupportActionBar()
                .setSubtitle("OnLine");


    }

    private void getValueFromArgument() {
        loginStrings = getArguments().getStringArray("Login");
        Log.d("21DecV1", "Name ==> " + loginStrings[1]);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_food, container, false);
        return view;
    }
}   // Main Class
