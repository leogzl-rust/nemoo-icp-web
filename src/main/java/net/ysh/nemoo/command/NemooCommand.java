package net.ysh.nemoo.command;

import net.ysh.nemoo.bean.Nemoo;

public interface NemooCommand {

	public String getIcpCommand() throws Exception;

	public Nemoo getFish(Nemoo nemoo) throws Exception;

	public Nemoo getFisher(Nemoo nemoo) throws Exception;

	public Nemoo saveFish(Nemoo nemoo) throws Exception;

	public Nemoo saveFisher(Nemoo nemoo) throws Exception;
}
