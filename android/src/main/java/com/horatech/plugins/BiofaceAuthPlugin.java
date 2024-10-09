package com.horatech.plugins;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.biometric.BiometricPrompt;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "BiofaceAuth")
public class BiofaceAuthPlugin extends Plugin {

    private BiofaceAuth implementation = new BiofaceAuth();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @PluginMethod
    public void authenticate(PluginCall call) {
        implementation.authenticate(getContext(), new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                call.reject("Authentication error: " + errString);
            }

            @Override
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                JSObject ret = new JSObject();
                ret.put("authenticated", true);
                call.resolve(ret);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                call.reject("Authentication failed");
            }
        });
    }
}