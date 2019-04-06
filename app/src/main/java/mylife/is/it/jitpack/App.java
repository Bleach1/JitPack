package mylife.is.it.jitpack;

import android.app.Application;
import android.content.Context;

import mylife.is.it.jitpack.room.TestDB;
import mylife.is.it.jitpack.room.TestDao;

public class App extends Application {

    protected static App instance;
    protected static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = this;
    }

    public static App getInstance() {
        return instance;
    }

    public TestDao getDao() {
        return TestDB.getDatabase(this).getTestEntityDao();
    }
}
