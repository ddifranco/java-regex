import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class iso {

        public static void main(String[] args) {

		String eq1 = "(33.54, -116.66), mag = 0.30, depth = -10410.00, title = 2km SE of Anza, California";
		String eq2 = "(36.27, -121.66), mag = 2.00, depth = -7630.00, title = 28km SSE of Carmel Valley Village, California";
		String eq3 = "(35.00, -118.21), mag = 1.30, depth = 1010.00, title = Quarry Blast - 7km SSW of Mojave, California";

		String q1  = "(33.5";
		String q2  = "mag";

		boolean r1 = matchPhrase(q1, "begin", eq1);
		System.out.println(r1);

		boolean r2 = matchPhrase(q2, "any", eq1);
		System.out.println(r2);

		}

	public static boolean matchPhrase(String queryString, String queryType, String eqPhrase) {

		String markedUp = queryString;
		String spChars[] = {"(", ")", "-", "."};
		boolean valid = false;
		//markUp queryString<string>: markedUp<string>	*Replace special 
		for (String x:spChars) {
			String mod = "\\"+x;
			markedUp = markedUp.replace(x, mod);

			}

		if (queryType == "begin") {
			markedUp = "^"+markedUp+".*";
			valid = true;
			}

		if (queryType == "end") {
			markedUp = ".*"+markedUp+"$";
			valid = true;
			}

		if (queryType == "any") {
			markedUp = ".*"+markedUp+".*";
			valid = true;
			}

		if (!valid) {

                    System.out.println("must be a problem with your params");
                    throw new IllegalArgumentException();

		    }		

		Pattern pattern = Pattern.compile(markedUp);
		Matcher m = pattern.matcher(eqPhrase);

		System.out.println(markedUp);
		System.out.println(eqPhrase);

		return m.matches();

		}
	}
