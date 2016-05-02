package com.adorkable.acientdict.mvp.model.impl;

import com.adorkable.acientdict.apis.ApiConstants;
import com.adorkable.acientdict.apis.ApiResponse;
import com.adorkable.acientdict.entity.DictInitEntity;
import com.adorkable.acientdict.mvp.model.DictInteractor;
import com.adorkable.acientdict.network.GsonRequest;
import com.adorkable.acientdict.util.VolleyHelper;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.reflect.TypeToken;

/**
 * Created by liuqiang
 * Date: 2016-05-02
 * Time: 16:16
 */
public class DictInteractorImpl implements DictInteractor {

    @Override
    public void loadInitData(final OnLoadDataCallback callback) {

        GsonRequest<ApiResponse<DictInitEntity>> gsonRequest = new GsonRequest<>(
                ApiConstants.Urls.DICT_INIT, null,
                new TypeToken<ApiResponse<DictInitEntity>>() {
                }.getType(),
                new Response.Listener<ApiResponse<DictInitEntity>>() {
                    @Override
                    public void onResponse(ApiResponse<DictInitEntity> response) {
                        callback.onLoadSuccess(response.getData());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onLoadFailed();
                    }
                });
        gsonRequest.setShouldCache(true);

        VolleyHelper.getInstance().getRequestQueue().add(gsonRequest);
    }

}
