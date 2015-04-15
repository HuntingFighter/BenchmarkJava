package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10430")
public class BenchmarkTest10430 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = new Test().doSomething(param);
		
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
		} catch (Exception e) {
			// OK to swallow any exception
			System.out.println("File exception caught and swallowed: " + e.getMessage());
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a75430 = param; //assign
		StringBuilder b75430 = new StringBuilder(a75430);  // stick in stringbuilder
		b75430.append(" SafeStuff"); // append some safe content
		b75430.replace(b75430.length()-"Chars".length(),b75430.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map75430 = new java.util.HashMap<String,Object>();
		map75430.put("key75430", b75430.toString()); // put in a collection
		String c75430 = (String)map75430.get("key75430"); // get it back out
		String d75430 = c75430.substring(0,c75430.length()-1); // extract most of it
		String e75430 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d75430.getBytes() ) )); // B64 encode and decode it
		String f75430 = e75430.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g75430 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g75430); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass