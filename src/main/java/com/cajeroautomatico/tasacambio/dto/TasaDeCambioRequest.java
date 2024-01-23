package com.cajeroautomatico.tasacambio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TasaDeCambioRequest {

    @Schema(title = "Moneda",
            description = "Acepta solo USD",
            example = "USD")
    private  String moneda;
    @Schema(title = "Tipo de cambio venta",
            description = "Acepta valores numericos",
            example = "6.98")
    private  Double tipoCambioVenta;
    @Schema(title = "Tipo de cambio compra",
            description = "Acepta valores numericos",
            example = "6.97")
    private  Double tipoCambioCompra;

}
