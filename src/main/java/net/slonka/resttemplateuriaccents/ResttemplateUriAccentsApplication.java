package net.slonka.resttemplateuriaccents;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ResttemplateUriAccentsApplication {

    public static void main(String[] args) throws URISyntaxException {
        thisDoesNotValidate();
        RestTemplate rt = new RestTemplate();
        // underneath resttemplate uses https://github.com/spring-projects/spring-framework/blob/master/spring-web/src/main/java/org/springframework/web/util/DefaultUriBuilderFactory.java#L400
        // which in this version does not do validation
        String v = rt.getForEntity("http://www.pamięć.pl", String.class).getBody();
        System.out.println(v);
    }

    public static void thisDoesNotValidate() throws URISyntaxException {
        URI uri = new URI("http://www.pamięć.pl");
        String host = uri.getHost(); // this is null
        System.out.println(host);
    }

    public static void thisValidates() throws URISyntaxException {
        URI uri = new URI("http", null, "www.pamięć.pl", 80, null, null, null);
    }
}
