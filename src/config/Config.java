package config;

import java.util.Map;
import java.util.Set;

public record Config(String gameName, Map<String, Set<String>> mapItem, String[] items) {

}
