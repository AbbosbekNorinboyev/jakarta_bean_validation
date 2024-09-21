package com.example.Lesson9Tasks.task1.servlet.groups;

import com.example.Lesson9Tasks.task1.entity.Groups;
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
        name = "com.example.Lesson9Tasks.task1.servlet.groups.GroupCreateServlet",
        value = "/create/group"
)
public class GroupCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/groups/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            int count = Integer.parseInt(req.getParameter("count"));
            Groups group = Groups.builder()
                    .group_name(name)
                    .count(count)
                    .build();
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("validation");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Set<String> strings = ValidationUtils.validate(group);
            if (strings.isEmpty()) {
                entityManager.getTransaction().begin();
                entityManager.persist(group);
                entityManager.getTransaction().commit();
                resp.sendRedirect("/group/list");
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
