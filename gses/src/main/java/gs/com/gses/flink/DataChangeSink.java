package gs.com.gses.flink;

import lombok.extern.slf4j.Slf4j;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataChangeSink extends RichSinkFunction<DataChangeInfo> {

//    transient RabbitTemplate rabbitTemplate;
//
//    transient ConfirmService confirmService;
//
//    transient TableDataConvertService tableDataConvertService;

    @Override
    public void invoke(DataChangeInfo value, Context context) {
        log.info("收到变更原始数据:{}", value);
//        //转换后发送到对应的MQ
//        if (MIGRATION_TABLE_CACHE.containsKey(value.getTableName())) {
//            String routingKey = MIGRATION_TABLE_CACHE.get(value.getTableName());
//            //可根据需要自行进行confirmService的设计
//            rabbitTemplate.setReturnsCallback(confirmService);
//            rabbitTemplate.setConfirmCallback(confirmService);
//            rabbitTemplate.convertAndSend(EXCHANGE_NAME, routingKey, tableDataConvertService.convertSqlByDataChangeInfo(value));
//        }
    }

    /**
     * 在启动SpringBoot项目是加载了Spring容器，其他地方可以使用@Autowired获取Spring容器中的类；但是Flink启动的项目中，
     * 默认启动了多线程执行相关代码，导致在其他线程无法获取Spring容器，只有在Spring所在的线程才能使用@Autowired，
     * 故在Flink自定义的Sink的open()方法中初始化Spring容器
     */
    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
//        this.rabbitTemplate = ApplicationContextUtil.getBean(RabbitTemplate.class);
//        this.confirmService = ApplicationContextUtil.getBean(ConfirmService.class);
//        this.tableDataConvertService = ApplicationContextUtil.getBean(TableDataConvertService.class);
    }
}
