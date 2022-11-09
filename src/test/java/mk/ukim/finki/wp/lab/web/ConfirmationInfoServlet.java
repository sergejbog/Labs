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

@WebServlet(name = "ConfirmationInfoServlet", urlPatterns = "/confirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    private final BalloonService ballonService;
    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(BalloonService ballonService, SpringTemplateEngine springTemplateEngine) {
        this.ballonService = ballonService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        context.setVariable("color", req.getSession().getAttribute(("color")));
        context.setVariable("size", req.getSession().getAttribute(("size")));
        context.setVariable("clientName", req.getSession().getAttribute(("clientName")));
        context.setVariable("clientAddress", req.getSession().getAttribute(("clientAddress")));
        springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("");
    }
}
