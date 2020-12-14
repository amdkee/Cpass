package com.cpass.cpass.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.cpass.cpass.requests.MakeCallRequestBody;
import com.cpass.cpass.services.CpassService;
import com.cpass.cpass.responses.MakeCallResponseBody;

/**
 *
 * @author Laughmare
 */
@CrossOrigin
@RestController
@RequestMapping("/cpass")
public class CpassController {

    @Autowired
    CpassService cpassService;

    //request body made non-required so we can validate it and send an error list when its empty
    @PostMapping("/makeCall")
    public ResponseEntity<MakeCallResponseBody> makeCall(@RequestBody(required = false) MakeCallRequestBody body) {
        MakeCallResponseBody response = cpassService.makeCall(body);//everything happens in services
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
