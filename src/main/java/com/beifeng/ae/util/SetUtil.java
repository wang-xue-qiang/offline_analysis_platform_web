package com.beifeng.ae.util;

import java.util.Set;

public class SetUtil {
    /**
     * 主要用于判断是否存在<br/>
     * 如果存在，返回true。否则返回false
     * 
     * @param set
     * @param o
     * @return
     */
    public static boolean contains(Set<Object> set, Object o) {
        for (Object object : set) {
            if (object.equals(o)) {
                return true;
            }
            if (object instanceof Set) {
                @SuppressWarnings("unchecked")
                Set<Object> innerSet = (Set<Object>) object;
                for (Object obj : innerSet) {
                    if (obj.equals(o)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
