package pl.coderslab.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "Filter2", urlPatterns = "/*")
public class Filter2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println(request.getHeader("User-Agent"));
        long startTime = System.currentTimeMillis();
        chain.doFilter(req, resp);
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
