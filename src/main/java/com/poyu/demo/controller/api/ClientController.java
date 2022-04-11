package com.poyu.demo.controller.api;

import java.net.URI;

import javax.validation.Valid;

import com.poyu.demo.domain.dto.req.ClientRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/api/client", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getClientDataById(@PathVariable long id) {
        return ResponseEntity.ok().body(id + "test");
    }

    @GetMapping("/")
    public ResponseEntity<String> getClientData(
            @RequestParam(name = "limit", defaultValue = "-1", required = false) String limit) {
        return ResponseEntity.ok().body("test");
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createClientData(@RequestBody @Valid ClientRequest req) {
        int id = 1; // replace with new
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).body("");
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<String> replaceClientData(@PathVariable long id, @RequestBody) {
    //     return ResponseEntity.ok().body("test");
    // }

    // @PatchMapping("/{id}")
    // public ResponseEntity<String> patchClientData(@PathVariable long id, @RequestBody) {
    //     return ResponseEntity.ok().body("test");
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClientData(@PathVariable long id) {
        return ResponseEntity.ok().body("test");
    }
}
