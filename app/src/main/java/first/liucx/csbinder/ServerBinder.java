package first.liucx.csbinder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * Created by liucx on 2018/7/28.
 */

public class ServerBinder extends Service {

    public ServerBinder() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    IServerProxy.Stub mBinder = new IServerProxy.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
                               double aDouble, String aString) {
            Log.d("liucx", "ServerBinder basic types is call");
            Log.d("liucx",
                    "anint: " + anInt + "\n" +
                            "Along: " + aLong + "\n" +
                            "aBoolean: " + aBoolean + "\n" +
                            "aFloat: " + aFloat + "\n" +
                            "aDouble: " + aDouble + "\n" +
                            "aString: " + aString + "\n");

        }

        @Override
        public void registerCallBack(IClientProxy cb) throws RemoteException {
            Log.d("liucx","registerCallBack");
            cb.basicTypes(1,2,false,4,5,"6");
        }

        @Override
        public void unregisterCallBack(IClientProxy cb) throws RemoteException {

        }

        /*@Override
        public void test() throws RemoteException {

        }*/
    };
}
