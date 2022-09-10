package com.lozuwa.common.http.utils

class URLUtils {

    public static String buildUrl(String baseUrl, String complement, Map<String, String> queryParams) {
        String url = baseUrl + (complement ? complement : "")
        int queryParamsSize = 0
        if (queryParams != null && queryParams.size() > 0) {
            url += "?"
            queryParamsSize = queryParams.size()
            for (Map.Entry<String, String> queryParam: queryParams.entrySet()) {
                url += queryParam.getKey() + "=" + queryParam.getValue()
                queryParamsSize--
                if (queryParams.size() > 0) {
                    url += "&"
                }
            }
        }
        return url
    }
}
