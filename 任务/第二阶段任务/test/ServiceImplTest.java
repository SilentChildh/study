import com.pojo.dto.user.UserDTO;
import com.service.UserService;
import com.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServiceImplTest {
    @Test
    void queryByIdTest() {
        UserService userService = new UserServiceImpl();
        UserDTO userDTO = userService.queryById(1L);
        //未找到id

        //System.out.println(userService.queryById(2L));

        //找到id
        Assertions.assertNotNull(userDTO);
        System.out.println(userDTO);
    }
}
