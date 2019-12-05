package org.tc;


import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 请求https, 忽略证书
 */
public class HttpsUrlConn {


    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, IOException {

        String url = "https://kyfw.12306.cn/otn/";

        SSLContext sc = createSslContext();
        HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
        conn.setSSLSocketFactory(sc.getSocketFactory());
        conn.setHostnameVerifier((s, sslSession) -> true);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.connect();
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while (null != (line = br.readLine())) {
                result.append(line).append("\n");
            }
        }
        conn.disconnect();

        System.out.printf(result.toString());
    }

    private static SSLContext createSslContext() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("SSL");

        sc.init(null, new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }}, new java.security.SecureRandom());

        return sc;
    }
}
