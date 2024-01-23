package com.cajeroautomatico.tasacambio.controller;


import com.cajeroautomatico.tasacambio.dto.TasaDeCambioRequest;
import com.cajeroautomatico.tasacambio.dto.TasaDeCambioResponse;
import com.cajeroautomatico.tasacambio.service.TasaDeCambioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/v1/tasa-de-cambio")
@RestController
public class TasaDeCambioApi {


    TasaDeCambioService tasaDeCambioService;
    public TasaDeCambioApi(TasaDeCambioService tasaDeCambioService){
        this.tasaDeCambioService=tasaDeCambioService;
    }

    @GetMapping
    public ResponseEntity findAllTasaDeCambio() {

        return  ResponseEntity.ok(tasaDeCambioService.findAllTasaDeCambio());

    }
    @PutMapping
    ResponseEntity<Object> modify(@RequestBody TasaDeCambioRequest request){
        return ResponseEntity.ok( tasaDeCambioService.modifyTasaDeCambio(request));
    }

    @GetMapping("{moneda}")
    public ResponseEntity<TasaDeCambioResponse> findByIdTasaDeCambio(@PathVariable String moneda) {
        return     ResponseEntity.ok(tasaDeCambioService.findByIdTasaDeCambio(moneda));

    }



}
