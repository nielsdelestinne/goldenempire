package be.nielsdelestinne.goldenempire;

/**
 * Created by Niels Delestinne: www.nielsdelestinne.be
 */
public enum Environment {

    DEV("dev"),
    PRD("prd");

    private String environmentLabel;

    Environment(String environmentLabel) {
        this.environmentLabel = environmentLabel;
    }

    public String getEnvironmentLabel() {
        return environmentLabel;
    }
}
