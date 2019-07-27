package mylife.is.it.jitpack.utils;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import java.util.concurrent.TimeUnit;

import mylife.is.it.jitpack.work.CustomWorkManager;

public enum WorkUtil {
    INSTANCE;
    private static final String TAG = WorkUtil.class.getName();
    private OneTimeWorkRequest workRequest;

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void creatWork() {
        Uri uri = Uri.parse("");
        Data data = new Data.Builder()
                .putString("key", "value")
                .build();
        Constraints myConstraints = new Constraints.Builder()
                .setRequiresBatteryNotLow(true)//执行任务时电池电量不能偏低
                .setRequiresDeviceIdle(true)//设备空闲时才能执行
                .setRequiresCharging(true)//在设备充电时才能执行任务
                .setRequiresStorageNotLow(true)//设备储存空间足够时才能执行
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)//不需要网络
                .addContentUriTrigger(uri, true)
                .build();

        workRequest = new OneTimeWorkRequest.Builder(CustomWorkManager.class)
                .addTag("tag")//设置tag
                .setInputData(data)
                .setBackoffCriteria(//重试策略
                        BackoffPolicy.LINEAR,
                        OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                        TimeUnit.MILLISECONDS)
                .setInitialDelay(10, TimeUnit.MINUTES)//延迟执行
                .setConstraints(myConstraints).build();


    }


    /**
     * 重复任务
     */
    public void repeatWork() {
        PeriodicWorkRequest.Builder photoWorkBuilder = new PeriodicWorkRequest.Builder(
                CustomWorkManager.class,
                12,
                TimeUnit.HOURS);
        PeriodicWorkRequest photoWork = photoWorkBuilder.build();

    }

    public void orderQueue() {
        //https://developer.android.google.cn/topic/libraries/architecture/workmanager/how-to/chain-work
        WorkManager.getInstance()
                .beginWith(workRequest)
                .then(workRequest)
                .enqueue();

    }

    public void startWork(WorkRequest workRequest, AppCompatActivity activity) {

        WorkManager.getInstance().beginUniqueWork(workRequest.getId().toString(), ExistingWorkPolicy.REPLACE, (OneTimeWorkRequest) workRequest).enqueue();
        WorkManager.getInstance().enqueue(workRequest);
        WorkManager.getInstance().getWorkInfoByIdLiveData(workRequest.getId())
                .observe(activity, workInfo -> {
                    if (workInfo != null && workInfo.getState().isFinished()) {
                        Log.i(TAG, "creatWork: " + workInfo.getState().name());
                    }
                });
    }

    public void cancekWork(WorkRequest request) {
        WorkManager.getInstance().cancelWorkById(request.getId());
        WorkManager.getInstance().cancelAllWork();
    }
}
