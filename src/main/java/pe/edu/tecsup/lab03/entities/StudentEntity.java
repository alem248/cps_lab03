package pe.edu.tecsup.lab03.entities;

public class StudentEntity {

    private Long id;
    private String nombre;
    private String apellido;
    private String carrera;
    private String cicloActual;

    // Constructor vacío
    public StudentEntity() {
    }

    // Constructor completo
    public StudentEntity(String nombre, String apellido, String carrera, String cicloActual) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.cicloActual = cicloActual;
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

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", carrera='" + carrera + '\'' +
                ", cicloActual='" + cicloActual + '\'' +
                '}';
    }
}