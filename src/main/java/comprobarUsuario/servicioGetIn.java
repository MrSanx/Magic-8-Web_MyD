/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comprobarUsuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
@WebServlet(name = "servicioGetIn", urlPatterns = {"/servicioGetIn"})
public class servicioGetIn extends HttpServlet {

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
            //Variables
            String user = request.getParameter("user");
            //out.println("Usuario= " + user + "<br>");
            String pass = request.getParameter("pass");
            //out.println("Password= " + pass + "<br>");
            out.println("<head>\n"
                    + "            <meta charset=\"UTF-8\">\n"
                    + "            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "            <title>Login | Magic-8</title>\n"
                    + "            <!--FONT ROBOTO-->\n"
                    + "            <link href=\"https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;1,400&display=swap\"\n"
                    + "                  rel=\"stylesheet\">\n"
                    + "            <!--CUSTOM CSS-->\n"
                    + "            <link rel=\"stylesheet\" href=\"styles.css\">\n"
                    + "        </head>");
            out.println("<div class=\"box\"> <h2>Usuario o contraseña incorrecto.</h2><br><a href=\"index.html\" class=\"button\">Volver a inicio</a></div>");

            //ReadFile
            File f = new File("usuariosProyecto.json");
            try (FileReader fr = new FileReader(f)) {
                BufferedReader br = new BufferedReader(fr);

                boolean resp = true;
                String line;
                while ((line = br.readLine()) != null) {
                    //out.println("{\"usuario\":\"" + user + "\"," + "\"password\":\"" + pass + "\"}<br>");
                    String[] data = line.split("}");
                    if (("{\"usuario\":\"" + user + "\"," + "\"password\":\"" + pass + "\"").equalsIgnoreCase(data[0])) {

                        out.println("Usuario ingresado con exito <br>");
                        response.sendRedirect("magic.html");
                    } else {
                        //out.println("El usuario o la contraseña no existe <br>");
                        //out.println(data[0]);
                    }
                }
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
