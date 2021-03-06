package com.mmf.framework.common.utils;



import java.util.List;
import java.util.Map;

/**
 * 集合操作工具类
 *
 */
public class ListUtils {
    private static final String TAG = ListUtils.class.getSimpleName();

    /**
     * 判断List是否为空
     * 
     * @return true表示为空
     */
    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }
        int objectSize = 0;
        if (object instanceof Map<?, ?>) {
            Map<?, ?> objectMap = (Map<?, ?>) object;
            objectSize = objectMap.size();
        } else if (object instanceof List<?>) {
            List<?> objectList = (List<?>) object;
            objectSize = objectList.size();
        }

        if (objectSize == 0)
            return true;
        else
            return false;
    }

    /**
     * 集合设为NULL
     * 
     */
    public static void setEmpty(Object object) {
        if (object == null) {
            return;
        }
        if (object instanceof Map<?, ?>) {
            Map<?, ?> objectMap = (Map<?, ?>) object;
            objectMap.clear();
            objectMap = null;
        } else if (object instanceof List<?>) {
            List<?> objectList = (List<?>) object;
            objectList.clear();
            objectList = null;
        }

        object = null;
    }
}
