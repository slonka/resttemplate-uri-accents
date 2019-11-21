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

RestTemplate underneath uses `java.net.URI` which causes the request to fail.
