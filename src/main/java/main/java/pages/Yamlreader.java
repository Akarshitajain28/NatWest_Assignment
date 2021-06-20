package main.java.pages;

import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlReader {
	String path=System.getProperty("user.dir")+"\\src\\test\\resources\\search_value\\search_value.yaml";
	public String yamlReader(String token) {
		try {
			Reader file= new FileReader(path);
			Yaml yaml=new Yaml();
			Map<String, Object> object = (Map<String, Object>) yaml.load(file);
			return (String) object.get(token);
		}
		catch (Exception e) {
			return "??" ;
		}
		
	}

}
