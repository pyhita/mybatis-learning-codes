package com.yangtao.plugin;

import com.google.common.base.CaseFormat;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * @Author: kante_yang
 * @Date: 2023/12/20
 */
@Intercepts(
    @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
)
public class CameHumpInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 先执行得到结果，再对结果进行处理
        List<Object> list = (List<Object>) invocation.proceed();
        for (Object object : list) {
            // 如果是map 类型，就对map的key进行转换
            if (object instanceof Map) {
                processMap((Map<String, Object>) object);
            } else {
                break;
            }
        }

        return list;
    }

    private void processMap(Map<String, Object> map) {
        Set<String> keySet = new HashSet<>(map.keySet());

        for (String key : keySet) {
            Object value = map.get(key);
            map.remove(key);
            map.put(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, key), value);
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
