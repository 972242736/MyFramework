package com.mmf.framework.service.home;

import com.mmf.framework.common.utils.service.RetrofitUtil;
import com.mmf.framework.model.LawyerInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by MMF
 * date 2016/9/26
 * Description:
 */
public class HomeService extends RetrofitUtil {
    private static HomeServiceApi homeService;
    public static HomeServiceApi getService() {
        if (homeService == null) {
            homeService = getRetrofit().create(HomeServiceApi.class);
        }
        return homeService;
    }
    public Observable<List<LawyerInfo>> getLawyer() {
        return getService().getLawyer("json", 0, 10, "福州", "6f940a4a81649f3b6d30e47cdd37a5ad")
                .compose(this.<List<LawyerInfo>>applySchedulers());
    }

}
