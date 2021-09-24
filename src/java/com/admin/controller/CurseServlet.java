/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.controller;

import com.admin.dao.CurseDaoLocal;
import com.admin.model.Curso;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateo
 */
@WebServlet(name = "CurseServlet", urlPatterns = {"/CurseServlet"})
public class CurseServlet extends HttpServlet {

    @EJB
    private CurseDaoLocal curseDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String codigoCursoStr = request.getParameter("codigoCurso");
        int codigoCurso = 0;
        if (codigoCursoStr != null && !codigoCursoStr.equals("")) {
            codigoCurso = Integer.valueOf(codigoCursoStr);
        }
        String nombreCurso = request.getParameter("nombreCurso");
        String creditosStr = request.getParameter("creditos");
        int creditos = 0;
        if (creditosStr != null && !creditosStr.equals("")) {
            creditos = Integer.valueOf(creditosStr);
        }
        String semestreStr = request.getParameter("semestre");
        int semestre = 0;
        if (semestreStr != null && !semestreStr.equals("")) {
            semestre = Integer.valueOf(semestreStr);
        }
        String numeroEstudiantesStr = request.getParameter("numeroEstudiantes");
        int numeroEstudiantes = 0;
        if (numeroEstudiantesStr != null && !numeroEstudiantesStr.equals("")) {
            numeroEstudiantes = Integer.valueOf(numeroEstudiantesStr);
        }

        Curso curso = new Curso(codigoCurso, nombreCurso, creditos, semestre,numeroEstudiantes);

        if ("Add".equalsIgnoreCase(action)) {
            curseDao.addCurso(curso);
        } else if ("Edit".equalsIgnoreCase(action)) {
            curseDao.editCurso(curso);
        } else if ("Delete".equalsIgnoreCase(action)) {
            curseDao.deleteCurso(codigoCurso);
        } else if ("Search".equalsIgnoreCase(action)) {
            curseDao.getCurso(codigoCurso);
        }
        request.setAttribute("curso", curso);
        request.setAttribute("allCursos", curseDao.getAllCurso());
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
