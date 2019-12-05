package org.tc;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * 请求https, 带证书
 */
@SuppressWarnings("deprecation")
public class CaHttps extends DefaultHttpClient {
    public final static String HTTPGET = "GET";

    public final static String HTTPPUT = "PUT";

    public final static String HTTPPOST = "POST";

    public final static String HTTPDELETE = "DELETE";

    public final static String HTTPACCEPT = "Accept";

    public final static String CONTENT_LENGTH = "Content-Length";
    public final static String CHARSET_UTF8 = "UTF-8";
    private static HttpClient httpClient;
    private static CaHttps caHttps;


    public static CaHttps getInstance() {
        if (caHttps == null) {
            synchronized (CaHttps.class) {
                if (caHttps == null) {
                    caHttps = new CaHttps();
                }
            }
        }
        return caHttps;
    }

    private void initSSLConfig() throws IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException,
            CertificateException, UnrecoverableKeyException {
        // 1 Import your own certificate
        ApplicationContext appContext = new ClassPathXmlApplicationContext();

        Resource selfcertResource = appContext.getResource("classpath:" + "SELFCERTPATH");  // 本系统证书
        Resource trustcaResource = appContext.getResource("classpath:" + "TRUSTCAPATH");    // 服务端证书

        InputStream selfcertIn = selfcertResource.getInputStream();
        InputStream trustcaIn = trustcaResource.getInputStream();

        KeyStore selfCert = KeyStore.getInstance("pkcs12"); // 证书后缀
        selfCert.load(selfcertIn,
                Constant.SELFCERTPWD.toCharArray());
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("sunx509");
        kmf.init(selfCert, Constant.SELFCERTPWD.toCharArray());

        // 2 Import the CA certificate of the server,
        KeyStore caCert = KeyStore.getInstance("jks"); // 证书后缀
        caCert.load(trustcaIn, Constant.TRUSTCAPWD.toCharArray());
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("sunx509");
        tmf.init(caCert);

        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        // 3 Set the domain name to not verify
        SSLSocketFactory ssf = new SSLSocketFactory(sc,
                SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

        // If the platform has already applied for a domain name which matches
        // the domain name in the certificate information, the certificate
        // domain name check can be enabled (open by default)

        ClientConnectionManager ccm = this.getConnectionManager();
        SchemeRegistry sr = ccm.getSchemeRegistry();
        sr.register(new Scheme("https", 8743, ssf));

        httpClient = new DefaultHttpClient(ccm);
    }


}
