package gs.com.gses.mapper;

import gs.com.gses.model.entity.InventoryItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lirui
* @description 针对表【InventoryItem】的数据库操作Mapper
* @createDate 2024-05-29 18:45:09
* @Entity gs.com.gses.model.entity.InventoryItem
*/
@Mapper
public interface InventoryItemMapper extends BaseMapper<InventoryItem> {

}




