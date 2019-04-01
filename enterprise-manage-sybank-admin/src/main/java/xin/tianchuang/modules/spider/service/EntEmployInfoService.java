package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntEmployInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:01
 */
public interface EntEmployInfoService extends IService<EntEmployInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEntName(String entName);
	
	List<EntEmployInfoEntity> selectByEntName(String name);

}
