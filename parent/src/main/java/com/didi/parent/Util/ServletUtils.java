package com.didi.parent.Util;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName ServletUtils
 * @Author zhangxinkun
 * @Date 2020/1/19  5:55 PM
 * @Version 1.0
 */
public class ServletUtils {
    private static final Set<String> IGNORED_HEADERS = Sets.newHashSet("accept","accept-charset","connection","content-length","content-type","host","user-agent");

    private static final String            AM_PREFIX = "am-";

    public static Map<String,String> getHeaderKV(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String,String> kvMap = Maps.newHashMap();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                if (!IGNORED_HEADERS.contains(name.toLowerCase()))
                    kvMap.put(StringUtils.removeStart(name,AM_PREFIX),request.getHeader(name));
            }
        }
        return kvMap;
    }

    public static Map<String,String> getHeaderKV(HttpHeaders httpHeaders){
        Map<String,String> map = Maps.newHashMap();
        if (httpHeaders == null){
            return map;
        }
        httpHeaders.entrySet().stream().filter(header -> !IGNORED_HEADERS.contains(header.getKey().toLowerCase())).forEach(item -> {
            map.put(StringUtils.removeStart(item.getKey(),AM_PREFIX),item.getValue().get(0));
        });
        return map;
    }
}
