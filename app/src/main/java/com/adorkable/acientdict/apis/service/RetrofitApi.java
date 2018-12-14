package com.adorkable.acientdict.apis.service;

import com.adorkable.acientdict.entity.DictInitEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Author: liuqiang
 * Date: 2018-12-13
 * Time: 18:02
 * Description:
 */
public interface RetrofitApi {

    @GET("/api/init")
    Observable<DictInitEntity> init();
}
