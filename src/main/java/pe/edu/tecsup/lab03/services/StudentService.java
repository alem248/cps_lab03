package pe.edu.tecsup.lab03.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.lab03.entities.StudentEntity;
import pe.edu.tecsup.lab03.repositories.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;

    // Inyección por constructor (Buena práctica en Spring)
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    /**
     * Guarda o actualiza un estudiante validando sus datos obligatorios.
     */
    public StudentEntity saveStudent(StudentEntity student) {
        validateStudentData(student);
        return repository.save(student);
    }

    /**
     * Obtiene el listado completo de estudiantes registrados.
     */
    public List<StudentEntity> getAllStudents() {
        return repository.findAll();
    }

    /**
     * Busca un estudiante por su identificador único.
     */
    public Optional<StudentEntity> getStudentById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID proporcionado no es válido.");
        }
        return repository.findById(id);
    }

    /**
     * Elimina un estudiante según su ID.
     */
    public boolean deleteStudent(Long id) {
        if (id == null || id <= 0) {
            return false;
        }
        return repository.deleteById(id);
    }

    /**
     * Busca estudiantes cuyos nombres coincidan con el parámetro.
     */
    public List<StudentEntity> searchByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    /**
     * Filtra la lista de estudiantes por carrera.
     */
    public List<StudentEntity> searchByCarrera(String carrera) {
        return repository.findByCarrera(carrera);
    }

    // Método auxiliar para centralizar las validaciones
    private void validateStudentData(StudentEntity student) {
        if (student == null) {
            throw new IllegalArgumentException("Los datos del estudiante no pueden ser nulos.");
        }
        if (isInvalidString(student.getNombre())) {
            throw new IllegalArgumentException("El nombre del estudiante es obligatorio.");
        }
        if (isInvalidString(student.getApellido())) {
            throw new IllegalArgumentException("El apellido del estudiante es obligatorio.");
        }
        if (isInvalidString(student.getCarrera())) {
            throw new IllegalArgumentException("La carrera es obligatoria.");
        }
        if (isInvalidString(student.getCicloActual())) {
            throw new IllegalArgumentException("El ciclo actual es obligatorio.");
        }
    }

    private boolean isInvalidString(String value) {
        return value == null || value.trim().isEmpty();
    }
}