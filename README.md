## java.net.URI / RestTepmlate problems with international domains.

This repo shows how `java.net.URI` does not validate the contents of an URI in one version of it's constructor.

If you use this constructor an object will be created but it's filled with nulls instead of actual values:
```java
URI uri = new URI("http://www.pamięć.pl");
uri.getHost(); // this is null
```

This version will validate the contents of the URI:

```java
URI uri = new URI("http", null, "www.pamięć.pl", 80, null, null, null);
```

RestTemplate [underneath uses](https://github.com/spring-projects/spring-framework/blob/master/spring-web/src/main/java/org/springframework/web/util/DefaultUriBuilderFactory.java#L400) `java.net.URI` which causes the request to fail.

Check https://github.com/slonka/resttemplate-uri-accents/blob/master/src/main/java/net/slonka/resttemplateuriaccents/ResttemplateUriAccentsApplication.java
for an example.
