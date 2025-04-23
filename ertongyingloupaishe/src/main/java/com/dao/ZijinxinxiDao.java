package com.dao;

import com.entity.ZijinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZijinxinxiView;

/**
 * 资金信息 Dao 接口
 *
 * @author 
 */
public interface ZijinxinxiDao extends BaseMapper<ZijinxinxiEntity> {

   List<ZijinxinxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
