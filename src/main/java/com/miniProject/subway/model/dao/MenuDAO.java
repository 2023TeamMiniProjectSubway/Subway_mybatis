package com.miniProject.subway.model.dao;

import java.util.List;
import java.util.Map;

public interface MenuDAO {

    int selectOrderCode();

    int selectSandwichCode();

    int insertOrderSandwich();

    int insertSandwichOption();

    int insertSubwayOrder(Map<String, Object> parameter);

}
