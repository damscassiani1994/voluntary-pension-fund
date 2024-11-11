package co.com.fpv.btg.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.fpv.btg.usecases",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern ="^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCaseConfig {
}
