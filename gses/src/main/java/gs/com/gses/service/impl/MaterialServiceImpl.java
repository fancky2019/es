package gs.com.gses.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import gs.com.gses.mapper.MaterialMapper;
import gs.com.gses.service.MaterialService;
import org.springframework.stereotype.Service;
import gs.com.gses.model.entity.Material;

/**
* @author lirui
* @description 针对表【Material】的数据库操作Service实现
* @createDate 2024-05-29 18:33:40
*/
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material>
    implements MaterialService {

}




