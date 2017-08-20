package com.spotinst.sdkjava.client.http;

import org.apache.http.conn.ssl.TrustStrategy;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by ohadmuchnik on 21/08/2016.
 */
public class TrustSelfSignedCertStrategy implements TrustStrategy {

    public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        return true;
    }
}
