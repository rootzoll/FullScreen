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


public class ScreenUtil extends CordovaPlugin {

    public static final String TAG = "fullScreen Plugin";
    public static final String MyPREFERENCES = "ScreenUtil";
    public static final int FLAG_FULLSCREEN      = 0x00000400;
    public static final int FLAG_KEEP_SCREEN_ON     = 0x00000080;
    public static final int FLAG_FORCE_NOT_FULLSCREEN   = 0x00000800;

    /**
     * Constructor.
     */
    public ScreenUtil() {}

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.v(TAG, "Init ScreenUtil fullsreen plugin");
    }


    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        
        if ("FULL_SCREEN".equals(action)) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                     setPreferences();
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

    public void setPreferences() {
            disableStatusBar();
            disableOnscreenButton();
    }
    
    public void disableTimeOut() {
        cordova.getActivity().getWindow().addFlags(FLAG_KEEP_SCREEN_ON);
    }

    public void disableStatusBar() {
        cordova.getActivity().getWindow().clearFlags(FLAG_FORCE_NOT_FULLSCREEN);
        cordova.getActivity().getWindow().setFlags(FLAG_FULLSCREEN,FLAG_FULLSCREEN); //int flag, int mask
    }
    
    public void disableOnscreenButton() {
        if (Build.VERSION.SDK_INT < 19) { //19 or above api
            View v = cordova.getActivity().getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else {
            //for lower api versions.
            View decorView = cordova.getActivity().getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

}
