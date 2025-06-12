package com.darioflo.proyecto_inversiones.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darioflo.proyecto_inversiones.models.CuentaModel;
import com.darioflo.proyecto_inversiones.models.InversionesCuentaModel;
import com.darioflo.proyecto_inversiones.repositories.InversionesCuentaRepository;
import com.darioflo.proyecto_inversiones.services.CuentaService;
import com.darioflo.proyecto_inversiones.services.DTO.InversionAltaDTO;
import com.darioflo.proyecto_inversiones.services.interfaces.IInversionModificacionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class InversionModificacionImpl implements IInversionModificacionService {

    private static final Logger logger = LoggerFactory.getLogger(InversionModificacionImpl.class);

    @Autowired
    private InversionesCuentaRepository inversionesCuentaRepository;

    @Autowired
    private CuentaService cuentaService;

    @Override
    public InversionesCuentaModel actualizarInversion(String idInversion, InversionAltaDTO dto) {
        Optional<InversionesCuentaModel> inversionOpt = inversionesCuentaRepository.findById(idInversion);

        if (inversionOpt.isEmpty()) {
            logger.warn("Inversión no encontrada con ID: {}", idInversion);
            throw new IllegalArgumentException("Inversión no encontrada");
        }

        InversionesCuentaModel inversion = inversionOpt.get();

        if (!inversion.isEstaActiva()) {
            logger.warn("Intento de modificar una inversión inactiva con ID: {}", idInversion);
            throw new IllegalArgumentException("La inversión no está activa");
        }

        inversion.setPlazo(dto.getPlazo());
        inversion.setInstruccionVencimiento(dto.getInstruccionVencimiento());

        if (!dto.getSaldoInicial().equals(inversion.getSaldoInicial())) {
            Double saldoAnterior = inversion.getSaldoInicial();
            Double nuevoSaldo = dto.getSaldoInicial();
            Double diferencia = nuevoSaldo - saldoAnterior;

            CuentaModel cuenta = cuentaService.obtenerCuentaPorID(dto.getCuenta().getId()).orElse(null);
            if (cuenta != null) {
                Double saldoActual = cuenta.getSaldo().doubleValue();
                Double saldoFinal = saldoActual - diferencia;
                if (saldoFinal >= 0) {
                    cuenta.setSaldo(saldoFinal.intValue());
                    cuentaService.actualizarSaldo(cuenta.getId(), cuenta.getSaldo());
                } else {
                    logger.warn("Saldo insuficiente en la cuenta {} para modificar inversión", cuenta.getId());
                    throw new IllegalArgumentException("Saldo insuficiente");
                }
            }
            inversion.setSaldoInicial(nuevoSaldo);
        }

        logger.info("Inversión actualizada correctamente con ID: {}", idInversion);
        return inversionesCuentaRepository.save(inversion);
    }
}
