package by.it.academy.example.filters;

import by.it.academy.example.osparameters.IPReader;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebFilter(urlPatterns = "/*/")
public class IPFilter extends HttpFilter {
    private final List<String> BLOCKED_IP = List.of("128.0.0.2", "128.0.0.3", "128.0.0.4");
    private final IPReader ipAddress = new IPReader();

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (BLOCKED_IP.contains(ipAddress.GetIP())) {
            res.getWriter().write("Your IP BLOCKED");
        } else {

            chain.doFilter(req, res);
        }
    }
}
