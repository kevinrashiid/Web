package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
	
	private String name;
	private String capital;
	private String region;
	private long population;
	private String flag;
}
