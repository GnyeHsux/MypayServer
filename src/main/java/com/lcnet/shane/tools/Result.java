package com.lcnet.shane.tools;

import com.google.gson.Gson;

/**
 * Created by xushaoyin on 2017/2/16.
 */
public class Result<D> {
    private static final Gson sGson = new Gson();

    private int code;
    private String msg;
    private D date;

    private String toJson(){
        return sGson.toJson(this);
    }

    public static <D> String create(int code, String msg, D data){
        Result<D> result = new Result<>();
        result.code = code;
        result.msg = msg;
        result.date = data;
        return result.toJson();
    }
}
