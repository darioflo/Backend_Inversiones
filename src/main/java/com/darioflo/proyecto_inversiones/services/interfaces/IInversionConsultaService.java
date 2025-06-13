package com.darioflo.proyecto_inversiones.services.interfaces;

import java.util.ArrayList;

import com.darioflo.proyecto_inversiones.models.InversionesCuentaModel;


public interface IInversionConsultaService {
    ArrayList<InversionesCuentaModel> obtenerInversionesCuentas();
}
