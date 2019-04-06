package mylife.is.it.jitpack;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import mylife.is.it.jitpack.room.TestBean;
import mylife.is.it.jitpack.room.TestDao;

/**
 * - @Description:  JitPack 应用项目
 * - @Author:  Bleach
 * - @Time:  2019/4/5 12:51
 */
public class MainActivity extends AppCompatActivity {
    private List<TestBean> testBeans = new ArrayList<>();
    private TestDao testDao;
    private static final String TAG = "ljn";
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavController navController = Navigation.findNavController(this, R.id.container);
        navigationView = findViewById(R.id.bottom_navigation);
        NavigationUI.setupWithNavController(navigationView, navController);
        for (int i = 0; i < 100; i++) {
            testBeans.add(i, new TestBean("name" + i, "age" + i));
        }
        testDao = App.getInstance().getDao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                testDao.insertTestList(testBeans);
            }
        }).start();

        Log.i(TAG, "onCreate: ss");
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.container).navigateUp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        new Thread(new Runnable() {
            @Override
            public void run() {
                testDao.deleteAll(testBeans);
            }
        }).start();

    }
}

