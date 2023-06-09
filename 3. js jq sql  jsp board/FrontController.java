package com.member;


import com.board.service.*;
import com.common.AppService;
import com.common.ServiceForward;
import com.example.service.MainService;
import com.member.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String command = request.getRequestURI();

        ServiceForward forward = null;

        try {
            if (command.equals("/")) {
                AppService service = new MainService();
                forward = service.execute(request, response);
            } else if (command.equals("/member/join/form.do")) {
                AppService service = new JoinFormService();
                forward = service.execute(request, response);
            } else if (command.equals("/member/check/id.do")) {
                AppService service = new AjaxCheckIdService();
                forward = service.execute(request, response);
            } else if (command.equals("/member/join.do")) {
                AppService service = new JoinService();
                forward = service.execute(request, response);
            } else if (command.equals("/login.do")) {
                AppService service = new LoginFormService();
                forward = service.execute(request, response);
            } else if (command.equals("/loginProcess.do")) {
                AppService service = new LoginProcessService();
                forward = service.execute(request, response);
            } else if (command.equals("/member/info.do")) {
                AppService service = new MemberInfoService();
                forward = service.execute(request, response);
            } else if (command.equals("/member/update.do")) {
                AppService service = new AjaxMemberUpdateService();
                forward = service.execute(request, response);
            } else if (command.equals("/logout.do")) {
                AppService service = new LogoutService();
                forward = service.execute(request, response);
            } else if (command.equals("/member/id/find.do")) {
                AppService service = new IdFindService();
                forward = service.execute(request, response);
            } else if (command.equals("/member/id/find/result.do")) {
                AppService service = new AjaxIdFindResultService();
                forward = service.execute(request, response);
            } else if (command.equals("/member/password/find.do")) {
                AppService service = new PasswordFindService();
                forward = service.execute(request, response);
            } else if (command.equals("/member/password/find/result.do")) {
                AppService service = new AjaxPasswordFindResultService();
                forward = service.execute(request, response);
            } else if (command.equals("/member/password/update.do")) {
                AppService service = new PasswordUpdateFormService();
                forward = service.execute(request, response);
            } else if (command.equals("/member/password/update/process.do")) {
                AppService service = new AjaxPasswordUpdateService();
                forward = service.execute(request, response);
            } else if (command.equals("/member/leave.do")) {
                AppService service = new LeaveService();
                forward = service.execute(request, response);
            } else if (command.equals("/board/list.do")) {
                AppService service = new BoardListService();
                forward = service.execute(request, response);
            } else if (command.equals("/board/write.do")) {
                AppService service = new BoardwriteService();
                forward = service.execute(request, response);
            } else if (command.equals("/board/write/process.do")) {
                AppService service = new AjaxBoardWriteProcessService();
                forward = service.execute(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!forward.isFail()) {
            if (forward.isRedirect()) {
                // 리다이렉트
                response.sendRedirect(forward.getPath());
            } else {
                // 포워드
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher(forward.getPath());
                dispatcher.forward(request, response);
            }
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>" + forward.getMessage() + "</script>");
            out.close();
        }

    }
}
