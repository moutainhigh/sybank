package xin.tianchuang.modules.spider.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import xin.tianchuang.modules.spider.entity.EntCourtAnnounceInfoEntity;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-28 16:31:02
 */
@Mapper
public interface EntCourtAnnounceInfoDao extends BaseMapper<EntCourtAnnounceInfoEntity> {

    @Select("select count(*) from ENT_COURT_ANNOUNCE_INFO where BLTNTYPENAME != '裁判文书' and varchar(party2) like #{likeEntName}")
    Integer countAccused(@Param("likeEntName")String likeEntName);

	boolean insertBatch(List<EntCourtAnnounceInfoEntity> list);
}