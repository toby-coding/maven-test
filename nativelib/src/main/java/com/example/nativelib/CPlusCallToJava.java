package com.example.nativelib;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.UiThread;

import com.example.mylibrary.Utils;
import com.google.android.material.snackbar.Snackbar;

public class CPlusCallToJava {

  static {
    System.loadLibrary("nativelib");
  }

  View mView;
  public  CPlusCallToJava(View view) {
    mView = view;

  }

  public native int intFromJNI();
  public native void testVoidMethod();
  public native int testCPlusCallJava1();

  public void showCPlusMessage(String message) {
    Snackbar.make(mView, Utils.pinJie(message, intFromJNI()), Snackbar.LENGTH_LONG)
        .setAction("Action", null).show();
    testVoidMethod();
  }

  public void testVoidMethod(String message) {
    new Handler().postDelayed(() -> Snackbar.make(mView, message + intFromJNI(), Snackbar.LENGTH_LONG)
        .setAction("Action", null).show(), 5000);

  }
}
