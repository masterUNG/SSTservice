package androidthai.in.th.sstservice.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidthai.in.th.sstservice.R;

/**
 * Created by masterung on 21/12/2017 AD.
 */

public class FoodAdapter extends BaseAdapter{

    private Context context;
    private String[] iconStrings, nameFoodStrings, priceFoodStrings;

    public FoodAdapter(Context context,
                       String[] iconStrings,
                       String[] nameFoodStrings,
                       String[] priceFoodStrings) {
        this.context = context;
        this.iconStrings = iconStrings;
        this.nameFoodStrings = nameFoodStrings;
        this.priceFoodStrings = priceFoodStrings;
    }

    @Override
    public int getCount() {
        return nameFoodStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.listview_menu_food, viewGroup, false);

//        Initial View
        ImageView imageView = view1.findViewById(R.id.imvIcon);
        TextView nameFoodTextView = view1.findViewById(R.id.txtNameFood);
        TextView priceFoodTextView = view1.findViewById(R.id.txtPriceFood);

//        Show View
        nameFoodTextView.setText("Test");
        priceFoodTextView.setText("Test");

        //Picasso.with(context).load(iconStrings[i]).into(imageView);

        return view1;
    }
}   // Main Class
