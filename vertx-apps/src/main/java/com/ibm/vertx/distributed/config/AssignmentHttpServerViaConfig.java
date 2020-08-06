/*
 * package com.ibm.vertx.distributed.config;
 * 
 * import io.vertx.config.ConfigRetriever; import
 * io.vertx.config.ConfigRetrieverOptions; import
 * io.vertx.config.ConfigStoreOptions; import io.vertx.core.AbstractVerticle;
 * import io.vertx.core.json.JsonObject; import io.vertx.example.util.Runner;
 * 
 * public class AssignmentHttpServerViaConfig extends AbstractVerticle {
 * 
 * public static void main(String[] args) {
 * Runner.runExample(AssignmentHttpServerViaConfig.class); }
 * 
 * @Override public void start() throws Exception { super.start();
 * 
 * ConfigStoreOptions configStoreOptions = new ConfigStoreOptions();
 * configStoreOptions.setType("file"); configStoreOptions.setFormat("json");
 * //Optional as by default it is JSON configStoreOptions.setConfig(new
 * JsonObject().put("path", "application.json")); ConfigRetriever retriever =
 * ConfigRetriever.create(vertx, new
 * ConfigRetrieverOptions().addStore(configStoreOptions));
 * 
 * retriever.getConfig(config -> { if (config.succeeded()) {
 * System.out.println("Config is Ready"); JsonObject configRes =
 * config.result(); String message =
 * configRes.getJsonObject("application").getString("name"); int portNo =
 * configRes.getJsonObject("application").getInteger("port");
 * System.out.println("name as per JSON :: " + message);
 * System.out.println("port as per JSON :: " + portNo);
 * 
 * vertx.createHttpServer().requestHandler(request -> { //send response
 * request.response().end("<h1>" + message + "</h1>");
 * 
 * }).listen(portNo, httpServerAsyncResult -> { System.out.
 * println("Vertx HTTP Server via Fluent Pattern is up & running, ready to serve requests"
 * ); });
 * 
 * } else { System.out.println("Config Error : " + config.cause()); } });
 * 
 * }
 * 
 * }
 */