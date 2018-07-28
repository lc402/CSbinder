package first.liucx.csbinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(MainActivity.this,ServerBinder.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    IServerProxy mMyAidlService;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            Log.e("123", "onServiceDisconnected:" + arg0.getPackageName());
        }
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Log.e("123", "onServiceConnected:" + name.getPackageName());
            // 获取远程Service的onBinder方法返回的对象代理
            String test = "test";
            mMyAidlService = IServerProxy.Stub.asInterface(binder);
            try {
                Log.d("liucx", "basicTypes go to2222");
                if(mMyAidlService != null)
                    mMyAidlService.basicTypes(1,2,false,1,2,test);
                Log.d("liucx", "basicTypes back 22222");
                mMyAidlService.registerCallBack(mIClientProxy);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };

    private IClientProxy mIClientProxy = new IClientProxy.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            Log.d("liucx", "IClientProxy is called");
        }

    };
}
