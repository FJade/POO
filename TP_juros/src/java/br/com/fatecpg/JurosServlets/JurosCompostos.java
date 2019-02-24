
package br.com.fatecpg.JurosServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Juros-Compostos", urlPatterns = {"/juros-compostos.html"})
public class JurosCompostos extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
                out.println("<head>");
                    out.println("<title>Juros Compostos</title>");      
                    
                     out.println("<style>");
                    
                        out.println("body { background-color: #BDBDBD;  font-size: 16px; }");
                        out.println(".geral { background-color: #E6E6E6; margin: 15px 180px 0 180px; border: 1px solid darkblue; "
                                + "padding: 10px 80px 20px 80px; font-family: Trebuchet MS; }");
                        out.println("h1 { text-align: center; }");
                        out.println("h2 { margin-left: 60px; color: darkblue; }");
                        out.println("h2 a { text-decoration: none; color: darkblue; font-weight: 500;}");
                        out.println("button { padding: 10px; font-size: 20px; }");
                        out.println("button a:hover { color: #8A0808; }");
                        out.println("button a { text-decoration: none; color: darkblue; }");
                        out.println("input { width: 130px; padding: 5px; margin-left: 10px; margin-right: 10px; font-size: 18px;}");
                        out.println(".botao { margin: 20px 0px 10px 20px; color: darkblue; padding: 5px; font-size: 20px; }");
                        out.println(".botao:hover { color: #8A0808; }");
                        out.println("h3 { margin-left: 0px; font-size: 22px; line-height: 30px; }");
                        out.println("b { margin-left: 0px; font-size: 22px; }");
                        out.println(".formulario { background-color: #E6E6E6; margin: 10px 180px 40px; 180px; border: 1px solid darkblue; "
                                + "padding: 10px 10px 40px 40px; font-family: Trebuchet MS; }");
                        out.println(".resposta { font-size: 20px; font-weigth: bold;  color: #8A0808; line-height: 8px; }");
                                         
                    out.println("</style>");                    

                out.println("</head>");
                
                out.println("<body>");
                
                out.println("<div class='geral'>");
                        out.println("<h1>Juros Compostos</h1>");

                        out.println("<hr/>");

                        out.println("<h3 style='color: darkblue;'>M = C * (1 + i)^t</h3>");
                        out.println("<h3>Onde:</h3>");
                        out.println("<h3>M = Montante <br/>C = Capital <br/>i = Taxa de Juros <br/>t = Período</h3></div>");

                        out.println("<form class='formulario'>");
                            out.println("<b>Capital</b><input type='text' name='capital' />");
                            out.println("<b>Taxa</b><input type='text' name='taxa'/>");
                            out.println("<b>Mes</b><input type='text' name='mes'/>");
                            out.println("<input class='botao' type='submit' name='montante' value='Calcular'/>");
                                                                                 
                            if (request.getParameter("montante")!=null){
                                try{
                                    double capital = Double.parseDouble(request.getParameter("capital"));
                                    double taxa = Double.parseDouble(request.getParameter("taxa"));
                                    int mes  = Integer.parseInt(request.getParameter("mes"));
                                    
                                    out.println("<table>");
                                        for (int i = 1; i < mes + 1; i++){
                                             out.println("<tr>");
                                                out.println("<td style='font-size: 16px; font-weight: bold;'>"+ i +"º mês </td>");
                                                
                                                double n = Math.ceil(capital * Math.pow(1 +(taxa/100),i));
                                                out.println("<td>R$ "+ n +"</td>");
                                        }
                                    out.println("</table>");
                                    
                                    double  montante = capital * Math.pow((1 + taxa / 100), mes);
                                    double juros = montante - capital;
                                    out.println("<p class='resposta'>O valor do juros é de R$ "+juros+"</p>");
                                    
                                   montante = Math.ceil(capital * Math.pow(1 +(taxa/100),mes));
                                   out.println("<p class='resposta'>O montante é de R$ "+montante +"</p>");
                               
                                } catch (NumberFormatException ex){
                                    out.println("<p class='resposta'>Erro ao calcular os campos</p>");
                                }
                            }
                                                       
                           out.println("<br/>");
                           out.println("<button><a href='index.html'>Voltar</a></button>"); 
                    out.println("</form>");               
                out.println("</body>");
            out.println("</html>");
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
