package com.board.service;

import com.board.ds.BoardDs;
import com.common.AjaxUtil;
import com.common.AppService;
import com.common.LoginUtil;
import com.common.ServiceForward;
import com.dto.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.regex.Pattern;

import static com.common.Constants.BASIC_VIEW_PATH;

public class AjaxBoardWriteProcessService implements AppService {
    @Override
    public ServiceForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인 여부 확인
        if (!LoginUtil.isLogin(request)) {

            return AjaxUtil.buildAjaxResult
                    (request, false, "잘못된 접근입니다.");

        }
        // 데이터 검사
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        if (title == null || title.equals("") || title.length() > 50
            || contents == null || contents.equals("")) {

            return AjaxUtil.buildAjaxResult
                  (request, false, "잘못된 접근입니다.");
            }

        // 저장
        BoardDTO dto = BoardDTO.builder()
                .title(title)
                .contents(contents)
                .registerId(LoginUtil.getMemberId(request))
                .build();

        BoardDs ds = new BoardDs();

        boolean isSuccess = ds.insertBoard(dto);

        if (!isSuccess) {
            return AjaxUtil.buildAjaxResult
                    (request, false, "글 등록에 실패하였습니다.");

        }

        return AjaxUtil.buildAjaxResult
                (request, true, "글을 등록하였습니다.");
    }
}
