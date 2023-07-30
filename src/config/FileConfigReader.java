package config;

import exception.ConfigException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileConfigReader implements ConfigReader {

    public static final String FILE = "Config.txt";

    @Override
    public Config readConfig() throws ConfigException {
        try (final BufferedReader reader = Files.newBufferedReader(Paths.get(FILE))) {
            final String[] parts = reader.readLine().split(",\s");
            final String gameName = String.join("-", parts);
            final Map<String, Set<String>> mapItems = new HashMap<>();

            String input;
            while ((input = reader.readLine()) != null) {
                final String[] pair = input.split("\s>\s");
                checkItems(mapItems, pair[0], pair[1]);
                if (!mapItems.containsKey(pair[0])) {
                    mapItems.put(pair[0], new HashSet<>());
                }
                mapItems.get(pair[0]).add(pair[1]);
            }
            return new Config(gameName, mapItems, parts);
        } catch (final IOException e) {
            throw new ConfigException("Exception while creating config..", e.getCause());
        }
    }


    private static void checkItems(final Map<String, Set<String>> map, final String a, final String b)
            throws ConfigException {
        if (a.equals(b)) {
            throw new ConfigException(String.format("Unacceptable %s > %s", a, b));
        }

        if (map.get(b) != null && map.get(b).contains(a)) {
            throw new ConfigException(String.format("Unacceptable %s > %s and %s > %s", a, b, b, a));
        }
    }

}
