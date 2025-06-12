package com.darioflo.proyecto_inversiones.services.interfaces;

import java.util.List;

import com.darioflo.proyecto_inversiones.models.InversionesCuentaModel;


public interface IInversionConsultaService {
    List<InversionesCuentaModel> obtenerInversiones();
}
