package com.example.servicediscovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceConsumerController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/echo/{str}")
	public String echo(@PathVariable String str) {
		return restTemplate.getForObject("http://service-provider/echo/" + str, String.class);
	}
}
