package mylife.is.it.jitpack.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "test")
public class TestBean {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    public int userID;
    private String name;

    public TestBean(String name, String age) {
        this.name = name;
        this.age = age;
    }

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
