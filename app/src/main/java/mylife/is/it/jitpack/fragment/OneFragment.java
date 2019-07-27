package mylife.is.it.jitpack.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.navigation.Navigation;

import java.util.Random;

import mylife.is.it.jitpack.BR;
import mylife.is.it.jitpack.adapter.CustomBindingAdapter;
import mylife.is.it.jitpack.base.BaseFragment;
import mylife.is.it.jitpack.R;
import mylife.is.it.jitpack.model.BaseObservableGoods;
import mylife.is.it.jitpack.model.ObservableGoods;
import mylife.is.it.jitpack.model.OneBean;

public class OneFragment extends BaseFragment {


    private BaseObservableGoods goods;
    private ObservableGoods goods1;

    public static OneFragment newInstance(String param1, String param2) {
        OneFragment fragment = new OneFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initData() {
        dataBinding.setVariable(BR.oneUser, new OneBean("LJN", 28, "Bleach"));
        goods = new BaseObservableGoods("辣条", "嘎嘎辣辣", 20);
        goods1 = new ObservableGoods("鸡爪子", "四川", 15);
        dataBinding.setVariable(BR.adapter, new CustomBindingAdapter());
        dataBinding.setVariable(BR.Goods, goods);
        dataBinding.setVariable(BR.goodsHandler, new GoodsHandler());
        dataBinding.setVariable(BR.observableGoods, goods1);
        dataBinding.setVariable(BR.click, (View.OnClickListener) v -> Navigation.findNavController(v).navigate(R.id.action_oneFragment_to_fourFragment));
    }

    public class GoodsHandler {

        public void changeGoodsName() {
            goods.setName("code" + new Random().nextInt(100));
            goods.setPrice(new Random().nextInt(100));
        }

        public void changeGoodsDetails() {
            goods.setDetails("hi" + new Random().nextInt(100));
            goods.setPrice(new Random().nextInt(100));
        }

    }

}
