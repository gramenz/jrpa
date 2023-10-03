package net.gramenz.jrpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
// ########## App
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import net.gramenz.jrpa.lib.Config;

// ########## Websocket
/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
*/

@SpringBootApplication
@EnableScheduling
// ########## Websocket
/*
@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
*/
public class Jrpa /*implements WebSocketConfigurer, WebSocketMessageBrokerConfigurer*/ {
  @Autowired
  private Config config;

	// ########## App

	public static void main(String[] args) {
		SpringApplication.run(Jrpa.class, args);
	}

	// ########## Websocket

	// Client-Zugriff: z.B., ws://localhost:8081/websocket/topic/greeting

	/*
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
			config.enableSimpleBroker("/topic");
			config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
			registry.addEndpoint("/websocket").withSockJS();
	}

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		int webSocketPort = config.getWsServerPort();
		System.out.println("--------" + webSocketPort + "  - " + config.getWsServerPort());
			return new ServerEndpointExporter();
	}
	*/
}
