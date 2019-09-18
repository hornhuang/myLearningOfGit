package yuanhao.test.one;

public class StringUtil {

	/**
	 * 鍒嗗壊瀛楃涓� 濡傛灉寮�濮嬩綅缃ぇ浜庡瓧绗︿覆闀垮害锛岃繑鍥炵┖
	 * 
	 * @param str
	 * @param start
	 * @param end
	 * @return
	 */
	public static String substring(String str, int start, int end) {
		// f:寮�濮嬩綅缃� t:缁撴潫浣嶇疆
		if (start > str.length() || start < 0 || end < 0)
			return null;
		if (end > str.length()) {
			return str.substring(start, str.length());
		} else {
			return str.substring(start, end);
		}
	}

	/**
	 * 鍒ゆ柇瀛楃涓诧紙鏃ユ湡锛夋槸鍚︿负鏁板瓧
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumer(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
