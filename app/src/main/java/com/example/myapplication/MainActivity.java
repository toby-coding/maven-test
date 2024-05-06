package com.example.myapplication;

import java.util.List;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

//import com.facebook.react.PackageList;
//import com.facebook.react.ReactInstanceManager;
//import com.facebook.react.ReactPackage;
//import com.facebook.react.ReactRootView;
//import com.facebook.react.common.LifecycleState;
//import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.example.nativelib.CPlusCallToJava;
import com.example.nativelib.NativeLib;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

  private AppBarConfiguration appBarConfiguration;
  private ActivityMainBinding binding;

  private final int OVERLAY_PERMISSION_REQ_CODE = 1;  // 任写一个值

//  private ReactRootView mReactRootView;
//  private ReactInstanceManager mReactInstanceManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityMainBinding.inflate(getLayoutInflater());
//    mReactRootView = new ReactRootView(this);
//    List<ReactPackage> packages = new PackageList(getApplication()).getPackages();
//    // 有一些第三方可能不能自动链接，对于这些包我们可以用下面的方式手动添加进来：
//    // packages.add(new MyReactNativePackage());
//    // 同时需要手动把他们添加到`settings.gradle`和 `app/build.gradle`配置文件中。
//    mReactInstanceManager = ReactInstanceManager.builder()
//        .setApplication(getApplication())
//        .setCurrentActivity(this)
//        .setBundleAssetName("index.android.bundle")
//        .setJSMainModulePath("index")
//        .addPackages(packages)
//        .setUseDeveloperSupport(BuildConfig.DEBUG)
//        .setInitialLifecycleState(LifecycleState.RESUMED)
//        .build();
//    // 注意这里的MyReactNativeApp 必须对应"index.js"中的
//    // "AppRegistry.registerComponent()"的第一个参数
//    mReactRootView.startReactApplication(mReactInstanceManager, "MyReactNativeApp", null);


    setContentView(binding.getRoot());

    setSupportActionBar(binding.toolbar);

    NavController navController =
        Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


    binding.fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        CPlusCallToJava cPlusCallToJava = new CPlusCallToJava(view);
        cPlusCallToJava.testCPlusCallJava1();

//        NativeLib nativeLib = new NativeLib();
//        Snackbar.make(view, nativeLib.stringFromJNI() + cPlusCallToJava.intFromJNI(), Snackbar.LENGTH_LONG)
//            .setAction("Action", null).show();
      }
    });

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      if (!Settings.canDrawOverlays(this)) {
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
            Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
      }
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onSupportNavigateUp() {
    NavController navController =
        Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    return NavigationUI.navigateUp(navController, appBarConfiguration)
        || super.onSupportNavigateUp();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
//    if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
//      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//        if (!Settings.canDrawOverlays(this)) {
//          // SYSTEM_ALERT_WINDOW permission not granted
//        }
//      }
//    }
//     mReactInstanceManager.onActivityResult( this, requestCode, resultCode, data );
  }

  @Override
  protected void onPause() {
    super.onPause();

//    if (mReactInstanceManager != null) {
//      mReactInstanceManager.onHostPause(this);
//    }
  }

  @Override
  protected void onResume() {
    super.onResume();

//    if (mReactInstanceManager != null) {
//      mReactInstanceManager.onHostResume(this, this);
//    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

//    if (mReactInstanceManager != null) {
//      mReactInstanceManager.onHostDestroy(this);
//    }
//    if (mReactRootView != null) {
//      mReactRootView.unmountReactApplication();
//    }
  }

  @Override
  public void onBackPressed() {
//    if (mReactInstanceManager != null) {
//      mReactInstanceManager.onBackPressed();
//      return;
//    }

    super.onBackPressed();
  }

  @Override
  public boolean onKeyUp(int keyCode, KeyEvent event) {
//    if (keyCode == KeyEvent.KEYCODE_MENU && mReactInstanceManager != null) {
//      mReactInstanceManager.showDevOptionsDialog();
//      return true;
//    }
    return super.onKeyUp(keyCode, event);
  }
}