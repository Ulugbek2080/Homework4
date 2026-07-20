import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTests {

    Player Oleg = new Player(0, "Oleg", 13);
    Player Rustam = new Player(1, "Rustam", 13);
    Player Huligan = new Player(2, "Huligan", -8);
    Player HUHUHU = new Player(3, "HUHUHU", 40);

    @Test
    void regisration() {
        Game manager = new Game();
        manager.register(Oleg);
        assertEquals(Oleg, manager.findByName("Oleg"));
        NotRegisteredException exception = assertThrows(
                NotRegisteredException.class,
                () -> manager.findByName("Rustam")
        );
        assertEquals("Element with name: Rustam not found", exception.getMessage());
    }
//0 если ничья, 1 если первый и 2 если второй выйграл
    @Test
    void roundTests() {
        Game manager = new Game();
        manager.register(Oleg);
        manager.register(Rustam);
        manager.register(Huligan);
        manager.register(HUHUHU);

        assertEquals(0, manager.round(Oleg.getName(), Rustam.getName()));
        assertEquals(1, manager.round(Oleg.getName(), Huligan.getName()));
        assertEquals(2, manager.round(Rustam.getName(), HUHUHU.getName()));
        assertEquals(1, manager.round(HUHUHU.getName(), Oleg.getName()));
    }
}
