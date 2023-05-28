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
        libritoList.add(new Libro("Don Quijote", 100000, "Cervantes", TipoEnum.LITERATURA, FormatoEnum.FISICO, 1605,462, EstadoEnum.DISPONIBLE));
        libritoList.add(new Libro("El principito", 100001, "Cervantes", TipoEnum.LITERATURA, FormatoEnum.FISICO, 1605,462, EstadoEnum.DISPONIBLE));
        libritoList.add(new Libro("Odisea", 100002, "Cervantes", TipoEnum.LITERATURA, FormatoEnum.FISICO, 1605,462, EstadoEnum.DISPONIBLE));
        libritoList.add(new Libro("El alquimista", 100003, "Cervantes", TipoEnum.LITERATURA, FormatoEnum.FISICO, 1605,462, EstadoEnum.DISPONIBLE));
        libritoList.add(new Libro("La metamorfosis", 100004, "Cervantes", TipoEnum.LITERATURA, FormatoEnum.FISICO, 1605,462, EstadoEnum.DISPONIBLE));
        libritoList.add(new Libro("The alienist", 100005, "Cervantes", TipoEnum.LITERATURA, FormatoEnum.FISICO, 1605,462, EstadoEnum.DISPONIBLE));
        libritoList.add(new Libro("The essay on the wisdom of life", 100006, "Cervantes", TipoEnum.FILOSOFIA, FormatoEnum.FISICO, 1605,462, EstadoEnum.DISPONIBLE));
        libritoList.add(new Libro("The animator's survival kit", 100007, "Cervantes", TipoEnum.ARTES, FormatoEnum.FISICO, 1605,462, EstadoEnum.RESERVADO));

    }

    @GetMapping(path = "/todos")
    public List<Libro> obtenerEstudiante() {
        return libritoList;
    }

}

