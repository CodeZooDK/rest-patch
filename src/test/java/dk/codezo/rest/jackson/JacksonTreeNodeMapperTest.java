package dk.codezo.rest.jackson;

import dk.codezo.rest.DummyEntity;
import dk.codezoo.rest.jackson.JacksonTreeNodeMapper;
import dk.codezoo.rest.jackson.TreeNodeHolder;
import dk.codezoo.rest.jackson.TreeNodePropertyReferenceConverter;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class JacksonTreeNodeMapperTest {

    private JacksonTreeNodeMapper mapper = new JacksonTreeNodeMapper();
    private TreeNodePropertyReferenceConverter converter = new TreeNodePropertyReferenceConverter();

    @Test
    public void testTreeNodeResolvesField() throws IOException {
        DummyEntity de = mapper.readValue("{\"text\": \"qwerty\"}", DummyEntity.class);
        Iterable<String> fields = converter.translate(TreeNodeHolder.get());
        assertEquals(Collections.singletonList("text"), fields);
    }

    @Test
    public void testTreeNodeResolvesChildField() throws IOException {
        DummyEntity de = mapper.readValue("{\"child\": {\"text\":\"qwerty\"}}", DummyEntity.class);
        Iterable<String> fields = converter.translate(TreeNodeHolder.get());
        assertEquals(Collections.singletonList("child.text"), fields);
    }
}
