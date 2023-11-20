package com.diplomado.tarea;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@SpringBootApplication
public class TareaApplication {

	private static final Logger log = LoggerFactory.getLogger(TareaApplication.class);


	public static void main(final String[] args) {
		final SpringApplication springApplication = new SpringApplication(TareaApplication.class);
		logApplicationStartup(springApplication.run(args).getEnvironment());
	}

	private static void logApplicationStartup(final Environment env) {
		final String protocol = Optional.ofNullable(env.getProperty("server.ssl.key-store"))
				.map(key -> "https")
				.orElse("http");
		final String serverPort = env.getProperty("server.port");
		final String contextPath = Optional
				.ofNullable(env.getProperty("server.servlet.context-path"))
				.filter(StringUtils::isNotBlank)
				.orElse("/");
		String hostAddress = "localhost";

		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.warn("The host name could not be determined, using 'localhost' as fallback");
		}

		log.info(
                """

                        ----------------------------------------------------------
                        \tApplication '{}' is running! Access URLs:
                        \tLocal: \t\t{}://localhost:{}{}
                        \tExternal: \t{}://{}:{}{}
                        \tProfile(s): \t{}
                        ----------------------------------------------------------""",
				env.getProperty("spring.application.name"),
				protocol,
				serverPort,
				contextPath,
				protocol,
				hostAddress,
				serverPort,
				contextPath,
				env.getActiveProfiles()
		);
	}

}
