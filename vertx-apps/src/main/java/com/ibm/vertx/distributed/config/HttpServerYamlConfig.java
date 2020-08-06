package com.ibm.vertx.distributed.config;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.example.util.Runner;

public class HttpServerYamlConfig extends AbstractVerticle {

  public static void main(String[] args) {
    Runner.runExample(HttpServerYamlConfig.class);
  }

  @Override
  public void start() throws Exception {
    super.start();

        ConfigStoreOptions optionsYaml = new ConfigStoreOptions();
        optionsYaml.setType("file");
        optionsYaml.setFormat("yaml");
        optionsYaml.setConfig(new JsonObject().put("path", "application.yml"));
        ConfigRetriever retrieverYaml = ConfigRetriever.create(vertx, new ConfigRetrieverOptions().addStore(optionsYaml));

        retrieverYaml.getConfig(yamlProps -> {
          System.out.println("Yaml Properties");
          System.out.println((yamlProps.result()));
          System.out.println(yamlProps.result().getInteger("port"));
          
        });
       
  }

}
