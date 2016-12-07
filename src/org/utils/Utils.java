package org.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Utils
{
	public static int randomInt(int min, int max)
	{
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
}
