package com.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

public class JwtFilter extends GenericFilterBean {

    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final String Authorization = request.getHeader("Authorization");
        Token td = new Token(Authorization);
        if (td.isStatus()) {
            response.setStatus(HttpServletResponse.SC_OK);
            System.out.println(Authorization);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            throw new ServletException("Missing or invalid Authorization header");
        }

        /*
      
       

        final String authHeader = request.getHeader("Authorization");
        String context = request.getContextPath();
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(req, res);
        } else {
            try {
                if (authHeader.indexOf("Bearer ") < 0) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//					return;
//					return "Missing";
                    throw new ServletException("Missing or invalid Authorization header");
                }
                final String token = authHeader.substring(7);
                try {
                    final Claims claims = Jwts.parser().setSigningKey(new TokenDecoder().tokensecretkey).parseClaimsJws(token).getBody();
                    String issuer = claims.getIssuer();
                    if (!issuer.equalsIgnoreCase(context)) {
                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                        return;
//						return "Missing";
//						 throw new ServletException("Missing or invalid Authorization header");

                    } else {
                        request.setAttribute("claims", claims);
                    }
                } catch (final SignatureException e) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
//					throw new ServletException("Missing or invalid Authorization header");
                }
                chain.doFilter(req, res);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
//				throw new ServletException("Missing or invalid Authorization header");
            }
        }
         */
    }

}
