package felipero.tries;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactsTest {
  @Test
  void testContacts() {
    StringBuffer input = new StringBuffer("5\n");
    input.append("add felipe\n");
    input.append("add falcao\n");
    input.append("add felipero\n");
    input.append("find fel\n");
    input.append("find fero");

    assertEquals("2\n0", Contacts.execute(input.toString()));
  }

  @Test
  void testContacts_with_lots_of_s() {
    StringBuffer input = new StringBuffer("11\n");
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
}