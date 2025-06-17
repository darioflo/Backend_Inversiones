package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.darioflo.proyecto_inversiones.models.helpers.CuentaHelpModel;
import com.darioflo.proyecto_inversiones.models.helpers.InversionHelpModel;

import lombok.Data;

@Document(collection = "inversionesCuentas")
@Data
public class InversionesCuentaModel {

    @Id
    private String idInversionCuenta;

    private CuentaHelpModel cuenta;
    private InversionHelpModel inversion;
    private boolean estaActiva;
    private int plazo;
    private double tasa;
    private double rendimientoAnual;
    private double saldoInicial;
    private double saldoAlTermino;
    private String instruccionVencimiento;
    private String fechaInicio;
    private String fechaFin;

}