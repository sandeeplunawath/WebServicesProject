package webServices_SOAP;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SoapUIInteraction {
	public String SoapUIProcessing(String soapURL, String soapXml)
	{

		String responseData="";
		String line = "";
		// jEdit: = buffer.getText(0,buffer.getLength());
		TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
			public X509Certificate[] getAcceptedIssuers(){return null;}
			public void checkClientTrusted(X509Certificate[] certs, String authType){}
			public void checkServerTrusted(X509Certificate[] certs, String authType){}
		}};
		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) { return true; }
		};
		try {

			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier(hv);

			// Set the necessary header fields
			java.net.URL url = new java.net.URL(soapURL);
			java.net.URLConnection conn = url.openConnection();
			conn.setRequestProperty("SOAPAction", soapURL);
			conn.setDoOutput(true);
			// Send the request
			java.io.OutputStreamWriter wr = new java.io.OutputStreamWriter(conn.getOutputStream());
			wr.write(soapXml);
			wr.flush();
			// Read the response
			java.io.BufferedReader rd = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream()));

			while ((line = rd.readLine()) != null) { 
				//System.out.println(line); /*jEdit: print(line); */ 
				responseData = line;	
			}
		} catch (Exception e) {}

		return responseData;

	}

}