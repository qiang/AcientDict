# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/liuqiang/Development/android-sdk-macosx/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}


#-ignorewarnings                     # 忽略警告，避免打包时某些警告出现
-optimizationpasses 5               # 指定代码的压缩级别
-dontusemixedcaseclassnames         # 是否使用大小写混合 混淆时不会产生形形色色的类名
-dontskipnonpubliclibraryclasses    # 是否混淆第三方jar
-dontpreverify                      # 混淆时是否做预校验
-verbose                            # 混淆时是否记录日志
-dontoptimize                       # 不优化输入的类文件

-keepattributes *Annotation*, SourceFile, InnerClasses, LineNumberTable, Signature, EnclosingMethod
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*    #优化 混淆时采用的算法

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.app.View
-keep public class * extends android.app.IntentService
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.hardware.display.DisplayManager
-keep public class * extends android.os.UserManager
-keep public class com.android.vending.licensing.ILicensingService
-keep public class * extends android.app.Fragment

-keep public class * extends android.support.v4.widget
-keep public class * extends android.support.v4.**    #
-keep interface android.support.v4.app.** { *; }    #
-keep class android.support.v4.** { *; }        #
-keep class android.os.**{*;}

-keep class **.R$* { *; }
-keep class **.R{ *; }

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclasseswithmembers class * {
  public <init>(android.content.Context, android.util.AttributeSet, int, int);
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepclassmembers class * extends android.content.Context {
  public void *(android.view.View);
  public void *(android.view.MenuItem);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Explicitly preserve all serialization members. The Serializable interface
# is only a marker interface, so it wouldn't save them.
-keepnames class * implements java.io.Serializable

-keepclassmembers class * implements java.io.Serializable {
  static final long serialVersionUID;
  private static final java.io.ObjectStreamField[] serialPersistentFields;
  private void writeObject(java.io.ObjectOutputStream);
  private void readObject(java.io.ObjectInputStream);
  java.lang.Object writeReplace();
  java.lang.Object readResolve();
}

#-libraryjars   libs/*.jar   #缺省proguard 会检查每一个引用是否正确，但是第三方库里面往往有些不会用到的类，没有正确引用。如果不配置的话，系统就会报错。
-dontwarn android.support.v4.**
-dontwarn android.os.**

##############################--------以上是Android基本配置----------##############################

# 实体类不混淆（自己项目实体类不被混淆，因为Gson中用到了反射）
-keep class com.adorkable.acientdict.entity.** { *; }

## for sharedSDK
#-keep class android.net.http.SslError
#-keep class android.webkit.**{*;}
#-keep class cn.sharesdk.**{*;}
#-keep class com.sina.**{*;}
#-keep class m.framework.**{*;}
#
## for Gson
-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }
-keep class com.idea.fifaalarmclock.entity.***
-keep class com.google.gson.stream.** { *; }

-keepclassmembers class * {
   public <init>(org.json.JSONObject);
}

#-assumenosideeffects class android.util.Log {
#        public static *** d(...);
#        public static *** e(...);
#        public static *** i(...);
#        public static *** v(...);
#        public static *** println(...);
#        public static *** w(...);
#        public static *** wtf(...);
#}

-keep class android.support.v8.renderscript.** { *; }

#微信
-keep class com.tencent.mm.sdk.** {
   *;
}

# roundedimageview
-keep class com.makeramen.** { *; }
-dontwarn com.makeramen.**

# FaceBook 的图片加载库
-dontwarn com.facebook.**

