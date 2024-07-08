package filter;

import entity.BaseUser;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebFilter("/*")
public class LoginFilter implements Filter {

    private Set<String> allowedUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        allowedUrls = new HashSet<>();
        allowedUrls.add("/image"); // Allow access to /image URLs
        allowedUrls.add("/panel/login/login.xhtml"); 
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;
        
        String url = request.getRequestURI();
        
        HttpSession session = request.getSession();
        
        BaseUser user = (BaseUser) session.getAttribute("validUser");

        if (user == null && !isAllowed(url)) {
            if (shouldRedirectToLogin(url)) {
                // Redirect to login page
                response.sendRedirect(request.getContextPath()+"/panel/login/login.xhtml");
                return;
            }
        } else if (url.contains("logout")) {
            
            session.invalidate();
            response.sendRedirect(request.getContextPath()+"/panel/login/login.xhtml");
            return;
        }

        fc.doFilter(sr, sr1);
    }

    private boolean shouldRedirectToLogin(String url) {
        return url.contains("logout") || url.contains("private");
    }

    private boolean isAllowed(String url) {
        return allowedUrls.stream().anyMatch(url::startsWith);
    }

}
