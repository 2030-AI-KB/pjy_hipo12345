package com.board.service;

import com.board.ds.BoardDs;
import com.common.AppService;
import com.common.LoginUtil;
import com.common.ServiceForward;
import com.dto.BoardDTO;
import com.dto.SearchDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import static com.common.Constants.BASIC_VIEW_PATH;

public class BoardListService implements AppService {
    @Override
    public ServiceForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 데이터(페이지, 검색키워드, 검색카테고리, 정렬)
        String searchCategory = request.getParameter("searchCategory");
        String searchKeyword = request.getParameter("searchKeyword");
        String sort = request.getParameter("sort");

        String extraQuery = makeExtraQuery(searchCategory, searchKeyword, sort);
        if (extraQuery == null) {
            return ServiceForward.builder()
                    .fail(true)
                    .message("alert('잘못된 접근입니다.');location.href='/board/list.do';")
                    .build();
        }

        BoardDs ds = new BoardDs();
        List<BoardDTO> list = ds.selectBoardList(extraQuery);

        request.setAttribute("list", ds.selectBoardList(extraQuery));
        request.setAttribute("searchInfo", SearchDTO.builder()
                .searchCategory(searchCategory)
                .searchKeyword(searchKeyword)
                .sort(sort)
                .build());
        return ServiceForward.builder()
                .path(BASIC_VIEW_PATH + "board/list.jsp")
                .build();

    }

    private String makeExtraQuery(String searchCategory
                                  , String searchKeyword
                                 , String sort) {
                                 String extraQuery = "";
        if (searchKeyword != null && !searchKeyword.equals("")) {
            switch (searchCategory) {
                case "title":
                    extraQuery = " and a.title like '%" + searchKeyword + "%'";
                    break;
                case "contents":
                    extraQuery = " and a.contents like '%" + searchKeyword + "%'";
                    break;
                case "register":
                    extraQuery = " and b.login_id like '%" + searchKeyword + "%'";
                    break;
                default:
                    return null;
            }
        }

        if (sort == null) {
            sort = "recent";

        }
        switch (sort){
            case "recent":
                extraQuery += " order by a.register_datetime desc";
                break;
            case "old":
                extraQuery += " order by a.register_datetime asc";
                break;
            case "high":
                extraQuery += " order by a.hits desc";
                break;
            case "low":
                extraQuery += " order by a.hits asc";
                break;
            default:
                return null;
        }
        return extraQuery;
    }
}