package uniandes.edu.co.proyecto.servicios;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.Thread; 

import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.repositorio.OperacionCuentaRepository;

@Service
public class OperacionCuentaService {
    
    private OperacionCuentaRepository operacionCuentasRepository;

    public OperacionCuentaService(OperacionCuentaRepository operacionCuentasRepository)
    {
        this.operacionCuentasRepository = operacionCuentasRepository;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
    public Collection<OperacionCuenta> darOperaciones() throws InterruptedException {
        Collection<OperacionCuenta> operaciones = operacionCuentasRepository.darOperacionesCuenta(); 
        return operaciones;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void actualizar_operacionCuenta_con_espera(int id_operacion, int cuenta, String detalle) {
        try {
            Thread.sleep(10000);
            operacionCuentasRepository.actualizarOperacionCuenta(id_operacion, cuenta, detalle);
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
    }
    @Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public void actualizar_operacionCuenta_sin_espera(int id_operacion) {
        try {
            OperacionCuenta operacionActual = operacionCuentasRepository.darOperacionCuenta(id_operacion);
            operacionCuentasRepository.actualizarOperacionCuenta(id_operacion, operacionActual.getCuenta(),operacionActual.getDetalle());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
    public Collection<OperacionCuenta> consultarOperacionesConEspera(Integer cuenta) throws InterruptedException {
    Thread.sleep(30000); // Demora de 10 segundos
    Collection<OperacionCuenta> operaciones = operacionCuentasRepository.findByCuenta(cuenta);
    System.out.println(operaciones.size()); 
    return operaciones; 
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public Collection<OperacionCuenta> consultarOperacionesConFantasma() throws InterruptedException {
        Collection<OperacionCuenta> operaciones = operacionCuentasRepository.darOperacionesCuenta();
        System.out.println(operaciones.size()); 
        operaciones = operacionCuentasRepository.darOperacionesCuenta();
        return operaciones;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
    public Collection<OperacionCuenta> consultarOperacionesSinFantasma() throws InterruptedException {
        Collection<OperacionCuenta> operaciones = operacionCuentasRepository.darOperacionesCuenta();
        System.out.println(operaciones.size());
        Thread.sleep(10000); 
        operaciones = operacionCuentasRepository.darOperacionesCuenta();
        return operaciones; 
    }

}
