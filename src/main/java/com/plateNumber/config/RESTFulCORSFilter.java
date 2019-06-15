/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.plateNumber.config;
import java.io.IOException;
import javax.annotation.Resource;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import org.springframework.stereotype.Component;
/**
 *
 * @author oswal
 */

@Component
public class RESTFulCORSFilter implements Filter, ContainerResponseFilter {
    @Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse) res;
		
		response.setHeader("Access-Control-Allow-Origin", "*");
                //response.setHeader("Access-Control-Allow-Origin", "https://developer.mozilla.org");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "*");
                response.setHeader("Access-Control-Allow-Headers", "Content-Type");
                
		chain.doFilter(req, res);
		
	}
 
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseCtx) throws IOException {
         responseCtx.getHeaders().add( "Access-Control-Allow-Origin", "*" );
         responseCtx.getHeaders().add("Access-Control-Allow-Origin", "*");
        responseCtx.getHeaders().add( "Access-Control-Allow-Credentials", "true" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Headers", "*");
        responseCtx.getHeaders().add( "Access-Control-Allow-Headers", "Content-Type");
    }
 
    
}
