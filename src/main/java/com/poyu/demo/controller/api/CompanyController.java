package com.poyu.demo.controller.api;

import java.net.URI;

import javax.validation.Valid;

import com.poyu.demo.domain.dto.req.CompanyRequest;
import com.poyu.demo.util.Util;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/company", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class CompanyController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getCompanyDataById(@PathVariable long id) {
        return ResponseEntity.ok().body(id + "test");
    }

    @GetMapping("/")
    public ResponseEntity<String> getCompanyData(
            @RequestParam(name = "limit", defaultValue = "-1", required = false) String limit) {
        return ResponseEntity.ok().body("test");
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createCompanyData(@RequestBody @Valid CompanyRequest companyRequest) {
        int id = -1;
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(id)
            .toUri();
        return ResponseEntity.created(location).body("");
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<String> replaceCompanyData(@PathVariable long id, @RequestBody) {
    //     return ResponseEntity.ok().body("test");
    // }

    // @PatchMapping("/{id}")
    // public ResponseEntity<String> patchCompanyData(@PathVariable long id, @RequestBody) {
    //     return ResponseEntity.ok().body("test");
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyData(@PathVariable long id) {
        return ResponseEntity.ok().body("test");
    }

}
