package com.example.application.user;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService _jwtService;
    @Autowired
    private UserDetailsService _userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeaders = request.getHeader("Authorization");

        if(authHeaders == null || !authHeaders.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeaders.substring(7);
        String username = _jwtService.extractUsername(token);

        if(username != null && SecurityContextHolder.getContext().getAuthentication() ==  null){
            UserDetails userDetails = _userDetailsService.loadUserByUsername(username);

            if(_jwtService.isValid(token, userDetails)){
                UsernamePasswordAuthenticationToken authToken =  new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
