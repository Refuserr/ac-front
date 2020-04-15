package pers.ls.exchange.ac.front.entity;

import org.apache.ibatis.annotations.Param;
import pers.ls.exchange.ac.front.entity.Brand;

public interface BrandMapper {
    Brand selectById(@Param("id") Long id);
}
