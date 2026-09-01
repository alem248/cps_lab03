package pe.edu.tecsup.lab03.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import pe.edu.tecsup.lab03.entities.StudentEntity;

public class StudentRepository {

    private final List<StudentEntity> students = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public StudentEntity save(StudentEntity student) {
        if (student.getId() == null) {
            student.setId(idCounter.getAndIncrement());
            students.add(student);
        } else {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId().equals(student.getId())) {
                    students.set(i, student);
                    break;
                }
            }
        }
        return student;
    }
    public pe.edu.tecsup.lab03.repositories.List<StudentEntity> findAll() {
        return new ArrayList<>(students);
    }

    public Optional<StudentEntity> findById(Long id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    public boolean deleteById(Long id) {
        return students.removeIf(s -> s.getId().equals(id));
    }

    public List<StudentEntity> findByNombre(String nombre) {
        List<StudentEntity> result = new ArrayList<>();
        for (StudentEntity student : students) {
            if (student.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }

    public List<StudentEntity> findByCarrera(String carrera) {
        List<StudentEntity> result = new ArrayList<>();
        for (StudentEntity student : students) {
            if (student.getCarrera().toLowerCase().contains(carrera.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }
}
