package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntBaseLegalInfoEntity;

import java.util.Map;

/**
 * 企业法人信息
 *
 * @author hui.deng
 * @email 
 * @date 2019-02-23 10:02:12
 */
public interface EntBaseLegalInfoService extends IService<EntBaseLegalInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

