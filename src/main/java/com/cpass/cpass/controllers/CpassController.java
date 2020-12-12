/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    @PostMapping("/makeCall")
    public ResponseEntity<MakeCallResponseBody> makeCall(@RequestBody(required = false) MakeCallRequestBody body){
        MakeCallResponseBody response = cpassService.makeCall(body);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
