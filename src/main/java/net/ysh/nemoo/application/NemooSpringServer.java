package net.ysh.nemoo.application;

import org.springframework.boot.SpringApplication;

import net.ysh.YshSpringBootServlet;
import net.ysh.util.LLog;
import net.ysh.util.YshUtil;

public class NemooSpringServer {

	public NemooSpringServer() {
		LLog.info("Nemoo Spring Server initializing ...");
	}

	/**
	 * This method is executed by mvn spring-boot:run
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		YshUtil.printVersion(NemooSpringServer.class);
		
		LLog.info("NemooSpringServer is opening . . .");
		SpringApplication.run(YshSpringBootServlet.class, new String[0]);
		LLog.info("NemooSpringServer is running.");
	}
}
