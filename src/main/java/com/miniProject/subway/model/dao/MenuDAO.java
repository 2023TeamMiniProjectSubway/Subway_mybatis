package com.miniProject.subway.model.dao;

import java.util.List;
import java.util.Map;

public interface MenuDAO {

    int selectOrderCode();

    int selectSandwichCode();

    int insertOrderSandwich(Map<String, Object> insertOrderMap);

    int insertSandwichOption(Map<String, Object> insertOptionMap);

    int insertSubwayOrder(Map<String, Object> parameter);

}
