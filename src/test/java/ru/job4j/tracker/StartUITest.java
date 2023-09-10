package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateItem(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findByAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced Item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditItem(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItem(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu" + System.lineSeparator()
                                + "0. Exit" + System.lineSeparator()
                                + "=== Exit Program ===" + System.lineSeparator()
        );
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditItem(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu" + ln
                               + "0. Edit Item" + ln
                               + "1. Exit" + ln
                               + "=== Edit item ===" + ln
                               + "Заявка изменена успешно." + ln
                               + "Menu" + ln
                               + "0. Edit Item" + ln
                               + "1. Exit" + ln
                               + "=== Exit Program ===" + ln
        );
    }

    @Test
    void whenFindAllItemsTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowItems(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu" + ln
                               + "0. Show All Items" + ln
                               + "1. Exit" + ln
                               + "=== Show all items ===" + ln
                               + one + ln
                               + "Menu" + ln
                               + "0. Show All Items" + ln
                               + "1. Exit" + ln
                               + "=== Exit Program ===" + ln
        );
    }

    @Test
    void whenFindByNameTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", "test1", "1"}
        );
        UserAction[] actions = {
                new FindItemsByName(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu" + ln
                               + "0. Find Items dy name" + ln
                               + "1. Exit" + ln
                               + "=== Find items by name ===" + ln
                               + one + ln
                               + "Menu" + ln
                               + "0. Find Items dy name" + ln
                               + "1. Exit" + ln
                               + "=== Exit Program ===" + ln
        );
    }

    @Test
    void whenFindByIdTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = {
                new FindItemById(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu" + ln
                               + "0. Find Item by id" + ln
                               + "1. Exit" + ln
                               + "=== Find item by id ===" + ln
                               + one + ln
                               + "Menu" + ln
                               + "0. Find Item by id" + ln
                               + "1. Exit" + ln
                               + "=== Exit Program ===" + ln
        );
    }
}