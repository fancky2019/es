package gs.com.gses.service;


import com.baomidou.mybatisplus.extension.service.IService;
import gs.com.gses.model.entity.WmsTask;

/**
* @author lirui
* @description 针对表【WmsTask】的数据库操作Service
* @createDate 2024-05-28 19:24:33
*/
public interface WmsTaskService extends IService<WmsTask> {

    WmsTask test();
}
