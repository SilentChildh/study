import com.service.UserService;
import com.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServiceImplTest {
    @Test
    void queryByIdTest() {
        UserService userService = new UserServiceImpl();
        Assertions.assertNull(userService.queryById(12L));
    }
}
