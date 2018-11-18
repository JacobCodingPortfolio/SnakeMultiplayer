package pl.game.client.connection;

import org.springframework.web.client.RestTemplate;

public class RestSpringClient {
    private static RestTemplate client = new RestTemplate();
    private RestSpringClient(){}
    public static synchronized RestTemplate conn(){
        return client;
    }
}
