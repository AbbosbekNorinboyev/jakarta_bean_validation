package com.example.Lesson9Tasks.task1.servlet.session;

import com.example.Lesson9Tasks.task1.entity.Users;
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

@WebServlet(
        name = "com.example.Lesson9Tasks.task1.servlet.session.LoginServlet",
        value = "/login"
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("validation");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Users user = entityManager.createQuery("from Users u where u.username = :username", Users.class)
                .setParameter("username", username).getSingleResult();
        req.getSession().setAttribute("username", user.getUsername());
        entityManager.getTransaction().commit();
        resp.sendRedirect("/");
    }
}
