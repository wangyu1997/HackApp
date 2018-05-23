package com.njut.igeek.hackapp.Https;


import com.njut.igeek.hackapp.Model.PicModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by wangyu on 06/05/2017.
 */

public interface APIService {


    @FormUrlEncoded
    @POST("https://www.33iq.com/quiz/quizload")
    Observable<String> getQuize(@Query("q_id") String qId, @Field("question") String questionId,
                                @Field("subquestion") String subquestionId);


    @GET("http://115.159.24.156:8989/pic")
    Observable<PicModel> getPics();

//    @FormUrlEncoded
//    @POST("admin/Span/setSpan")
//    Observable<HttpModel<String>> setTag(@Field("img_id") String img_id, @Field("cat_list") String cat_list);
//
//

}
