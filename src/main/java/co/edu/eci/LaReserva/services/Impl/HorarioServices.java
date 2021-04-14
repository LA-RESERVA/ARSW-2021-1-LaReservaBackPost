package co.edu.eci.LaReserva.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eci.LaReserva.entities.Horario;

import co.edu.eci.LaReserva.persistence.HorarioPersistence;
import co.edu.eci.LaReserva.persistence.LaReservaPersistenceException;
import co.edu.eci.LaReserva.services.IHorarioService;
import co.edu.eci.LaReserva.services.LaReservaException;

@Service
public class HorarioServices implements IHorarioService {

    @Autowired
    HorarioPersistence horarioPersistence;

    @Override
    public void crearHorario(Horario horario) throws LaReservaException {
        try {
            horarioPersistence.agregarHorario(horario);;
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }

    @Override
    public List<Horario> consultarHorario() throws LaReservaException {
        return horarioPersistence.consultarHorario();
    }

    @Override
    public void eliminarHorario(Integer id) throws LaReservaException {
        try {
            horarioPersistence.eliminarHorario(id);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }

    @Override
    public void actualizarHorario(Horario horario) throws LaReservaException {
        try {
            horarioPersistence.agregarHorario(horario);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
    }
	@Override
	public Horario consultaEstado(int cancha, String dia, String hora) throws LaReservaException {
        try {
            return horarioPersistence.consultaEstado(cancha, dia, hora);
        } catch (LaReservaPersistenceException ex) {
            throw new LaReservaException(ex.getMessage());
        }
		
	}
}
