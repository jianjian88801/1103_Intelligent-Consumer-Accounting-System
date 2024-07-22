package com.dao;

import com.entity.ZhichuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhichuView;

/**
 * 支出 Dao 接口
 *
 * @author 
 */
public interface ZhichuDao extends BaseMapper<ZhichuEntity> {

   List<ZhichuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
