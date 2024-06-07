/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gs.com.gses.controller;

import gs.com.gses.aspect.RepeatPermission;
import gs.com.gses.model.elasticsearch.DemoProduct;
import gs.com.gses.model.elasticsearch.ShipOrderInfo;
import gs.com.gses.model.entity.WmsTask;
import gs.com.gses.model.request.DemoProductRequest;
import gs.com.gses.model.request.ShipOrderInfoRequest;
import gs.com.gses.model.response.MessageResult;
import gs.com.gses.model.response.PageData;
import gs.com.gses.service.OutBoundOrderService;
import gs.com.gses.service.WmsTaskService;
import gs.com.gses.service.elasticsearch.ESDemoProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/shipOrderInfo")
public class ShipOrderInfoController {

    @Autowired
    private WmsTaskService wmsTaskService;
    @Autowired
    private ESDemoProductService esDemoProductService;
    @Autowired
    private OutBoundOrderService outBoundOrderService;


    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "unknown user") String name) {
        return "Hello " + name;
    }

    @GetMapping("/getWmsTask")
    public MessageResult<WmsTask> getWmsTask() {
        return MessageResult.success(wmsTaskService.test());
    }

    @RepeatPermission
    @GetMapping("/esTest")
    public MessageResult<PageData<DemoProduct>> esTest(DemoProductRequest request) {

        return MessageResult.success(esDemoProductService.search(request));
    }

    @GetMapping("/taskComplete/{wmsTaskId}")
    public MessageResult<Void> taskComplete(@PathVariable("wmsTaskId") Long wmsTaskId) throws Exception {
        outBoundOrderService.taskComplete(wmsTaskId);
        return MessageResult.success();
    }

    @GetMapping("/getShipOrderInfoList")
    public MessageResult<PageData<ShipOrderInfo>> getShipOrderInfoList(ShipOrderInfoRequest request) {
        return MessageResult.success(outBoundOrderService.search(request));
    }

    @GetMapping("/addBatch")
    public MessageResult<Void> addBatch() throws Exception {
        outBoundOrderService.addBatch();
        return MessageResult.success();
    }

    @PostMapping("/deleteShipOrderInfo")
    public MessageResult<Void> deleteShipOrderInfo() throws Exception {
        outBoundOrderService.deleteShipOrderInfo();
        return MessageResult.success();
    }


}
