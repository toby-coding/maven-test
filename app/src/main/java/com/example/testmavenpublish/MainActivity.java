package com.example.testmavenpublish;

import android.os.Bundle;

import com.example.mylibrary.Utils;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.testmavenpublish.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

  private AppBarConfiguration appBarConfiguration;
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

//        mReactRootView = new ReactRootView(this);
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
//    setContentView(binding.getRoot());

    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    setSupportActionBar(binding.toolbar);

    NavController navController =
        Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
    appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

    binding.fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String test = Utils.pinJie("1", 2);
        String message = "12".equals(test) ? "test lib import success" : "test lib import failed";
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            .setAnchorView(R.id.fab)
            .setAction("Action", null).show();
      }
    });
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
}