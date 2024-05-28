package org.tesis.backend_transporte.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.tesis.backend_transporte.entity.Asiento;
import org.tesis.backend_transporte.entity.Unidad;
import org.tesis.backend_transporte.entity.Viaje;
import org.tesis.backend_transporte.repository.AsientoRepository;
import org.tesis.backend_transporte.repository.UnidadRepository;
import org.tesis.backend_transporte.repository.ViajeRepository;

import java.util.*;


@Service
public class ViajeService {

    private final ViajeRepository viajeRepository;

    private final UnidadRepository unidadRepository;

    private final AsientoRepository asientoRepository;
    HashMap<String,Object> datos;

    @Autowired
    public ViajeService(ViajeRepository viajeRepository, UnidadRepository unidadRepository, AsientoRepository asientoRepository){
        this.viajeRepository=viajeRepository;
        this.unidadRepository = unidadRepository;
        this.asientoRepository = asientoRepository;
    }

    public List<Viaje> obtenerViajes(){
        return this.viajeRepository.findAll();
    }

    public ResponseEntity<Object> registrarViaje(Viaje viaje) throws IllegalAccessException {

        Optional<Viaje> res = viajeRepository.findViajeByCodigoViaje(viaje.getCodigoViaje());
        datos= new HashMap<>();

        if(res.isPresent() && viaje.getIdViaje()==null){
            datos.put("error",true);
            datos.put("messaje","Ya existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("messaje","Registro exitoso");
        if (viaje.getIdViaje()!=null){
            datos.put("messaje","Actualizado exitoso");
        }

        viajeRepository.save(viaje);
        datos.put("data",viaje);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> eliminarViaje(Long id){
        boolean existe=this.viajeRepository.existsById(id);
        datos=new HashMap<>();
        if (!existe){
            datos.put("error",true);
            datos.put("messaje","No existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        viajeRepository.deleteById(id);
        datos.put("messaje","Registro Eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );

    }

@Scheduled(fixedRate = 60000) // Ejecutar cada minuto
public void updateViajeEstado() {

    List<Viaje> viajes = viajeRepository.findAll();

    Date now = new Date();

    for (Viaje viaje : viajes) {
        //System.out.println("ingresaa1");
        if (viaje.getFecha() != null && viaje.getHoraInicio() != null && viaje.getHoraFin() != null) {
            ///system.out.println("ingresaa11");
            // Crear las fechas y horas completas
            Date fechaInicio = mergeDateAndTime(viaje.getFecha(), viaje.getHoraInicio());
            Date fechaFin = mergeDateAndTime(viaje.getFecha(), viaje.getHoraFin());

            System.out.println(viaje.getFecha()+"...."+viaje.getHoraInicio()+"......"+viaje.getHoraInicio());
            System.out.println(now+ " " + fechaInicio+"    "+fechaFin);

            // Actualizar el estado del viaje
            boolean estadoActual = now.after(fechaInicio) && now.before(fechaFin);

            if (viaje.getEstado() == null || viaje.getEstado() != estadoActual) {

                System.out.println("ingresaa111   " +viaje.getIdViaje());
                viaje.setEstado(estadoActual);
                viajeRepository.save(viaje);

                Unidad unidadAsociada = viaje.getUnidad();

                if (unidadAsociada != null) {
                    unidadAsociada.setEstado(estadoActual);
                    unidadRepository.save(unidadAsociada);
                } else {
                    System.out.println("no existe");
                }
            }

            if (now.after(fechaFin)) {
                Unidad unidadAsociada = viaje.getUnidad();
                if (unidadAsociada != null) {
                    Long idUnidad = unidadAsociada.getIdUnidad();
                    // Recuperar todos los asientos asociados a esta unidad
                    List<Asiento> asientos = asientoRepository.findByUnidadIdUnidad(idUnidad);
                    for (Asiento asiento : asientos) {
                        asiento.setEstado(false); // Cambiar el estado del asiento a falso
                        asientoRepository.save(asiento);
                    }
                }
            }

        }
    }
}

    // Método para combinar una fecha y una hora en un objeto Date
    private Date mergeDateAndTime(Date date, Date time) {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);

        Calendar calendarTime = Calendar.getInstance();
        calendarTime.setTime(time);

        calendarDate.set(Calendar.HOUR_OF_DAY, calendarTime.get(Calendar.HOUR_OF_DAY));
        calendarDate.set(Calendar.MINUTE, calendarTime.get(Calendar.MINUTE));
        calendarDate.set(Calendar.SECOND, calendarTime.get(Calendar.SECOND));

        return calendarDate.getTime();
    }

}
