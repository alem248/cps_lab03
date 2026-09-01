package pe.edu.tecsup.lab03.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.tecsup.lab03.entities.StudentEntity;
import pe.edu.tecsup.lab03.services.StudentService;

@WebServlet("/students")
public class StudentController extends HttpServlet {

    private final StudentService studentService = new StudentService();

    // Método GET: Mostrar lista de estudiantes o formulario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            // Mostrar lista de estudiantes
            List<StudentEntity> students = studentService.getAllStudents();
            request.setAttribute("students", students);
            request.getRequestDispatcher("/students/list.jsp").forward(request, response);

        } else if (action.equals("create")) {
            // Mostrar formulario de creación
            request.getRequestDispatcher("/students/create.jsp").forward(request, response);

        } else if (action.equals("edit")) {
            // Mostrar formulario de edición
            String idParam = request.getParameter("id");
            if (idParam != null) {
                Long id = Long.parseLong(idParam);
                studentService.getStudentById(id).ifPresent(student -> {
                    request.setAttribute("student", student);
                });
                request.getRequestDispatcher("/students/edit.jsp").forward(request, response);
            }
        }
    }

    // Método POST: Crear o actualizar estudiante
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("create".equals(action)) {
            // Crear nuevo estudiante
            createStudent(request, response);

        } else if ("update".equals(action)) {
            // Actualizar estudiante existente
            updateStudent(request, response);

        } else if ("delete".equals(action)) {
            // Eliminar estudiante
            deleteStudent(request, response);
        }
    }

    // Método privado para crear estudiante
    private void createStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String carrera = request.getParameter("carrera");
        String cicloActual = request.getParameter("cicloActual");

        StudentEntity student = new StudentEntity(nombre, apellido, carrera, cicloActual);

        try {
            studentService.saveStudent(student);
            response.sendRedirect(request.getContextPath() + "/students?action=list");
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("student", student);
            request.getRequestDispatcher("/students/create.jsp").forward(request, response);
        }
    }

    // Método privado para actualizar estudiante
    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String idParam = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String carrera = request.getParameter("carrera");
        String cicloActual = request.getParameter("cicloActual");

        StudentEntity student = new StudentEntity();
        student.setId(Long.parseLong(idParam));
        student.setNombre(nombre);
        student.setApellido(apellido);
        student.setCarrera(carrera);
        student.setCicloActual(cicloActual);

        try {
            studentService.saveStudent(student);
            response.sendRedirect(request.getContextPath() + "/students?action=list");
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("student", student);
            request.getRequestDispatcher("/students/edit.jsp").forward(request, response);
        }
    }

    // Método privado para eliminar estudiante
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String idParam = request.getParameter("id");
        if (idParam != null) {
            Long id = Long.parseLong(idParam);
            studentService.deleteStudent(id);
        }
        response.sendRedirect(request.getContextPath() + "/students?action=list");
    }
}