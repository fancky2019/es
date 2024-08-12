package gs.com.gses.service;

import gs.com.gses.model.elasticsearch.ShipOrderInfo;
import gs.com.gses.model.request.ShipOrderInfoRequest;
import gs.com.gses.model.response.PageData;
import org.springframework.stereotype.Service;

@Service
public interface OutBoundOrderService {
    void taskComplete(long wmsTaskId) throws Exception;

    PageData<ShipOrderInfo> search(ShipOrderInfoRequest request);

    void addBatch() throws Exception;

    boolean deleteShipOrderInfo() ;

    void initInventoryInfoFromDb()  ;
}
