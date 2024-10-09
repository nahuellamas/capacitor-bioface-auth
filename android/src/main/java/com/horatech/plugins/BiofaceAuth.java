package com.horatech.plugins;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import java.util.concurrent.Executor;

public class BiofaceAuth {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void authenticate(Context context, BiometricPrompt.AuthenticationCallback callback) {
        Executor executor = ContextCompat.getMainExecutor(context);
        executor.execute(() -> {
            BiometricManager biometricManager = BiometricManager.from(context);

            if (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG) == BiometricManager.BIOMETRIC_SUCCESS) {
                BiometricPrompt biometricPrompt = new BiometricPrompt((androidx.fragment.app.FragmentActivity) context, executor, callback);

                BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                        .setTitle("Biometric login for my app")
                        .setSubtitle("Log in using your biometric credential")
                        .setNegativeButtonText("Cancel")
                        .build();

                biometricPrompt.authenticate(promptInfo);
            } else {
                callback.onAuthenticationError(BiometricPrompt.ERROR_NO_BIOMETRICS, "Biometric authentication not available");
            }
        });
    }
}