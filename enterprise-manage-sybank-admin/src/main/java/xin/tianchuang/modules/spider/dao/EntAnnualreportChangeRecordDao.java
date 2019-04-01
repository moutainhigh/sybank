package xin.tianchuang.modules.spider.dao;

import xin.tianchuang.modules.spider.entity.EntAnnualreportChangeRecordEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:09
 */
@Mapper
public interface EntAnnualreportChangeRecordDao extends BaseMapper<EntAnnualreportChangeRecordEntity> {

	boolean insertBatch(List<EntAnnualreportChangeRecordEntity> list);
	
}
