package com.springboot.main;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter {

	final static public String SMUNIVERSALID = "sm_universalid";
	final static public String GUID = "GUID";
	final static public String REFERRER_HEADER = "Referer";

	// CORS
	final static public String PUBLIC_GUID_COOKIE_NAME = "blueboxpublic";
	final static public String WEB_URL_ORIGIN_HEADER = "Origin";
	

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		 response.addHeader("Access-Control-Allow-Origin", "*");//Any external website can access resources in GMIP.
      
            // CORS "pre-flight" request
            response.addHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
            response.addHeader("Access-Control-Allow-Headers", "GUID");
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addHeader("Access-Control-Max-Age", "600");
       	
		
		filterChain.doFilter(req, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}