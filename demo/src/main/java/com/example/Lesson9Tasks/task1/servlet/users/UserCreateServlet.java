package com.example.Lesson9Tasks.task1.servlet.users;

import com.example.Lesson9Tasks.task1.entity.Users;
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
import java.util.Set;

@WebServlet(
        name = "com.example.Lesson9Tasks.servlet.users.UserCreateServlet",
        value = "/create/user"
)
public class UserCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/users/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            Users user = Users.builder()
                    .username(username)
                    .build();
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("validation");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Set<String> strings = ValidationUtils.validate(user);
            if (strings.size() == 0) {
                entityManager.getTransaction().begin();
                entityManager.persist(user);
                entityManager.getTransaction().commit();
                resp.sendRedirect("/user/list");
            } else {
                for (String errorMessage : strings) {
                    System.out.println(errorMessage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
