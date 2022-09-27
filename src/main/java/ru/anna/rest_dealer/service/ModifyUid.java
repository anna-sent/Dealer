package ru.anna.rest_dealer.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.anna.rest_dealer.model.Response;

@Service
@Qualifier("ModifyUid")
public class ModifyUid implements MyService{

    @Override
    public Response execute(Response response) {

        response.setUId("new uid 2023");

        return response;
    }
}
