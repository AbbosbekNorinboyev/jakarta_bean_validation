package com.example.Lesson9Tasks.task1.servlet.students;

import com.example.Lesson9Tasks.task1.entity.Groups;
import com.example.Lesson9Tasks.task1.entity.Student;
import com.example.Lesson9Tasks.task1.servlet.ValidationUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet(
        name = "com.example.Lesson9Tasks.task1.servlet.students.StudentCreateServlet",
        value = "/create/student"
)
public class StudentCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("validation");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Groups> groupsList = entityManager.createQuery("from Groups", Groups.class).getResultList();
        entityManager.getTransaction().commit();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/students/create.jsp");
        req.setAttribute("groupsList", groupsList);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String groupId = req.getParameter("groupId");
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("validation");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Groups group = entityManager.find(Groups.class, groupId);
            Student student = Student.builder()
                    .full_name(name)
                    .age(age)
                    .groups(group)
                    .build();
            Set<String> strings = ValidationUtils.validate(student);
            if (strings.isEmpty()) {
                entityManager.getTransaction().begin();
                entityManager.persist(student);
                entityManager.getTransaction().commit();
                resp.sendRedirect("/student/list");
            } else {
                for (String string : strings) {
                    System.out.println(string);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}