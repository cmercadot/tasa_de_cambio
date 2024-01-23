package com.cajeroautomatico.tasacambio.respository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="tasa_cambio")
public class TasaDeCambioEntity {


    @Id
    private  String moneda;
    private  Double tipoCambioVenta;
    private  Double tipoCambioCompra;

}
