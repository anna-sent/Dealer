package ru.anna.rest_dealer.service;

import ru.anna.rest_dealer.model.Response;

public interface Mailer {

    Response send(Response response);

}
