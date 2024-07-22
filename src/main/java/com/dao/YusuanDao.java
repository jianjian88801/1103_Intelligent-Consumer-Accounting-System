package com.dao;

import com.entity.YusuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YusuanView;

/**
 * 预算 Dao 接口
 *
 * @author 
 */
public interface YusuanDao extends BaseMapper<YusuanEntity> {

   List<YusuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
