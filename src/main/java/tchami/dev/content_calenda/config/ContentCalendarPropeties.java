package tchami.dev.content_calenda.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "cc")
public record ContentCalendarPropeties(String welcomeMessage,String about) {
}
