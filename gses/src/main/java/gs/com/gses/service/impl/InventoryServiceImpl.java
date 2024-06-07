package gs.com.gses.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gs.com.gses.mapper.InventoryMapper;
import gs.com.gses.model.entity.Inventory;
import gs.com.gses.service.InventoryService;
import org.springframework.stereotype.Service;

/**
* @author lirui
* @description 针对表【Inventory】的数据库操作Service实现
* @createDate 2024-05-29 18:34:17
*/
@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory>
    implements InventoryService {

}




