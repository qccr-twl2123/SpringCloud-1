package com.example.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class HelloService {
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "helloFallback")
	public String helloService() {
		long start = System.currentTimeMillis();
		String result = restTemplate.getForEntity("http://HELLO/hello", String.class).getBody();
		long end = System.currentTimeMillis();
		log.info("Spend time: " + (end - start));
		return result;
	}

	public String helloFallback() {
		return "error";
	}
}
