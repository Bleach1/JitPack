package mylife.is.it.jitpack.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import mylife.is.it.jitpack.App;

public class TestModel extends AndroidViewModel {
    public TestModel(@NonNull Application application) {
        super(application);

    }

    LiveData liveData = new MutableLiveData<String>();

    public LiveData build = new LivePagedListBuilder(App.getInstance().getDao().getTestList(), new PagedList.Config.Builder()
            .setPageSize(15)
            .setEnablePlaceholders(true)
            .setPrefetchDistance(150)
            .setInitialLoadSizeHint(15)
            .build()).build();
}
