package pe.edu.tecsup.lab03.entities;

public class StudentEntity {

    private Long id;
    private String nombre;
    private String apellido;
    private String carrera;
    private String cicloActual;
    private String email;
    private String estado;

    // Constructor vacío
    public StudentEntity() {
    }

    // Constructor completo actualizado con id y nuevos campos
    public StudentEntity(Long id, String nombre, String apellido, String carrera, String cicloActual, String email, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.cicloActual = cicloActual;
        this.email = email;
        this.estado = estado;
    }

    // Constructor sin id (para nuevos registros)
    public StudentEntity(String nombre, String apellido, String carrera, String cicloActual, String email, String estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.cicloActual = cicloActual;
        this.email = email;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCicloActual() {
        return cicloActual;
    }

    public void setCicloActual(String cicloActual) {
        this.cicloActual = cicloActual;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", carrera='" + carrera + '\'' +
                ", cicloActual='" + cicloActual + '\'' +
                ", email='" + email + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}