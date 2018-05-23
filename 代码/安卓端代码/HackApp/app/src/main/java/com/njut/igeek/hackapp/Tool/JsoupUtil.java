package com.njut.igeek.hackapp.Tool;

import android.util.Log;

import com.njut.igeek.hackapp.Model.QuestionModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupUtil {
    private static final String TAG = "JsoupUtil";

    public static QuestionModel generate(String html) {
        QuestionModel model = new QuestionModel();
        Document document = Jsoup.parse(html);
        Log.d(TAG, "generate: " + document.html());

        Elements cap = document.select("div[class=controls word-wrap] > p");
        Log.d(TAG, "generate: " + cap.size());
        if (cap.size() > 0) {
            Element titleElement = cap.get(0);
            String title = titleElement.text();
            Log.d(TAG, "generate: " + title);
            model.setQuestion(title);

            Element imgUrlElement = cap.get(1)
                    .select("img")
                    .first();
            String imgUrl = imgUrlElement.absUrl("src");
            Log.d(TAG, "generate: " + imgUrl);
            model.setImgUrl(imgUrl);

            Elements elements = document.select("div[class=answeroption btn btn-choose-quiz \tbtn-choose-single]");
            String qa = elements.get(0).text();
            String qb = elements.get(1).text();
            String qc = elements.get(2).text();
            String qd = elements.get(3).text();

            Log.d(TAG, "generate: " + qa + "\n" + qb + "\n" + qc + "\n" + qd);
            model.setqA(qa);
            model.setqB(qb);
            model.setqC(qc);
            model.setqD(qd);

        }


        return model;
    }
}
