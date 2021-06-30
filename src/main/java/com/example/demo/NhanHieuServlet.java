package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "NhanHieuServlet", urlPatterns = {"/listbrand", "/brand", "/newbrand", "/insertbrand", "/deletebrand", "/editbrand", "/updatebrand" })
public class NhanHieuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private  NhanHieuDAO nhanHieuDAO;

    public void init() {
        nhanHieuDAO = new NhanHieuDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/newbrand":
                    showNewForm(request, response);
                    break;
                case "/insertbrand":
                    insertBrand(request, response);
                    break;
                case "/deletebrand":
                    deleteBrand(request, response);
                    break;
                case "/editbrand":
                    showEditForm(request, response);
                    break;
                case "/updatebrand":
                    updateBrand(request, response);
                    break;
                default:
                    listBrand(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listBrand(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List < NhanHieu > listBrand = nhanHieuDAO.getAllNhanHieu();
        request.setAttribute("listBrand", listBrand);
        RequestDispatcher dispatcher = request.getRequestDispatcher("brand-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("brand-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanHieu existingBrand = nhanHieuDAO.getNhanHieu(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("brand-form.jsp");
        request.setAttribute("brand", existingBrand);
        dispatcher.forward(request, response);
    }

    private void insertBrand(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String ten = request.getParameter("ten");
        int trangthai = Integer.parseInt(request.getParameter("trangthai"));
        String mota = request.getParameter("mota");
        NhanHieu newBrand = new NhanHieu(ten, trangthai, mota);
        nhanHieuDAO.saveNhanHieu(newBrand);
        response.sendRedirect("listbrand");
    }

    private void updateBrand(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String ten = request.getParameter("ten");
        int trangthai = Integer.parseInt(request.getParameter("trangthai"));
        String mota = request.getParameter("mota");

        NhanHieu brand = new NhanHieu(id, ten, trangthai, mota);
        nhanHieuDAO.updateNhanHieu(brand);
        response.sendRedirect("listbrand");
    }

    private void deleteBrand(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        nhanHieuDAO.deleteNhanHieu(id);
        response.sendRedirect("listbrand");
    }
}
