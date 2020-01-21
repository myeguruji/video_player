package io.flutter.plugins.tokensdk;

public class TokenIdGenerator {
    private String cinemaTokenId;
    private String liveTid;
    private boolean isLive;

    static TokenIdGenerator tokenIdGenerator;

    public static TokenIdGenerator getInstance() {
        if (tokenIdGenerator == null) {
            tokenIdGenerator = new TokenIdGenerator();
        }
        return tokenIdGenerator;
    }

    public String getCinemaTokenId() {
        return cinemaTokenId;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public String getLiveTid() {
        return liveTid;
    }

    public void setCinemaTokenId(String cinemaTokenId) {
        this.cinemaTokenId = cinemaTokenId;
    }

    public void setLiveTid(String liveTid) {
        this.liveTid = liveTid;
    }
}
