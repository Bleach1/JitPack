package mylife.is.it.jitpack.resource;

import android.arch.paging.ItemKeyedDataSource;
import android.support.annotation.NonNull;

import mylife.is.it.jitpack.room.TestBean;

public class ItemDataResource extends ItemKeyedDataSource<Integer, TestBean> {
    /**
     * 初始化时的加载
     */
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<TestBean> callback) {
        //callback.onResult();
    }
    /**
     * 加载更多
     */
    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<TestBean> callback) {

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<TestBean> callback) {

    }

    @NonNull
    @Override
    public Integer getKey(@NonNull TestBean item) {
        return item.userID;
    }
}
