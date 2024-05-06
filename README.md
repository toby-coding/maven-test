# maven-test
The purpose of this project is to test the release of Android arr to local, 
including libnativelib.so, jni calls

AndroidStudio Version: Android Studio Hedgehog | 2023.1.1 Patch 1
JDK Version: 17
NDK Version: 25.1.8937393
Gradle Version: 8.3
AGP: 8.1.1

Test Step:
1. Gradle->My Application/myLibrary/Tasks/publishing/publishToMavenLocal && My 
   Application/nativelib/Tasks/publishing/publishToMavenLocal
2. publishTomavenLocal
3. You can find aar in YOUR_LOCAL_MAVEN_DIR/com/lib/android/android-lib-test/0.1.1 && 
   YOUR_LOCAL_MAVEN_DIR/com/lib/native/native-lib-test/0.1.1

Test use of arr you can checkout to branch of maven-import

 