package com.thoughtworks.msb.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class TransactionApproveHttpHandler {

    @PostMapping("/transaction/validate")
    public ResponseEntity<String> validate() {
        return ResponseEntity.ok().build();
    }
}
