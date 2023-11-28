package net.ysh.nemoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ysh.nemoo.bean.icp.IcpNemooController;
import net.ysh.nemoo.command.NemooCommand;
import net.ysh.nemoo.service.NemooService;
import net.ysh.rest.YshRestConstant;
import net.ysh.rest.command.YshCommand;

@RestController
@RequestMapping(YshRestConstant.REST + YshRestConstant.V1)
public class NemooController implements NemooCommand, YshCommand {

	@Autowired
	private NemooService nemooService;

	@Autowired
	private IcpNemooController nemooController;

	@Override
	@GetMapping(value = YshRestConstant.COMMAND)
	public String getCommand() {
		return getClass().getName();
	}

	@Override
	@GetMapping(value = "getIcpCommand")
	public String getIcpCommand() throws Exception {
		return nemooController.getCommand();
	}

}
