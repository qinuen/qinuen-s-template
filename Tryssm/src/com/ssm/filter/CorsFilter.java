package com.ssm.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssm.util.CollectionUtil;
import com.ssm.util.StringUtil;

  
/**        
 * Title: ������ʴ���(������Դ����)    
 * Description: ���ǰ��˷���ܹ��еĿ�������
 * @author rico       
 * @created 2017��7��4�� ����5:00:09    
 */      
public class CorsFilter implements Filter {

	private String allowOrigin;
	private String allowMethods;
	private String allowCredentials;
	private String allowHeaders;
	private String exposeHeaders;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		allowOrigin = filterConfig.getInitParameter("allowOrigin");
		allowMethods = filterConfig.getInitParameter("allowMethods");
		allowCredentials = filterConfig.getInitParameter("allowCredentials");
		allowHeaders = filterConfig.getInitParameter("allowHeaders");
		exposeHeaders = filterConfig.getInitParameter("exposeHeaders");
	}

	  
	/** 
	 * @description ͨ��CORS����ʵ��AJAX�������,ֻҪ��CORS��Ӧͷд��response�����м���
	 * @author rico       
	 * @created 2017��7��4�� ����5:02:38      
	 * @param req
	 * @param res
	 * @param chain
	 * @throws IOException
	 * @throws ServletException     
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)     
	 */  
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String currentOrigin = request.getHeader("Origin");
		if (StringUtil.isNotEmpty(allowOrigin)) {
			List<String> allowOriginList = Arrays
					.asList(allowOrigin.split(","));
			if (CollectionUtil.isNotEmpty(allowOriginList)) {
				if (allowOriginList.contains(currentOrigin)) {
					response.setHeader("Access-Control-Allow-Origin",
							currentOrigin);
				}
			}
		}
		if (StringUtil.isNotEmpty(allowMethods)) {
			response.setHeader("Access-Control-Allow-Methods", allowMethods);
		}
		if (StringUtil.isNotEmpty(allowCredentials)) {
			response.setHeader("Access-Control-Allow-Credentials",
					allowCredentials);
		}
		if (StringUtil.isNotEmpty(allowHeaders)) {
			response.setHeader("Access-Control-Allow-Headers", allowHeaders);
		}
		if (StringUtil.isNotEmpty(exposeHeaders)) {
			response.setHeader("Access-Control-Expose-Headers", exposeHeaders);
		}
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
	}
}