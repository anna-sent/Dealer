package ru.anna.rest_dealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.anna.rest_dealer.model.Request;
import ru.anna.rest_dealer.model.Response;
import ru.anna.rest_dealer.service.Mailer;
import ru.anna.rest_dealer.service.MyService;

@RestController
public class DealerController {

    private final MyService myService;
    private final Mailer mailer;

    @Autowired
    public DealerController(@Qualifier("ModifyUid") MyService myService, Mailer mailer){

        this.myService = myService;
        this.mailer = mailer;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request){

        Response response = Response.builder()
                .uId(request.getUId())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("successful")
                .errorCode("")
                .errorMessage("")
                .build();

        Response responseWasModified = myService.execute(response);
        Response sendMessage = mailer.send(responseWasModified);
        return new ResponseEntity<>(sendMessage, HttpStatus.OK);

    }
}
