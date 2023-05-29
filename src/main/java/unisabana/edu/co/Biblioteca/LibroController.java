package unisabana.edu.co.Biblioteca;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping (path = "/biblioteca")
public class LibroController {
    public String Status = "";

    List<Libro> libritoList;

    public LibroController() {
        this.libritoList = new ArrayList<>();
        libritoList.add(new Libro("Don Quijote", 100000, "Cervantes", TipoEnum.LITERATURA, FormatoEnum.DIGITAL, 1605,462, EstadoEnum.DISPONIBLE, 94800));
        libritoList.add(new Libro("El principito", 100001, "Antoine", TipoEnum.LITERATURA, FormatoEnum.FISICO, 1605,462, EstadoEnum.DISPONIBLE, 48000));
        libritoList.add(new Libro("Odisea", 100002, "Homero", TipoEnum.LITERATURA, FormatoEnum.FISICO, 1605,462, EstadoEnum.DISPONIBLE,50000));
        libritoList.add(new Libro("El alquimista", 100003, "Paulo Coelho", TipoEnum.LITERATURA, FormatoEnum.DIGITAL, 1605,462, EstadoEnum.DISPONIBLE,74800));
        libritoList.add(new Libro("La metamorfosis", 100004, "Franz Kafka", TipoEnum.LITERATURA, FormatoEnum.FISICO, 1605,462, EstadoEnum.DISPONIBLE, 20000));
        libritoList.add(new Libro("The alienist", 100005, "Caleb Carr", TipoEnum.LITERATURA, FormatoEnum.DIGITAL, 1605,462, EstadoEnum.DISPONIBLE, 180000));
        libritoList.add(new Libro("The essay on the wisdom of life", 100006, "Schopenhauer", TipoEnum.FILOSOFIA, FormatoEnum.FISICO, 1605,462, EstadoEnum.DISPONIBLE, 60000));
        libritoList.add(new Libro("The animator's survival kit", 100007, "Richard", TipoEnum.ARTES, FormatoEnum.DIGITAL, 1605,462, EstadoEnum.RESERVADO,330100));

    }

    @GetMapping(path = "/todos")
    public List<Libro> obtenerEstudiante() {
        return libritoList;
    }

    @PutMapping(path = "/actualizar/{id}")
    public String actualizarEstudiante(@PathVariable Integer id){
        Libro newEstu = null;
        for (Libro estudiante : libritoList){
            if (estudiante.getId() == id){
                int posicion = libritoList.indexOf(estudiante);

                newEstu = estudiante;

                if(newEstu.getEstado() == EstadoEnum.DISPONIBLE) {
                    newEstu.setEstado(EstadoEnum.RESERVADO);
                }
                else{
                    newEstu.setEstado(EstadoEnum.DISPONIBLE);
                }

                libritoList.set(posicion,newEstu);
                break;
            }
        }
        return "Estudiante actualizado";
    }

}

