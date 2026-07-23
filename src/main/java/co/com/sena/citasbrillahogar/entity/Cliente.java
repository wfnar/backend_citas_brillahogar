package co.com.sena.citasbrillahogar.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Column(nullable = false, length = 100)
    private String apellido;

    @NotBlank(message = "La dirección es obligatoria")
    @Column(nullable = false, length = 150)
    private String direccion;

    @NotBlank(message = "La cédula es obligatoria")
    @Column(nullable = false, unique = true, length = 20)
    private String cedula;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El teléfono es obligatorio")
    @Column(nullable = false, length = 20)
    private String telefono;

    @Email(message = "Correo electrónico inválido")
    @NotBlank(message = "El correo es obligatorio")
    @Column(nullable = false, unique = true, length = 120)
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    @Column(nullable = false)
    private String password;

    @OneToMany(
            mappedBy = "cliente",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )

    private List<Cita> citas;
}
