package com.adorkable.acientdict.apis;

/**
 * Created by liuqiang
 * Date: 2016-02-04
 * Time: 11:49
 */
public interface ResponseListener<T> {

    public void onSuccess(T response);

    public void onError(Exception e);
}
