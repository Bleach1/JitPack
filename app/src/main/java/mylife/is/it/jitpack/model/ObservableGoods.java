package mylife.is.it.jitpack.model;

import android.databinding.ObservableField;
import android.databinding.ObservableFloat;

public class ObservableGoods {


    public ObservableField<String> name;
    public ObservableField<String> details;
    public ObservableFloat price;

    public ObservableGoods(String name, String details, float price) {
        this.name = new ObservableField<>(name);
        this.details = new ObservableField<>(details);
        this.price = new ObservableFloat(price);
    }

}
