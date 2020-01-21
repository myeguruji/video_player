package io.flutter.plugins.tokensdk;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * Created by ${Vijay.K.Arora} on 7/22/17.
 */

public class TokenController extends TokenGenerator
{
    private static final TokenController ourInstance = new TokenController();

    private String ssoToken;
    private String sid;
    private String tokenId;
    private int expireTime = 900;
    private boolean hasEncryption;
    private String cookie;
    private String jioCdnCheck;

    public static TokenController getInstance()
    {
        return ourInstance;
    }

    private TokenController()
    {

    }

    public String getEncryptedUrl(String url)
    {
        return getUrl(url, ssoToken, tokenId, expireTime);
    }

    public String getEncryptedHashUrl(String url)
    {
        return getUrlWithHash(url, ssoToken, tokenId, expireTime);
    }

    public Map<String, Object> getEncryptionHeader()
    {
        return super.getEncryptionHeader(ssoToken, tokenId, expireTime);
    }

    public void setSid(String id)
    {
        this.sid = id;
        setToken(sid);
    }

    public void setSsoToken(String ssoToken)
    {
        this.ssoToken = ssoToken;
    }

    public String getEncryption(String secret, String path, Long expire) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        return encryption(secret, path, expire);
    }

    public void setTokenId(String tokenId)
    {
        this.tokenId = tokenId;
    }

    public void setEncryption(boolean hasEncryption)
    {
        this.hasEncryption = hasEncryption;
    }

    public boolean hasEncryption()
    {
        return hasEncryption;
    }

    public boolean hasJioCdn(String url) {
        return url.contains(jioCdnCheck);
    }
    public void setExpireTime(int cdnUrlExpiry)
    {
        this.expireTime = cdnUrlExpiry;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public void setJioCdnCheck(String jioCdnCheck) {
        this.jioCdnCheck = jioCdnCheck;
    }
}
