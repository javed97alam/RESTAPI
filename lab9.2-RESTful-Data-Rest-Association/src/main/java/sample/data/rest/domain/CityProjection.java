package sample.data.rest.domain;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "CityProjection", types = City.class)
public interface CityProjection {

	public String getCountry();
}
