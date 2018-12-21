package org.pusher.dwarves.code.challenge.controller;

import org.pusher.dwarves.code.challenge.dto.DwarfDto;
import org.pusher.dwarves.code.challenge.dto.DwarvesDto;
import org.pusher.dwarves.code.challenge.service.DwarfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@RestController
@RequestMapping(value = "/api/dwarves", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class DwarfController {

    @Autowired
    private DwarfService service;

    @GetMapping
    public CompletableFuture<DwarvesDto> findAllNames() {
        return CompletableFuture.supplyAsync(() -> service.findAllNames());
    }

    @GetMapping(value = "/{name}")
    public CompletableFuture<DwarfDto> findByName(@PathVariable @NotBlank String name) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return service.findByName(name);
            } catch (Exception e) {
                throw new CompletionException(e);
            }
        });
    }
}
