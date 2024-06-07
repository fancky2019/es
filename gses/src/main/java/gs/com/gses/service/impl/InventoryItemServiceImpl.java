package gs.com.gses.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gs.com.gses.model.entity.InventoryItem;
import gs.com.gses.service.InventoryItemService;
import gs.com.gses.mapper.InventoryItemMapper;
import org.springframework.stereotype.Service;

/**
* @author lirui
* @description 针对表【InventoryItem】的数据库操作Service实现
* @createDate 2024-05-29 18:45:09
*/
@Service
public class InventoryItemServiceImpl extends ServiceImpl<InventoryItemMapper, InventoryItem>
    implements InventoryItemService{

}




