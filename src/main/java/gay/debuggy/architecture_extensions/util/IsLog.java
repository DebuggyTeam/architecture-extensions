package gay.debuggy.architecture_extensions.util;

import net.minecraft.util.Identifier;

public class IsLog {
	public static boolean isLog(Identifier id) {
		if (id.getPath().startsWith("log_")) {
			return true;
		} else if (id.getPath().endsWith("_log")) {
			return true;
		} else if (id.getPath().equals("log")) {
			return true;
		} else {
			return false;
		}
	};
}
