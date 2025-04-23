package com.dao;

import com.entity.PaishexuantuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PaishexuantuView;

/**
 * 拍摄选图 Dao 接口
 *
 * @author 
 */
public interface PaishexuantuDao extends BaseMapper<PaishexuantuEntity> {

   List<PaishexuantuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
