package xin.tianchuang.modules.spider.dao;

import xin.tianchuang.modules.spider.entity.EntAnnualreportOutGuaranteeInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:08
 */
@Mapper
public interface EntAnnualreportOutGuaranteeInfoDao extends BaseMapper<EntAnnualreportOutGuaranteeInfoEntity> {

	boolean insertBatch(List<EntAnnualreportOutGuaranteeInfoEntity> list);
	
}