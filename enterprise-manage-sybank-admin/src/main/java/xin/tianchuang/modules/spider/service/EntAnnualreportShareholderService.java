package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntAnnualreportShareholderEntity;

import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:08
 */
public interface EntAnnualreportShareholderService extends IService<EntAnnualreportShareholderEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEntNameBelongYear(String entName, String belongYear);
}

