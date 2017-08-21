import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import android.util.Log;
import android.provider.Settings;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


public class StayAwake extends CordovaPlugin {

    public static final String TAG = "cordova-android-styawake";
    public static final int FLAG_KEEP_SCREEN_ON     = 0x00000080;

    /**
     * Constructor.
     */
    public StayAwake() {}

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.i(TAG, "Init cordova-android-styawake plugin");
    }

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        
        if ("REACTIVATE_TIMEOUT".equals(action)) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    reactivateTimeOut();
                    callbackContext.success(); // Thread-safe.
                }
            });
            return true;
        }
        else if ("DISABLE_TIMEOUT".equals(action)) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                     disableTimeOut();
                    callbackContext.success(); // Thread-safe.
                }
            });
            return true;
        }
        
        return false;
    }
    
    public void disableTimeOut() {
        Log.i(TAG, "cordova-android-styawake --> disableTimeOut");
        cordova.getActivity().getWindow().addFlags(FLAG_KEEP_SCREEN_ON);
    }

    public void reactivateTimeOut() {
        Log.i(TAG, "cordova-android-styawake --> reactivateTimeOut");
        cordova.getActivity().getWindow().clearFlags(FLAG_KEEP_SCREEN_ON);
    }

}
