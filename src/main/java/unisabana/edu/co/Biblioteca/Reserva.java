package unisabana.edu.co.Biblioteca;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//getter,setter,AllArgsConstructor,NoArgsConstructor. con @. o poner @Data, que es equivalente a todo lo anterior.

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @NotBlank
    @NotNull(message = "Mande el campo")
    @NotEmpty(message =  "El nombre completo es requerido.")
    @Size(min = 3, max = 50)
    private String nombre;
    @NotBlank
    @NotNull(message = "Mande el campo")
    @NotEmpty(message =  "El nombre completo es requerido.")
    private String apellido;
    @NotBlank
    @NotNull(message = "Mande el campo")
    @NotEmpty
    private int rut;
    @NotBlank
    @NotNull(message = "Mande el campo")
    @NotEmpty
    private String celular;
    @NotBlank
    @NotNull(message = "Mande el campo")
    @NotEmpty
    private String correoelectronico;
    @NotBlank
    @NotNull(message = "Mande el campo")
    @NotEmpty
    private String nombrelibro; //titulo
    @NotBlank
    @NotNull(message = "Mande el campo")
    @NotEmpty
    private int idlibro;
    @NotBlank
    @NotNull(message = "Mande el campo")
    @NotEmpty
    private int semanas;
    @NotBlank
    @NotNull(message = "Mande el campo")
    @NotEmpty
    @Min(0)
    @Max(7)
    private int dias;


}
