package xin.tianchuang.modules.spider.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntAnnualreportEquityChangeInfoDao;
import xin.tianchuang.modules.spider.entity.EntAnnualreportEquityChangeInfoEntity;
import xin.tianchuang.modules.spider.service.EntAnnualreportEquityChangeInfoService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("entAnnualreportEquityChangeInfoService")
public class EntAnnualreportEquityChangeInfoServiceImpl extends ServiceImpl<EntAnnualreportEquityChangeInfoDao, EntAnnualreportEquityChangeInfoEntity> implements
		EntAnnualreportEquityChangeInfoService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<EntAnnualreportEquityChangeInfoEntity> page = this.selectPage(new Query<EntAnnualreportEquityChangeInfoEntity>(params).getPage(),
				new EntityWrapper<EntAnnualreportEquityChangeInfoEntity>());

		return new PageUtils(page);
	}

	@Override
	public Integer deleteByEntNameBelongYear(String entName, String belongYear) {
		Wrapper<EntAnnualreportEquityChangeInfoEntity> ew = new EntityWrapper<EntAnnualreportEquityChangeInfoEntity>();
		ew.eq("ent_name", entName);
		ew.eq("belong_year", belongYear);
		return this.baseMapper.delete(ew);
	}
	@Override
	public boolean insertBatch(List<EntAnnualreportEquityChangeInfoEntity> list) {
		return baseMapper.insertBatch(list);
		
	}
}
