package mylife.is.it.jitpack.work;

import android.content.Context;
import android.support.annotation.NonNull;

import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * 1.非及时任务
 * 2.任务一定执行
 */
public class CustomWorkManager extends Worker {
    public CustomWorkManager(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        String key = getInputData().getString("key");
        Data outputData = new Data.Builder()
                .putString("", key)
                .build();
        //return Result.success();
        return Result.success(outputData);
    }

}
