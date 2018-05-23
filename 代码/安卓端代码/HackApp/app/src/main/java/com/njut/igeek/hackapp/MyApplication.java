package com.njut.igeek.hackapp;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.njut.igeek.hackapp.Https.ClearableCookieJar;
import com.njut.igeek.hackapp.Https.PersistentCookieJar;
import com.njut.igeek.hackapp.Https.cache.SetCookieCache;
import com.njut.igeek.hackapp.Https.persistence.SharedPrefsCookiePersistor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MyApplication extends Application {

    public static List<String> sMockAnswer = new ArrayList<>();
    static MyApplication sMyApplication;
    static ClearableCookieJar cookieJar;
    static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        File file = new File("/storage/emulated/0/spoteer/com.njut.igeek.hackapp");
        if (!file.exists()) {
            file.mkdirs();
        }
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(getApplicationContext())
                .setBaseDirectoryPath(new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), "spoteer"))
                .setBaseDirectoryName("com.njut.igeek.hackapp")
                .setMaxCacheSize(200 * 1024 * 1024)//200MB
                .build();
        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();

        Fresco.initialize(this, imagePipelineConfig);


        initMockAnswer();

    }

    private void initMockAnswer() {
        sMockAnswer.add("选择 B 图，表明你心中仍对他存有爱意，甚至你早已后悔了当初同他的分手。如今既然他出现在你面前，说明对方也是心怀旧情，你们重归于好的希望甚大！尽管当初分手，有错的一方在你，但是他仍然如此依恋于你，表明你具有无限魅力，令对方欲罢不能。不过，在今后的岁月里，你就应当小心谨慎，好好珍惜这份重回的爱！");
        sMockAnswer.add("看来，你是准备重新接纳他啦！虽往事不堪回首，但痴情又宽容的你对他的爱依旧很深，而且感动于他的，相信你会好好对待他的！有了前次的教训，你不妨转守为攻，在爱情上积极一点也未尝不可。想必你们的生活会比以前更加如鱼得水，真是可喜可贺！");
        sMockAnswer.add("首先可以肯定的是，你们从前的分手，绝对不是双方都愿意的；或许，没有他的这段日子，只是老天对你们双方的考验而已。现在破镜即将重圆，你们牵手的时间也快了！还有，你的亲友们已听够了你们冗长的爱情秘事，最好还是早择佳期，别在拖拖沓沓的为妙，你不否认吧？");
        sMockAnswer.add("选择小木屋的人：你是一个能忍别人所不能忍的人，宽大的心胸，使你对任何的事物都抱着以和为贵的态度，基本上你就是一个完美的人。");
        sMockAnswer.add("选择宫殿的人：你是一个思路极细的人，对于身边的事物都能有良好的安排，凡事都在你的掌握之中，虽说不上城府极深，但对于复杂的人际关系却能处理得很好，如鱼得水。");
        sMockAnswer.add("选择城堡的人：你可说是本世纪最厉害的人际高手，你比选宫殿的人对事物的观察更敏锐，更能看透人心，在这方面别人总是忘尘莫及，而你也一直以此自豪，乐此不疲。");
        sMockAnswer.add("选择平房住家的人：你是一个生平无大志的人，也没有什么企图心，虽然对周围的感应能力并不差，但你凡事仅抱着一个平常心罢了，这种人最大的好处就是，平凡，没有烦恼压力。");
    }


    public static ClearableCookieJar getCookieJar() {
        if (cookieJar == null)
            return new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
        else
            return cookieJar;
    }


    public static Context getGlobalContext() {
        return context;
    }


    public static MyApplication getInstance() {
        if (sMyApplication == null) {
            sMyApplication = new MyApplication();
        }
        return sMyApplication;
    }
}
