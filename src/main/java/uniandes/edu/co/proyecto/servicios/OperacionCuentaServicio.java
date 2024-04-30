package uniandes.edu.co.proyecto.servicios;

import java.util.Collection;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.repositorio.OperacionCuentaRepository;

public class OperacionCuentaServicio {

    private OperacionCuentaRepository operacionCuentasRepository;

    public OperacionCuentaServicio(OperacionCuentaRepository operacionCuentasRepository)
    {
        this.operacionCuentasRepository = operacionCuentasRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
    public Collection<OperacionCuenta> consultarBaresSinFantasma() throws InterruptedException {
        Collection<OperacionCuenta> operacionCuentas = operacionCuentasRepository.darOperacionesCuenta();
        Thread.sleep(10000); // Simular operación larga para mantener el bloqueo.
        operacionCuentas = operacionCuentasRepository.darOperacionesCuenta(); // Consultar bar.
        return operacionCuentas; // Devolver el bar consultado.
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public Collection<OperacionCuenta> consultarBaresConFantasma() throws InterruptedException {
        Collection<OperacionCuenta> operacionCuentas = operacionCuentasRepository.darOperacionesCuenta();
        Thread.sleep(10000); // Simular operación larga para mantener el bloqueo.
        operacionCuentas = operacionCuentasRepository.darOperacionesCuenta(); // Consultar bar.
        return operacionCuentas; // Devolver el bar consultado.
    }
}
