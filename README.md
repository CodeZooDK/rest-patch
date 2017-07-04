# rest-patch

This library aims to aid in supporting patching for requests in Java-based RESTFUL webservices. It is not tied into Spring in anyway, but all examples here are shown using Spring Boot. It aims to support the logical way of handling REST in services like [Stripe](https://stripe.com) and [Previsto](https://previsto.com) and hence it support JSON and FORM based requests.

## What does i do?
It will allow you to use POJO's as REST input while registering the actual fields sent by the client. These information you can use for patching the recieved POJO upon a another POJO of same type.

__Merge Example__
```Java
public void main() {
  EntityMerger merger = new EntityMerger();
  Pet patch = new Pet();
  patch.setName("Bella");
  path.setKind(Kind.Cat);
  
  Pet original = new Pet();
  original.setName("Barkley");
  original.setKind(Kind.Dog);
  
  List<String> dirtyFields = Collections.singletonList("name");
  merger.mergeEntities(original, patch, dirtyFields);
  
  System.out.println(original.getName()); // Outputs "Bella" (Was patched)
  System.out.println(original.getKind()); // Outputs "Dog" (Was NOT patched)  
}
```
