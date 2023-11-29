package net.ysh.nemoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.ysh.nemoo.bean.Nemoo;
import net.ysh.nemoo.bean.icp.Fish;
import net.ysh.nemoo.bean.icp.Fisher;
import net.ysh.nemoo.command.NemooCommand;
import net.ysh.nemoo.service.IcpNemooController;
import net.ysh.rest.YshRestConstant;
import net.ysh.rest.command.YshCommand;

@RestController
@RequestMapping(YshRestConstant.REST + YshRestConstant.V1)
public class NemooController implements NemooCommand, YshCommand {

	@Autowired
	private IcpNemooController nemooController;

	@Override
	@GetMapping(value = YshRestConstant.COMMAND)
	public String getCommand() {
		return getClass().getName();
	}

	@Override
	@GetMapping(value = IcpNemooController.GET_ICP_COMMAND)
	public String getIcpCommand() throws Exception {
		return nemooController.getCommand();
	}

	@Override
	@PostMapping(value = IcpNemooController.COMMAND_GET_FISH, //
			consumes = MediaType.APPLICATION_JSON_VALUE, //
			produces = MediaType.APPLICATION_JSON_VALUE //
	)
	public @ResponseBody Nemoo getFish(@RequestBody Nemoo input) throws Exception {
		Fish fish = nemooController.getFish(input.getFishId());

		Nemoo output = new Nemoo();
		output.setFish(fish);

		return output;
	}

	@Override
	@PostMapping(value = IcpNemooController.COMMAND_GET_FISHER, //
			consumes = MediaType.APPLICATION_JSON_VALUE, //
			produces = MediaType.APPLICATION_JSON_VALUE //
	)
	public @ResponseBody Nemoo getFisher(@RequestBody Nemoo input) throws Exception {
		Fisher fisher = nemooController.getFisher(input.getFisherId());

		Nemoo output = new Nemoo();
		output.setFisher(fisher);

		return output;
	}

	@Override
	@PostMapping(value = IcpNemooController.COMMAND_SAVE_FISH, //
			consumes = MediaType.APPLICATION_JSON_VALUE, //
			produces = MediaType.APPLICATION_JSON_VALUE //
	)
	public @ResponseBody Nemoo saveFish(@RequestBody Nemoo input) throws Exception {
		String message = nemooController.saveFish(input.getFish());

		Nemoo output = new Nemoo();
		output.setResponseMessage(message);

		return output;
	}

	@Override
	@PostMapping(value = IcpNemooController.COMMAND_SAVE_FISHER, //
			consumes = MediaType.APPLICATION_JSON_VALUE, //
			produces = MediaType.APPLICATION_JSON_VALUE //
	)
	public @ResponseBody Nemoo saveFisher(@RequestBody Nemoo input) throws Exception {
		String message = nemooController.saveFisher(input.getFisher());

		Nemoo output = new Nemoo();
		output.setResponseMessage(message);

		return output;
	}
}
