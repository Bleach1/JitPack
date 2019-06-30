package mylife.is.it.jitpack.livedata;

import android.arch.lifecycle.LiveData;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

public class NetWorkState extends LiveData<Boolean> {
    private Context context;

    public NetWorkState(Context context) {
        this.context = context;
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            setValue(true);
        }
    };

    @Override
    protected void onActive() {
        super.onActive();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        context.unregisterReceiver(broadcastReceiver);
    }
}
