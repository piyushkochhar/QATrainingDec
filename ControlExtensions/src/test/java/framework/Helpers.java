package framework;

public final class Helpers {

	public static String getTextAfter(String str, String delimeter) {
		String[] split = str.split(delimeter);
		if(split.length < 2) {
			throw new RuntimeException(str + " could not be split by delimeter " + delimeter);
		}
		String last = split[split.length-1];
		String lastTrimmed = last.trim();
		return lastTrimmed;
	}
}