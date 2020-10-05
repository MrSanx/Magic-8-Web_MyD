/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Atomi
 */
@WebServlet(name = "servicioMagic", urlPatterns = {"/servicioMagic"})
public class servicioMagic extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String question = request.getParameter("question");
            if (question.isEmpty()) {
                out.println("Hey!, tienes que preguntar algo.");
            } else {
                String answer;
                int randomNumber = (int) (Math.random() * 21);
                switch (randomNumber) {
                    case 0:
                        answer = "En mi opinion, si.";
                        break;
                    case 1:
                        answer = "Es cierto.";
                        break;
                    case 2:
                        answer = "Es decididamente asi.";
                        break;
                    case 3:
                        answer = "Probablemente.";
                        break;
                    case 4:
                        answer = "Buen pronostico.";
                        break;
                    case 5:
                        answer = "Todo apunta a que si.";
                        break;
                    case 6:
                        answer = "Sin duda.";
                        break;
                    case 7:
                        answer = "Si.";
                        break;
                    case 8:
                        answer = "Si, definitivamente.";
                        break;
                    case 9:
                        answer = "Debes confiar en ello.";
                        break;
                    case 10:
                        answer = "Respuesta vaga, vuelve a intentarlo.";
                        break;
                    case 11:
                        answer = "Pregunta en otro momento.";
                        break;
                    case 12:
                        answer = "Sera mejor que no te lo diga ahora.";
                        break;
                    case 13:
                        answer = "No puedo predecirlo ahora.";
                        break;
                    case 14:
                        answer = "Concentrate y vuelve a preguntar.";
                        break;
                    case 15:
                        answer = "Puede ser.";
                        break;
                    case 16:
                        answer = "No cuentes con ello.";
                        break;
                    case 17:
                        answer = "Mi respuesta es no.";
                        break;
                    case 18:
                        answer = "Mis fuentes me dicen que no.";
                        break;
                    case 19:
                        answer = "Las perspectivas no son buenas.";
                        break;
                    case 20:
                        answer = "Muy dudoso.";
                        break;
                    case 21:
                        answer = "Sapo.";
                        break;
                    default:
                        throw new AssertionError();
                }
                out.print(answer);
            }
        }
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
