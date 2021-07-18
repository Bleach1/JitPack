package mylife.is.it.jitpack.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * 设备上版本1，要安装的3
 * Room先判断1-3的升级方案
 * else Migration(1,2) Migration(2,3)
 * exportSchema 导出履历
 * <p>
 * <p>
 * 修改字段类型  销毁重建策略
 *
 *                 1.创建临时表A_temp
 *                 2.将表A的数据插入到表A_temp
 *                 3.删除A
 *                 4.将A_temp重命名位A
 */
@Database(entities = {TestBean.class}, version = 1, exportSchema = false)
public abstract class TestDB extends RoomDatabase {
    private static TestDB sInstance;

    public static synchronized TestDB getDatabase(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), TestDB.class,
                    "test.db")
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                    .fallbackToDestructiveMigration()//出现异常，重建数据表  数据丢失
                    //.allowMainThreadQueries()//一定要在主线程中使用
                   // .createFromAsset("")
                    .build();
        }
        return sInstance;
    }

    public static void onDestroy() {
        sInstance = null;
    }

    public abstract TestDao getTestEntityDao();

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE student ADD COLUMN sex");
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE student ADD COLUMN sex");
        }
    };

}
