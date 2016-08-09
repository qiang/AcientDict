package com.adorkable.acientdict.network;

/**
 * Created by liuqiang
 * Date: 2016-02-04
 * Time: 11:49
 */
public interface RequestCallback<T> {

    void onSuccess(T data);

    void onError(Exception e);
}
