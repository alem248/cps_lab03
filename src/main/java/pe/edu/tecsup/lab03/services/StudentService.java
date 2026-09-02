package pe.edu.tecsup.lab03.services;

import java.util.List;
import java.util.Optional;
import pe.edu.tecsup.lab03.entities.StudentEntity;
import pe.edu.tecsup.lab03.repositories.StudentRepository;

public class StudentService {
    private final StudentRepository repository = new StudentRepository();

    public StudentEntity saveStudent(StudentEntity student) {
        if (student.getNombre() == null || student.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (student.getApellido() == null || student.getApellido().trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
        if (student.getCarrera() == null || student.getCarrera().trim().isEmpty()) {
            throw new IllegalArgumentException("La carrera no puede estar vacío");
        }
        if (student.getCicloActual() == null || student.getCicloActual().trim().isEmpty()) {
            throw new IllegalArgumentException("El ciclo no puede estar vacío");
        }
        return repository.save(student);
    }
}