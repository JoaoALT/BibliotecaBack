package unisabana.edu.co.Biblioteca;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//getter,setter,AllArgsConstructor,NoArgsConstructor. con @. o poner @Data, que es equivalente a todo lo anterior.

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    @NotBlank
    @NotNull(message = "Mande el campo")
    @NotEmpty(message =  "El nombre completo es requerido.")
    @Size(min = 3, max = 50)
    private String titulo;
    @Min(100000)
    private int id;
    @NotEmpty
    @NotNull
    private String autor;
    @NotEmpty
    @NotNull
    private TipoEnum tipo;
    @NotEmpty
    @NotNull
    private FormatoEnum formato;
    @NotEmpty
    @NotNull
    @Min(0)
    @Max(2023)
    private int ano;
    @NotEmpty
    @NotNull
    @Min(0)
    @Max(100000)
    private int paginas;
    @NotEmpty
    @NotNull
    private EstadoEnum estado;
    @NotEmpty
    @NotNull
    @Min(0)
    @Max(1000000)
    private float precio;


}
