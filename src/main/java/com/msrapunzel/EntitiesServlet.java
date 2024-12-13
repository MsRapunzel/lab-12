package com.msrapunzel;

import jakarta.json.JsonArray;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/entities")
public class EntitiesServlet extends HttpServlet {
    @PersistenceContext(unitName = "JakartaEELocal")
    private EntityManager entityManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TypedQuery<Users> query = entityManager.createQuery("SELECT u FROM Users u", Users.class);
        List<Users> entities = query.getResultList();

        JsonArray jsonArray = JsonConverter.convertToJsonArray(entities);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        request.setAttribute("jsonEntities", jsonArray.toString());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}