package mylife.is.it.jitpack.room;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TestDao {
    @Query("select * FROM Test")
    DataSource.Factory<Integer, TestBean> getTestList();

    @Insert
    void insertTestList(List<TestBean> beanList);

    @Delete
    void deleteAll(List<TestBean> beanList);
}
