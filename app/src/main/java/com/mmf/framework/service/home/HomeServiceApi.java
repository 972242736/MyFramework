package com.mmf.framework.service.home;

import com.mmf.framework.common.utils.service.Response;
import com.mmf.framework.model.LawyerInfo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by MMF
 * date 2016/9/26
 * Description:
 */
public interface HomeServiceApi {
    @GET("lawyers/city")
    Observable<Response<List<LawyerInfo>>> getLawyer(@Query("dtype") String dtype, @Query("st") int st, @Query("count") int count, @Query("city") String pro, @Query("key") String key);
}
