package practice.test;

class Indentation {

    public static void main(String args[]) {
        System.out.println("Hello World");
        String input = "public class PrettyPrint { public static void main(String args[]) { System.out.println(\"Hello { } ; {; World\"); String input = \"This is a sample code\"; System.out.println(Indent(input)); } public static String Indent(String input) { return \"Indented: \" + input; } }";
        System.out.println(Indent(input));

    }

    public static String Indent(String input) {
        //Code goes here
        int count = 0;
        boolean isNewLine = true;
        boolean inQuotes = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++) {
        	char c = input.charAt(i);
        	
        	if(inQuotes) {
        		// in quotes all characters are on same line, no special characters
        		sb.append(c);
        		if(c == '"') {
        			inQuotes = false;
        		}
        		continue;
        	}

        	// handle special characters
        	switch(c){
        	case '{':
        		count += 4;
        		sb.append(c);
        		sb.append("\n");
        		isNewLine = true;
        		break;

        	case '}':
        		count -= 4;
        		if(isNewLine && count > 0) {
        			sb.append(String.format("%" + count + "s", ""));
        		}
        		sb.append(c);
        		sb.append("\n");
        		isNewLine = true;
        		break;

        	case ';':
        		sb.append(c);
        		sb.append("\n");
        		isNewLine = true;
        		break;

        	default:
        		if(isNewLine) {
        			if (c == ' ') {
        				continue;
        			}

        			if(count > 0) {
        				sb.append(String.format("%" + count + "s", ""));
        			}
        		}
        		sb.append(c);
        		if(c == '"') {
        			inQuotes = true;
        		}
        		isNewLine = false;
        		break;
        	}
        }
        return sb.toString();
    }
}
