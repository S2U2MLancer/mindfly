package slancer.mindfly.service.account.dao;



import org.apache.ibatis.annotations.Mapper;

import slancer.mindfly.service.account.entity.account.WeichatAccountEntity;

@Mapper
public interface WeichatDao {

	int create(WeichatAccountEntity entity);

	WeichatAccountEntity getById(String id);

}
