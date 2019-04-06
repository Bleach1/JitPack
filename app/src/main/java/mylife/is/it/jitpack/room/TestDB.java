package mylife.is.it.jitpack.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {TestBean.class}, version = 1, exportSchema = false)
public abstract class TestDB extends RoomDatabase {
    private static TestDB sInstance;

    public static TestDB getDatabase(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), TestDB.class,
                    "test.db").build();
        }
        return sInstance;
    }

    public static void onDestroy() {
        sInstance = null;
    }

    public abstract TestDao getTestEntityDao();
}
