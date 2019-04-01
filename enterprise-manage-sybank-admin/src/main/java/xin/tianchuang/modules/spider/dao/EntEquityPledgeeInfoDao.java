package xin.tianchuang.modules.spider.dao;

import java.util.List;

import xin.tianchuang.modules.spider.entity.EntEquityPledgeeInfoEntity;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:04
 */
@Mapper
public interface EntEquityPledgeeInfoDao extends BaseMapper<EntEquityPledgeeInfoEntity> {

	boolean insertBatch(List<EntEquityPledgeeInfoEntity> list);
	
}
