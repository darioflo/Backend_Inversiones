package com.darioflo.proyecto_inversiones.services.interfaces;

import com.darioflo.proyecto_inversiones.models.InversionesCuentaModel;
import com.darioflo.proyecto_inversiones.services.DTO.InversionModificacionDTO;

public interface IInversionModificacionService {
    InversionesCuentaModel actualizarInversion(InversionModificacionDTO datos);
}
