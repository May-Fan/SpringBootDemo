import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;


@SpringBootApplication
@EnableScheduling
@ComponentScan("com.example")
public class DemoApplication {
  private static ConfigurableApplicationContext context;

  public static void main(String[] args) {
    DemoApplication.context =
            SpringApplication.run(DemoApplication.class, args);
  }

  @PreDestroy
  public void close() {
    DemoApplication.context.close();
  }
}
