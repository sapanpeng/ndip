//package com.tenghong.ndip.config;
//
//import org.apache.commons.lang3.StringUtils;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// *
// * @ClassName: CrossOriginFilter
// * @Description: 跨域访问设置
// * @author Tng
// * @date 2017年2月21日 下午11:00:20
// *
// */
//public class CrossOriginFilter implements Filter {
//
//	private FilterConfig config = null;
//
//	@Override
//	public void init(FilterConfig config) throws ServletException {
//		this.config = config;
//	}
//
//	@Override
//	public void destroy() {
//		this.config = null;
//	}
//
//	/**
//	 *
//	 * @author wwhhf
//	 * @since 2016/5/30
//	 * @comment 跨域的设置
//	 */
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletResponse httpResponse = (HttpServletResponse) response;
//		// 表明它允许"http://xxx"发起跨域请求
//		String origin = config.getInitParameter("AccessControlAllowOrigin");
//		if (StringUtils.isNotBlank(origin)) {
//			for (String orig : origin.split(",")) {
//				httpResponse.setHeader("Access-Control-Allow-Origin", orig);
//			}
//		}
//
//		// 表明它允许xxx的外域请求
//		httpResponse.setHeader("Access-Control-Allow-Methods", config.getInitParameter("AccessControlAllowMethods"));
//		// 表明它允许跨域请求包含xxx头
//		httpResponse.setHeader("Access-Control-Allow-Headers", config.getInitParameter("AccessControlAllowHeaders"));
//		chain.doFilter(request, response);
//	}
//}
