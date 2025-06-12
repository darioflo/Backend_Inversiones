package com.darioflo.proyecto_inversiones.services.interfaces;

import com.darioflo.proyecto_inversiones.models.InversionesCuentaModel;
import com.darioflo.proyecto_inversiones.services.DTO.InversionAltaDTO;

public interface IInversionAltaService {
    
    InversionesCuentaModel crearInversion(InversionAltaDTO datos);
}
