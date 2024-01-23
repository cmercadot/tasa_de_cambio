package com.cajeroautomatico.tasacambio.dto;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class TasaDeCambioResponse {

    private  String moneda;
    private  Double tipoCambioVenta;
    private  Double tipoCambioCompra;

}
