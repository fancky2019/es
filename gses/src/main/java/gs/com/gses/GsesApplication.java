package gs.com.gses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GsesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(GsesApplication.class, args);
        //关闭事件 注册JVM关闭钩子.总会执行，x 掉dos 窗没有执行
        //Ctrl+F2 (Windows/Linux) 或 ⌘F2 (Mac) 终止调试会话时，确实不会执行通过
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("执行关闭钩子...注册JVM关闭钩子");
            ctx.close(); // 确保Spring上下文正确关闭
        }));
    }

}
