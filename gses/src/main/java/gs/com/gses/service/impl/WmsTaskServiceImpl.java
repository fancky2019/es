package gs.com.gses.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gs.com.gses.model.entity.WmsTask;
import gs.com.gses.model.entity.WmsTaskArchived;
import gs.com.gses.service.WmsTaskService;
import gs.com.gses.mapper.WmsTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * @author lirui
 * @description 针对表【WmsTask】的数据库操作Service实现
 * @createDate 2024-05-28 19:24:33
 */
@Service
public class WmsTaskServiceImpl extends ServiceImpl<WmsTaskMapper, WmsTask> implements WmsTaskService {


    @Override
    public WmsTask test() {
        BigInteger id = new BigInteger("475348933472325");
        WmsTask wmsTask = this.getById(id);
        return wmsTask;
    }
}




