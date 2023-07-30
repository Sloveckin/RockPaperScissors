package config;

import exception.ConfigException;

public interface ConfigReader {
    Config readConfig() throws ConfigException;
}
