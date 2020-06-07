package com.example.servicediscovery;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController {

	@Autowired
	Environment environment;

	@GetMapping("/echo/{string}")
	public String echo(@PathVariable String string) throws UnknownHostException {
		return String.format("From Discovery provider :%s. ip-port:%s-%s", string,
			InetAddress.getLocalHost().getHostAddress(), environment.getProperty("local.server.port"));
	}
}
