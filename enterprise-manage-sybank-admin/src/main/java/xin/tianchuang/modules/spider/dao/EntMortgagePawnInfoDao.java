package xin.tianchuang.modules.spider.dao;

import xin.tianchuang.modules.spider.entity.EntMortgagePawnInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:05
 */
@Mapper
public interface EntMortgagePawnInfoDao extends BaseMapper<EntMortgagePawnInfoEntity> {

	boolean insertBatch(List<EntMortgagePawnInfoEntity> list);
	
}
