package unisabana.edu.co.Biblioteca;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping (path = "/reservas")
public class ReservaController {
    public String Status = "";

    List<Reserva> reservaList;

    public ReservaController() {
        this.reservaList = new ArrayList<>();
        reservaList.add(new Reserva("Joao","Munoz",1083868364,"3204962692","shaycoorman@gmail.com","Don Quijote",100000,1,6));
        reservaList.add(new Reserva("Diana","Martinez",100230400,"320343456","DM@gmail.com","Don Quijote",100000,0,4));
        reservaList.add(new Reserva("Marco","Dias",1120301030,"330215467","Marquito@ghotmail.com","Don Quijote",100000,1,3));
        reservaList.add(new Reserva("Julio","Perez",1050336701,"354203040","Pepe123@gmail.com","Don Quijote",100000,2,0));

    }

    @PostMapping(path = "/crear")
    public Response crearEstudiante(@RequestBody @Valid Reserva estudiante) {
        String estado = "";
        estudiante.setRut(filtrarID());
        reservaList.add(estudiante);
        estado = "Estudiante ingresado correctamente";
        return new Response(estado);
    }

    @GetMapping(path = "/todos")
    public List<Reserva> obtenerEstudiante() {
        return reservaList;
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable(name = "id") Integer id){
        int index = 0;
        for(Reserva estu : reservaList){
            if(estu.getRut() == id){
                reservaList.remove(index);
                break;
            }
            index++;
            // return HttpStatus.OK or return HttpStatus.NOT_FOUND
        }
        return "Reserva eliminada";
    }

    public Reserva ActualizeReservation(Reserva reservActualziada){
        Reserva nuevaReserva = new Reserva();
        nuevaReserva.setNombre(reservActualziada.getNombre());
        nuevaReserva.setApellido(reservActualziada.getApellido());
        nuevaReserva.setRut(reservActualziada.getRut());
        nuevaReserva.setCelular(reservActualziada.getCelular());
        nuevaReserva.setCorreoelectronico(reservActualziada.getCorreoelectronico());
        nuevaReserva.setNombrelibro(reservActualziada.getNombrelibro());
        nuevaReserva.setIdlibro(reservActualziada.getIdlibro());
        nuevaReserva.setSemanas(reservActualziada.getSemanas());
        nuevaReserva.setDias(reservActualziada.getDias());
        return nuevaReserva;
    }

    @PutMapping(path = "/actualizar/{id}")
    public String actualizarEstudiante(@PathVariable Integer id,@RequestBody Reserva actualizarEstudiante){
        Reserva newEstu = null;
        for (Reserva estudiante : reservaList){
            if (estudiante.getRut() == id){
                int posicion = reservaList.indexOf(estudiante);
                newEstu = ActualizeReservation(actualizarEstudiante);
                reservaList.set(posicion,newEstu);
                break;
            }
        }
        return "Estudiante actualizado";
    }


    public int filtrarID() {
        int id = 100000;
        for (Reserva estudiante : reservaList) {
            if (estudiante.getRut() > id) {
                id = estudiante.getRut();
            }
        }
        return id + 1;
    }
}
