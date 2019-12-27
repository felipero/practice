package felipero.tries;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

class ContactsTest {
  @Test
  void testContacts() {
    StringBuilder input = new StringBuilder("5\n");
    input.append("add felipe\n");
    input.append("add falcao\n");
    input.append("add felipero\n");
    input.append("find fel\n");
    input.append("find fero");

    assertEquals("2\n0", Contacts.execute(input.toString()));
  }

  @Test
  void testContacts_with_lots_of_s() {
    StringBuilder input = new StringBuilder("11\n");
    input.append("add s\n");
    input.append("add ss\n");
    input.append("add sss\n");
    input.append("add ssss\n");
    input.append("add sssss\n");
    input.append("find s\n");
    input.append("find ss\n");
    input.append("find sss\n");
    input.append("find ssss\n");
    input.append("find sssss\n");
    input.append("find ssssss");

    assertEquals("5\n4\n3\n2\n1\n0", Contacts.execute(input.toString()));
  }

  @Test
  @Timeout(value = 870, unit = TimeUnit.MILLISECONDS)
  void testContacts_from_input_file() throws IOException {
    String input = readFile("src/test/resources/contacts_input02.txt");
    String output = readFile("src/test/resources/contacts_output02.txt");

    assertEquals(output, Contacts.execute(input) + "\n");
  }

  private String readFile(String path) throws IOException {
    StringBuilder content = new StringBuilder();

    try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
      stream.forEach(s -> content.append(s).append("\n"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return content.toString();
  }
}