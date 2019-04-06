package mylife.is.it.jitpack.resource;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import mylife.is.it.jitpack.room.TestBean;

public class ItemDataSourceFactory extends DataSource.Factory<Integer, TestBean> {

    public MutableLiveData mutableLiveData = new MutableLiveData();

    @Override
    public DataSource<Integer, TestBean> create() {
        ItemDataResource resource = new ItemDataResource();
        mutableLiveData.postValue(resource);
        return resource;
    }
}
