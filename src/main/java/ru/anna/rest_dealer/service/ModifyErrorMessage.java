package ru.anna.rest_dealer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.anna.rest_dealer.model.Response;

@Service
@RequiredArgsConstructor
@Qualifier("ModifyErrorMessage")
public class ModifyErrorMessage implements MyService{

    @Override
    public Response execute(Response response){

        response.setErrorMessage("Application crashed");

        return response;
    }
}
