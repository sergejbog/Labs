package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BalloonOrderServlet", urlPatterns = "/doBalloonOrder")
public class BalloonOrderServlet extends HttpServlet {
    private final BalloonService ballonService;
    private final SpringTemplateEngine springTemplateEngine;

    public BalloonOrderServlet(BalloonService ballonService, SpringTemplateEngine springTemplateEngine) {
        this.ballonService = ballonService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        context.setVariable("color", req.getSession().getAttribute(("color")));
        context.setVariable("size", req.getSession().getAttribute(("size")));
        springTemplateEngine.process("deliveryInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("clientName", req.getParameter("clientName"));
        req.getSession().setAttribute("clientAddress", req.getParameter("clientAddress"));
        resp.sendRedirect("/confirmationInfo");
    }
}
