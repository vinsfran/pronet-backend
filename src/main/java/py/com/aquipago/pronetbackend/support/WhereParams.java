package py.com.aquipago.pronetbackend.support;



import py.com.aquipago.pronetbackend.utils.StringUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vinsfran on 09/06/2019.
 */
public class WhereParams {
    Map<String, Object> params = new HashMap<String, Object>();

    public WhereParams() {
    }


    public String filter(String sqlFilter, Object paramValue) {
        if (paramValue == null || !StringUtil.hasText(String.valueOf(paramValue))) return "";
        String paramName = extractParamName(sqlFilter);
        params.put(paramName, paramValue);
        return sqlFilter;
    }

    public String filterDate(String sqlFilter, Object paramValue) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String paramName = extractParamName(sqlFilter);
        if (paramValue != null) {
            params.put(paramName, sdf.format(paramValue));
            return sqlFilter;
        } else
            return "";
    }


    private String extractParamName(String sqlFilter) {
        int idx = sqlFilter.indexOf(':');

        if (idx < 0) throw new ParamNameNotFound(sqlFilter);
        int idx2 = StringUtil.firstIdx(sqlFilter, idx, " ", ")", "\n", "\t");
        if (idx2 < 0) idx2 = sqlFilter.length();
        return sqlFilter.substring(idx + 1, idx2);
    }

    public Map<String, Object> getParams() {
        return params;
    }


    public static class ParamNameNotFound extends IllegalArgumentException {
        public ParamNameNotFound(String sqlFilter) {
            super("No se pudo encontrar parametro con prefido ':' " + sqlFilter);
        }
    }
}