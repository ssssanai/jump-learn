package com.ssanai.jumplearn.filter;

import com.ssanai.jumplearn.dto.MemberDTO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.AntPathMatcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@Log4j2
@WebFilter("/*")
public class LoginCheckFilter implements Filter {
	// 공개 접근 가능 URL 목록
	private static final String[] PUBLIC_URLS = {
			"/member/login", "/admin/login", "/teacher/login", "/member/register",
			"/main", "/edu/searchListPage", "/edu/viewPage", "/post/searchListPage",
			"/post/view", "/lib/searchListPage", "/lib/viewPage", "/info/searchListPage",
			"/info/viewPage", "/activity/searchListPage", "/activity/viewPage",
			"/news/searchListPage", "/news/viewPage", "/notice/searchListPage", "/notice/viewPage",
			"/resources/", "/static/", "/css/", "/js/", "/images/"
	};

	// 관리자 전용 URL 목록
	private static final String[] ADMIN_URLS = {
			"/admin/**", "/lib/delete", "/lib/editPage", "/lib/writePage",
			"/edu/delete", "/edu/editPage", "/edu/writePage", "/info/delete",
			"/info/editPage", "/info/writePage", "/notice/delete", "/notice/editPage",
			"/notice/writePage", "/news/delete", "/news/editPage", "/news/writePage",
			"/activity/delete", "/activity/editPage", "/activity/writePage"
	};

	// 일반 회원 전용 URL 목록
	private static final String[] MEMBER_URLS = {
			"/member/checkId", "/member/emailCheck", "/member/logout",
			"/member/ChangeInfo", "/member/delete", "/member/mypage",
			"/member/report_detail", "/member/report_list", "/course/**",
			"/post/deleteComment", "/post/deleteFile", "/post/deletePost",
			"/post/insertComment", "/post/like", "/post/report_insert_popup",
			"/post/updateComment", "/post/updateFile", "/post/updatePost",
			"/post/write", "/inquiry/**", "/basket/**", "/pay/**",
			"/studyroom/**", "/plan/**"
	};

	// 선생님 전용 URL 목록
	private static final String[] TEACHER_URLS = {
			"/teacher/logout", "/teacher/ChangeInfo", "/teacher/class_detail",
			"/teacher/final_grade_score_popup", "/teacher/final_score_popup",
			"/teacher/midterm_score", "/teacher/midterm_score_popup",
			"/teacher/myPage", "/teacher/notice_add_popup", "/teacher/questionDetail",
			"/teacher/questionList", "/teacher/studentList"
	};

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String path = request.getServletPath();
		HttpSession session = request.getSession(false);

		String referer = request.getHeader("Referer");

		// 1. 공개 URL 처리
		if (isPublicPath(path)) {
			chain.doFilter(request, response);
			return;
		}

		if (isAdminPath(path)) {
			// 2. 관리자 권한 체크
			log.warn(referer);
			if (session == null || session.getAttribute("adminInfo") == null) {
//				if(referer != null){
//					sendRedirect(response, referer);
//					return;
//				} else {
					sendRedirect(response, "/admin/login");
					return;
//				}
			}
		} else if (isTeacherPath(path)) {
			// 3. 선생님 권한 체크
			if (session == null || session.getAttribute("teacherInfo") == null) {
//				if(referer != null){
//					sendRedirect(response, referer);
//					return;
//				} else {
					sendRedirect(response, "/teacher/login");
					return;
//				}
			}
		} else if (isMemberPath(path)) {
			// 4. 일반 회원 권한 체크
			if (session == null || session.getAttribute("loginInfo") == null) {
//				if(referer != null){
//					log.warn(referer);
//					sendRedirect(response, referer);
//					return;
//				} else {
					sendRedirect(response, "/member/login");
					return;
//				}
			}
		}

		// 5. 세션 만료 체크
		if (session == null) {
			sendToMainPage(response, "/main");
			return;
		}

		chain.doFilter(request, response);
	}

	private boolean isPublicPath(String path) {
		return Arrays.stream(PUBLIC_URLS)
				.anyMatch(pattern -> new AntPathMatcher().match(pattern, path));
	}

	private boolean isAdminPath(String path) {
		return Arrays.stream(ADMIN_URLS)
				.anyMatch(pattern -> new AntPathMatcher().match(pattern, path));
	}

	private boolean isMemberPath(String path) {
		return Arrays.stream(MEMBER_URLS)
				.anyMatch(pattern -> new AntPathMatcher().match(pattern, path));
	}

	private boolean isTeacherPath(String path) {
		return Arrays.stream(TEACHER_URLS)
				.anyMatch(pattern -> new AntPathMatcher().match(pattern, path));
	}

	private void sendRedirect(HttpServletResponse response, String url) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>alert('비정상적인 접근입니다.');location.href='" + url + "';</script>");
		out.close();
	}

	private void sendToMainPage(HttpServletResponse response, String url) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>alert('세션이 만료되어 재로그인이 필요합니다.');location.href='" + url + "';</script>");
		out.close();
	}


}
