package kr.or.GreenGround.GreenGroundserver.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import kr.or.GreenGround.GreenGroundserver.model.MapModel;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {

	@Autowired
	MapModel mapModel;

	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String showMap(String address) {
		StringBuilder html = new StringBuilder();
		String url = "https://openapi.naver.com/v1/map/geocode?query=" + address;
		String clientId = mapModel.getMap_client_id();
		String clientSecret = mapModel.getMap_secret_id();

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		request.addHeader("X-Naver-Client-Id", clientId);
		request.addHeader("X-Naver-Client-Secret", clientSecret);
		try {
			HttpResponse response = client.execute(request);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent(), "UTF-8"));

			String current = "";
			while ((current = reader.readLine()) != null) {
				html.append(current);
			}
			reader.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//확인
		System.out.println(html.toString());
		return "redirect:/";
	}
}
