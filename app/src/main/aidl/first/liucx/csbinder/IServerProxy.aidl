// IServerProxy.aidl
package first.liucx.csbinder;
//import first.liucx.csbinder.IClietProxy;
// Declare any non-default types here with import statements

import first.liucx.csbinder.IClientProxy;

interface IServerProxy {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    void registerCallBack(IClientProxy cb);
    void unregisterCallBack(IClientProxy cb);
}
