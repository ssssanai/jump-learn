package com.ssanai.jumplearn.filter;

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
public class LoginCheckFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;
		HttpSession session = req.getSession();

		String reqPath = req.getServletPath();
		//	비로그인 시에 접속 가능한 URL
		if (reqPath.equals("/member/login")
				|| reqPath.equals("/main")
				|| reqPath.startsWith("/resources/")
				|| reqPath.startsWith("/admin/")
				|| reqPath.startsWith("/teacher/")
                || reqPath.startsWith("/post/")
                || reqPath.startsWith("/edu/")
                || reqPath.startsWith("/activity/")
                || reqPath.startsWith("/info/")
                || reqPath.startsWith("/lib/")
                || reqPath.startsWith("/news/")
                || reqPath.startsWith("/notice/")
		) {
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}
//
//		UserDTO udto = session.getAttribute("loginInfo");
//
//		if( udto instanceof MemberDTO) {
//
//		}
//

		MemberDTO dto = (MemberDTO) session.getAttribute("loginInfo");
		if (dto == null || dto.getId() == null) {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('로그인 후 사용 가능합니다!');location.href='/member/login';</script>");
			out.close();
			return;
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}
}
