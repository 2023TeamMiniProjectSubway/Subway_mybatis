package com.miniProject.subway.model.Service;

import com.miniProject.subway.model.dao.MenuDAO;
import com.miniProject.subway.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import static com.miniProject.subway.common.Template.getSqlSession;
import static com.miniProject.subway.controller.OrderController.priceBasket;

public class OrderService {

    private MenuDAO menuDAO;

    // 주문테이블에 회원아이디와 총금액 넣기
    public int insertMenu(Map<String, Object> parameter) {

        SqlSession sqlSession = getSqlSession();

        menuDAO = sqlSession.getMapper(MenuDAO.class);
        int result = menuDAO.insertSubwayOrder(parameter);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    // 주문번호 찾기
    public String getOrderCode(){

        SqlSession sqlSession = getSqlSession();

        menuDAO = sqlSession.getMapper(MenuDAO.class);
        int result = menuDAO.selectOrderCode();

        String code = String.valueOf(result);

        return code;
    }

    public void insertOrderSandwich (String sandwichcode, String ordercode, String sanName, String breadName, int price) {

        SqlSession sqlSession = getSqlSession();

        menuDAO = sqlSession.getMapper(MenuDAO.class);

        try {
            int result = menuDAO.insertOrderSandwich();
            sqlSession.commit();
        } catch (Exception e)  {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

    }

    public void insertSandwichOption(String sandwichCode, String OptionCode, String topping){

        SqlSession sqlSession = getSqlSession();

        menuDAO = sqlSession.getMapper(MenuDAO.class);

        try {
            int result = menuDAO.insertSandwichOption();
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
