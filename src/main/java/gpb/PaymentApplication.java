package gpb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

import static gpb.utils.SomeUtils.getPortFromArgs;

@SpringBootApplication
public class PaymentApplication {
    private static final Logger log = LoggerFactory.getLogger(PaymentApplication.class);

    public static void main(String[] args) {
        String port = getPortFromArgs(args);

        SpringApplication app = new SpringApplication(PaymentApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", port));
        app.run(args);
    }

}
