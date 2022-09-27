package ru.anna.rest_dealer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.anna.rest_dealer.model.Response;

@Service
public class SendMessage implements Mailer {
    @Override
    public Response send(Response response) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/feed";
        restTemplate.postForLocation(url, response);
        return response;
    }
}
