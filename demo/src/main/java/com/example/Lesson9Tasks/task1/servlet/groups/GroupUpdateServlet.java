package com.example.Lesson9Tasks.task1.servlet.groups;

import com.example.Lesson9Tasks.task1.entity.Groups;
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
import java.util.Objects;

@WebServlet(
        name = "com.example.Lesson9Tasks.task1.servlet.groups.GroupUpdateServlet",
        value = "/update/group/*"
)
public class GroupUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        int id = Integer.parseInt(pathInfo.substring(1));
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("validation");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Groups group = entityManager.find(Groups.class, id);
        entityManager.getTransaction().commit();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/groups/update.jsp");
        req.setAttribute("group", group);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        int id = Integer.parseInt(pathInfo.substring(1));
        String name = req.getParameter("name");
        int count = Integer.parseInt(req.getParameter("count"));
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("validation");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Groups group = entityManager.find(Groups.class, id);
        if (Objects.isNull(group)) {
            resp.sendError(404, "Group '%s' not found".formatted(id));
        } else {
            group.setGroup_name(Objects.requireNonNullElse(name, group.getGroup_name()));
            group.setCount(Objects.requireNonNullElse(count, group.getCount()));
            entityManager.merge(group);
        }
        entityManager.getTransaction().commit();
        resp.sendRedirect("/group/list");
    }
}
