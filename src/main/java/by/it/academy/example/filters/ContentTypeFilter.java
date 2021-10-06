package by.it.academy.example.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = "/servlet-1")
public class ContentTypeFilter extends HttpFilter {
    private static final String ALLOWED_CONTENT_TYPE = "text/plain";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String contentType = req.getContentType();
        if (ALLOWED_CONTENT_TYPE.equals(contentType)) {
            chain.doFilter(req, res);
        } else {
            res.getWriter().write("Text plain only");
        }
    }
}
