# maven-test
The purpose of this project is to test the use of Android aar

1. you should checkout to branch of maven-publish to pulish you aar named 
   android-lib-test to local maven
2. then you should checkout to branch of maven-publish
2. add dependence in build.gradle： implementation "com.lib.native:native-lib-test:0.1.1" 
   implementation "com. lib. android:android-lib-test:0.1.1" 
2. Gradle Sync ,you can find aar named android-lib-test in External Libraries
3. you can use features in aar named android-lib-test
