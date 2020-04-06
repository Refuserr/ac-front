package pers.ls.exchange.ac.front.se;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ls.exchange.ac.front.mapper.BrandMapper;

@Service
public class BrandService {

    @Autowired
    BrandMapper brandMapper;
    public String getBrandNameById(Long id){
        return brandMapper.selectById(1L).getName();
    }
}
