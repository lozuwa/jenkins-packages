package com.lozuwa.common.http.client

import com.lozuwa.common.http.dto.RawHttpResponse

import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import java.security.cert.CertificateException
import java.security.cert.X509Certificate

public class RawHttpClient {
    private static final String DEFAULT_TEXT_DECODE = "UTF-8"

    private HttpURLConnection connection
    private String body

    private RawHttpClient(HttpURLConnection connection, String body) {
        this.connection = connection
        this.body = body
    }

    public RawHttpResponse executeRequest() {
        if (body != null) {
            OutputStream os = connection.getOutputStream();
            os.write(body.getBytes(DEFAULT_TEXT_DECODE));
            os.close()
        }
        connection.connect()
        if (connection.getResponseCode()) {
        }
        RawHttpResponse rawHttpResponse = new RawHttpResponse(
                connection.getResponseCode(),
                connection.getResponseMessage(),
                connection.inputStream.getText(DEFAULT_TEXT_DECODE)
        )
        return rawHttpResponse
    }

    public static class Builder {
        private static int DEFAULT_CONNECT_TIMEOUT = 30000
        private static int DEFAULT_READ_TIMEOUT = 30000

        private String url
        private int connectTimeout
        private int readTimeout
        private String verb
        private Map<String, String> headers
        private String body

        public Builder() {
            this.connectTimeout = -1
            this.readTimeout = -1
            this.headers = new HashMap<>()
        }

        public Builder withUrl(String url) {
            this.url = url
            return this
        }

        public Builder withConnectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout
            return this
        }

        public Builder withReadTimeout(int readTimeout) {
            this.readTimeout = readTimeout
            return this
        }

        public Builder withVerb(String verb) {
            this.verb = verb
            return this
        }

        public Builder withBasicAuthorization(String username, String password) {
            String authB64 = "${username}:${password}".bytes.encodeBase64().toString()
            withHeader("Authorization", "Basic ${authB64}")
            return this
        }

        public Builder withTokenAuthorization(String token) {
            withHeader("Authorization", "Token ${token}")
            return this
        }

        public Builder withBearerTokenAuthorization(String token) {
            withHeader("Authorization", "Bearer ${token}")
            return this
        }

        public Builder withHeader(String key, String value) {
            headers.put(key, value)
            return this
        }

        public Builder withJSONBody(String body) {
            withHeader("Content-Type", "application/json")
            this.body = body
            return this
        }

        public RawHttpClient build() {
            HttpURLConnection connection = new URL(url).openConnection()
            connection.setRequestMethod(verb)
            connection.setConnectTimeout(this.connectTimeout == -1 ? DEFAULT_CONNECT_TIMEOUT : this.connectTimeout)
            connection.setReadTimeout(this.readTimeout == -1 ? DEFAULT_READ_TIMEOUT : this.readTimeout)
            connection.setDoOutput(true)
            connection.setDoInput(true)
            for (Map.Entry<String, String> header: headers.entrySet()) {
                connection.setRequestProperty(header.getKey(), header.getValue())
            }
            RawHttpClient rawHttpClient = new RawHttpClient(connection, body)
            return rawHttpClient
        }
    }

    public static void disableSSLCertificateChecking() {
        TrustManager[] trustAllCerts = [ new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                // Not implemented
            }

            @Override
            public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                // Not implemented
            }
        } ]

        try {
            SSLContext sc = SSLContext.getInstance("TLS")
            sc.init(null, trustAllCerts, new java.security.SecureRandom())
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory())
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
