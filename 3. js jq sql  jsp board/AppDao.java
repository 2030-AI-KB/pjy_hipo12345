package com.member;

import com.board.ds.BoardDs;
import com.dto.BoardDTO;
import com.dto.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.common.JdbcUtil.close;

public class AppDao {
    private Connection conn;

    private AppDao() {

    }

    private static class LazyHolder {
        private static final AppDao INSTANCE = new AppDao();
    }

    public static AppDao getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void setConnection(Connection conn) {
        this.conn = conn;
    }

    public boolean insertName(String name) {
        PreparedStatement pstmt = null;
        int count = 0;

        try {
            pstmt = conn.prepareStatement(
                    "insert into my_name(name) values (?)");
            pstmt.setString(1, name);
            count = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return count > 0 ? true : false;
    }

    public String selectNameById(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String name = null;

        try {
            pstmt = conn.prepareStatement(
                    "select name from my_name where id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return name;
    }

    public int selectAccountCountByLoginId(String loginId) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;

        try {
            pstmt = conn.prepareStatement(
                    "select count(*) from member where login_id=? and leaved=false");
            pstmt.setString(1, loginId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return count;
    }

    public boolean insertMemberInfo(MemberDTO dto) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count1 = 0;
        int count2 = 0;

        try {
            pstmt = conn.prepareStatement(
                    "insert into member_detail(name, mobile_no, birthday, email, zipcode, address, address_detail) " +
                            "values (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getMobileNo());
            pstmt.setObject(3, dto.getBirthday());
            pstmt.setString(4, dto.getEmail());
            pstmt.setString(5, dto.getZipcode());
            pstmt.setString(6, dto.getAddress());
            pstmt.setString(7, dto.getAddressDetail());
            count1 = pstmt.executeUpdate();
            if (count1 == 0) {
                close(rs);
                close(pstmt);
                return false;
            }

            rs = pstmt.getGeneratedKeys(); // 쿼리 실행 후 생성된 키 값 반환
            while (rs.next()) {
                dto.setMemberDetailId(rs.getInt(1));
            }

            pstmt = conn.prepareStatement(
                    "insert into member(login_id, password, member_detail_id) " +
                            "values (?, ?, ?)");
            pstmt.setString(1, dto.getLoginId());
            pstmt.setString(2, dto.getPassword());
            pstmt.setInt(3, dto.getMemberDetailId());
            count2 = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return count2 > 0 ? true : false;
    }

    public MemberDTO selectMemberInfoByLoginId(String loginId) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MemberDTO dto = null;

        try {
            pstmt = conn.prepareStatement(
                    "select" +
                            " a.id" +
                            " , a.login_id" +
                            " , a.password" +
                            " , b.name" +
                            " , b.birthday" +
                            " , b.mobile_no" +
                            " , b.email" +
                            " , b.zipcode" +
                            " , b.address" +
                            " , b.address_detail" +
                            " from member a" +
                            " inner join member_detail b on a.member_detail_id=b.id" +
                            " where login_id=? and leaved=false");
            pstmt.setString(1, loginId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                dto = MemberDTO.builder()
                        .id(rs.getInt("id"))
                        .loginId(rs.getString("login_id"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .birthday(LocalDate.parse(rs.getString("birthday")))
                        .mobileNo(rs.getString("mobile_no"))
                        .email(rs.getString("email"))
                        .zipcode(rs.getString("zipcode"))
                        .address(rs.getString("address"))
                        .addressDetail(rs.getString("address_detail"))
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return dto;
    }

    public MemberDTO selectMemberInfoById(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MemberDTO dto = null;

        try {
            pstmt = conn.prepareStatement(
                    "select" +
                            " a.id" +
                            " , a.login_id" +
                            " , a.password" +
                            " , b.name" +
                            " , b.birthday" +
                            " , b.mobile_no" +
                            " , b.email" +
                            " , b.zipcode" +
                            " , b.address" +
                            " , b.address_detail" +
                            " from member a" +
                            " inner join member_detail b on a.member_detail_id=b.id" +
                            " where a.id=? and a.leaved=false");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                dto = MemberDTO.builder()
                        .id(rs.getInt("id"))
                        .loginId(rs.getString("login_id"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .birthday(LocalDate.parse(rs.getString("birthday")))
                        .mobileNo(rs.getString("mobile_no"))
                        .email(rs.getString("email"))
                        .zipcode(rs.getString("zipcode"))
                        .address(rs.getString("address"))
                        .addressDetail(rs.getString("address_detail"))
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return dto;
    }

    public boolean updateMemberInfo(MemberDTO dto) {
        PreparedStatement pstmt = null;
        int count = 0;

        try {
            pstmt = conn.prepareStatement(
                    "update member_detail" +
                            " set" +
                            " name=?" +
                            ", birthday=?" +
                            ", mobile_no=?" +
                            ", email=?" +
                            ", zipcode=?" +
                            ", address=?" +
                            ", address_detail=?" +
                            " where id=(select member_detail_id from member where id=?)");
            pstmt.setString(1, dto.getName());
            pstmt.setObject(2, dto.getBirthday());
            pstmt.setString(3, dto.getMobileNo());
            pstmt.setString(4, dto.getEmail());
            pstmt.setString(5, dto.getZipcode());
            pstmt.setString(6, dto.getAddress());
            pstmt.setString(7, dto.getAddressDetail());
            pstmt.setInt(8, dto.getId());
            count = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return count > 0 ? true : false;
    }

    public String selectLoginIdForFindId(MemberDTO dto) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String loginId = null;

        try {
            pstmt = conn.prepareStatement(
                    "select" +
                            " a.login_id" +
                            " from member a" +
                            " inner join member_detail b on a.member_detail_id=b.id" +
                            " where b.name=?" +
                            " and b.mobile_no=?" +
                            " and b.email=?" +
                            " and a.leaved=false");
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getMobileNo());
            pstmt.setString(3, dto.getEmail());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                loginId = rs.getString("login_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return loginId;
    }

    public int selectMemberIdForFindPassword(MemberDTO dto) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int id = 0;

        try {
            pstmt = conn.prepareStatement(
                    "select" +
                            " a.id" +
                            " from member a" +
                            " inner join member_detail b on a.member_detail_id=b.id" +
                            " where b.name=?" +
                            " and b.mobile_no=?" +
                            " and b.email=?" +
                            " and a.login_id=?" +
                            " and a.leaved=false");
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getMobileNo());
            pstmt.setString(3, dto.getEmail());
            pstmt.setString(4, dto.getLoginId());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return id;
    }

    public boolean updateMemberPassword(MemberDTO dto) {
        PreparedStatement pstmt = null;
        int count = 0;

        try {
            pstmt = conn.prepareStatement(
                    "update member" +
                            " set " +
                            " password=?" +
                            " where id=?");
            pstmt.setString(1, dto.getPassword());
            pstmt.setInt(2, dto.getId());
            count = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return count > 0 ? true : false;
    }
    public boolean updateLeave(int id) {
        PreparedStatement pstmt = null;
        int count = 0;

        try {
            pstmt = conn.prepareStatement(
                    "update member" +
                            " set " +
                            " leaved=true" +
                            " where id=?");
            pstmt.setInt(1, id);
            count = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return count > 0 ? true : false;
    }

    public boolean insertBoard(BoardDTO dto) {
        PreparedStatement pstmt = null;
        int count = 0;

        try {
            pstmt = conn.prepareStatement(
                    "insert into" +
                            " board(title, contents,register_id)" +
                            " values (?, ?, ?)");
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getContents());
            pstmt.setInt(3, dto.getRegisterId());
            count = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return count > 0 ? true : false;
    }
    public List<BoardDTO> selectBoardList(String extraQuery) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<BoardDTO> list = new ArrayList<>(); // 목록은 null 체크 안함.

        try {
            pstmt = conn.prepareStatement(
                    "select " +
                            "a.id" +
                            ", a.title" +
                            ", a.contents" +
                            ", a.hits" +
                            ", a.register_datetime" +
                            ", b.login_id" +
                            " from board a" +
                            " inner join member b on a.register_id=b.id" +
                            " where a.deleted=false" + extraQuery);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardDTO dto = BoardDTO.builder()
                        .id(rs.getInt("id"))
                        .title(rs.getString("title"))
                        .contents(rs.getString("contents"))
                        .hits(rs.getInt("hits"))
                        .registerDatetime(rs.getString("register_datetime"))
                        .registerLoginId(rs.getString("login_id"))
                        .build();
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return list;
    }
}








