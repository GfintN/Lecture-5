package by.it.academy.example.filters;

import by.it.academy.example.osparameters.MACReader;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebFilter(urlPatterns = "/setNumbers")
public class MACFilter extends HttpFilter {
    private final List<String> BLOCKED_MAC = List.of("00-01-02-03-04-05-AA", "00-01-02-03-04-05-AB",
            "00-01-02-03-04-05-AC");
    private final MACReader macAddress = new MACReader();

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
       if(BLOCKED_MAC.contains(macAddress.GetMAC())){
           chain.doFilter(req,res);
       }else {
           res.getWriter().write("Your MAC BLOCKED");
       }
    }
}
