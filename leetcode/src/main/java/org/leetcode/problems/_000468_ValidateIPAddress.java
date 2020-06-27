package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000468_ValidateIPAddress {
	public String validIPAddress(String IP) {
		if (isIPv4(IP))
			return "IPv4";
		if (isIPv6(IP))
			return "IPv6";
		return "Neither";
	}

	static boolean isIPv4(String IP) {
		String[] groups = IP.split("\\.", -1);
		int sepCount = 0;
		for (int i = 0; i < IP.length(); i++)
			if (IP.charAt(i) == '.')
				sepCount++;
		if (sepCount != 3)
			return false;
		for (String group : groups)
			if (!isDecimal(group))
				return false;
		return true;
	}

	static boolean isDecimal(String s) {
		try {
			int i = Integer.valueOf(s);
			System.out.println(i);
			return String.valueOf(i).equals(s) && i >= 0 && i <= 255;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	static boolean isIPv6(String IP) {
		String[] groups = IP.split("\\:", -1);
		int sepCount = 0;
		for (int i = 0; i < IP.length(); i++)
			if (IP.charAt(i) == ':')
				sepCount++;
		if (sepCount != 7)
			return false;
		for (String group : groups)
			if (!isHex(group))
				return false;
		return true;
	}

	static boolean isHex(String s) {
		if (s.length() > 4 || s.length() == 0 || s.charAt(0) == '-')
			return false;
		try {
			int h = Integer.parseInt(s, 16);
			return h >= 0;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}
