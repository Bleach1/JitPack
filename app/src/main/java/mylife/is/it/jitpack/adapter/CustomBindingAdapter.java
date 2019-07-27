package mylife.is.it.jitpack.adapter;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

public class CustomBindingAdapter {

    @BindingAdapter({"url"})
    public static void loadImage(ImageView view, String url) {
        Log.e("ljn", "loadImage url : " + url);
    }

    @BindingAdapter("android:text")
    public static void setText(Button view, String text) {
        view.setText(text + "-Button");
    }


}
