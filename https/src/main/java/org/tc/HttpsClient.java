package org.tc;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * 请求https, 忽略证书
 */
public class HttpsClient {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        String url = "https://kyfw.12306.cn/otn/";
        try (CloseableHttpClient httpClient = createHttpClient()) {
            HttpGet httpGet = new HttpGet(url);
            try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
                HttpEntity entity = httpResponse.getEntity();
                String result = EntityUtils.toString(entity);
                EntityUtils.consume(entity);

                System.out.printf(result);
            }
        }
    }


    private static CloseableHttpClient createHttpClient() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslcontext = SSLContexts.custom()
                .loadTrustMaterial(null, (chain, authType) -> true)
                .build();

        SSLConnectionSocketFactory sslSf = new SSLConnectionSocketFactory(sslcontext, null, null,
                new NoopHostnameVerifier());

        return HttpClients.custom().setSSLSocketFactory(sslSf).build();
    }
}