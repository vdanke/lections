package org.step.second.configuration;

public class AppConfig {

    private AppProperties appProperties = new AppProperties();

    private static class AppProperties {
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    public AppProperties getAppProperties() {
        return appProperties;
    }
}
