package com.ssanai.jumplearn.filter;


import com.ssanai.jumplearn.dto.AdminDTO;
import com.ssanai.jumplearn.dto.MemberDTO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.PrintWriter;

@Log4j2
@WebFilter("/*")
public class AdminLoginCheckFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;
		HttpSession session = req.getSession();

		String reqPath = req.getServletPath();

        AdminDTO dto = (AdminDTO) session.getAttribute("adminInfo");
		if (reqPath.equals("/admin/login")
				|| reqPath.equals("/main")
				|| reqPath.startsWith("/resources/")
                || reqPath.startsWith("/member/")
                || reqPath.startsWith("/teacher/")
		) {
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}
		if (dto == null || dto.getId() == null) {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('로그인 후 사용 가능합니다!');location.href='/admin/login';</script>");
			out.close();
			return;
		}



		filterChain.doFilter(servletRequest, servletResponse);
	}
}
