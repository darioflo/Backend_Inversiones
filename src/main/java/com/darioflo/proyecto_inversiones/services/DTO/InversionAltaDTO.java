package com.darioflo.proyecto_inversiones.services.DTO;
import com.darioflo.proyecto_inversiones.models.helpers.CuentaHelpModel;
import com.darioflo.proyecto_inversiones.models.helpers.InversionHelpModel;

import lombok.Data;

@Data
public class InversionAltaDTO {
    
    private String idInversionCuenta;
    private CuentaHelpModel cuenta;
    private InversionHelpModel Inversion;
    private Double saldoInicial;
    private int plazo;
    private String instruccionVencimiento;
    private Double tasa;
    private Double rendimientoAnual;
    private String fechaInicio;
    private String fechaFin;
     private boolean estaActiva;

}