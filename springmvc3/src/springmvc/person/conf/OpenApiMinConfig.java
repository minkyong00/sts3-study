package springmvc.person.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Import({
  org.springdoc.core.utils.SpringDocConfiguration.class,
  org.springdoc.core.configuration.SpringDocConfiguration.class,
  org.springdoc.webmvc.core.SpringDocWebMvcConfiguration.class,
  org.springdoc.core.SwaggerUiConfigProperties.class,
  org.springdoc.core.SwaggerUiConfigParameters.class,
  org.springdoc.core.SpringDocConfigProperties.class
})
public class OpenApiMinConfig implements WebMvcConfigurer {
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
    registry.addResourceHandler("/swagger-ui/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/");
    registry.addResourceHandler("/swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
  }
}
