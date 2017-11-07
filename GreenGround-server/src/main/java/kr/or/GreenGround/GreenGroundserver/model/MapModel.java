package kr.or.GreenGround.GreenGroundserver.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MapModel {
	@Value("${map_client_id}")
	private String map_client_id;
	@Value("${map_secret_id}")
	private String map_secret_id;
	
	public String getMap_client_id() {
		return map_client_id;
	}
	public void setMap_client_id(String map_client_id) {
		this.map_client_id = map_client_id;
	}
	public String getMap_secret_id() {
		return map_secret_id;
	}
	public void setMap_secret_id(String map_secret_id) {
		this.map_secret_id = map_secret_id;
	}
	
}
