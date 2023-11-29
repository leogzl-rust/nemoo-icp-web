package net.ysh.nemoo.command;

import javax.servlet.http.HttpServletRequest;

import net.ysh.nemoo.bean.Nemoo;

public interface NemooCommand {

	public String getIcpCommand(HttpServletRequest request) throws Exception;

	public Nemoo getFish(HttpServletRequest request, Nemoo nemoo) throws Exception;

	public Nemoo getFisher(HttpServletRequest request, Nemoo nemoo) throws Exception;

	public Nemoo saveFish(HttpServletRequest request, Nemoo nemoo) throws Exception;

	public Nemoo saveFisher(HttpServletRequest request, Nemoo nemoo) throws Exception;
}
