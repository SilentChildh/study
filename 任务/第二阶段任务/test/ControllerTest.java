import com.controller.user.UserHandler;
import com.controller.util.ResponseResult;
import com.pojo.bo.user.UserLoginBO;
import com.pojo.bo.user.UserRegisterBO;
import com.pojo.dto.user.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ControllerTest {
    @Nested
    class UserHandlerTest {
        UserHandler userHandler = new UserHandler();

        @Test
        void loginTest() {
            UserLoginBO bo = new UserLoginBO();
            bo.setName("name");
            bo.setPassword("123456");

            ResponseResult<Void> responseResult = userHandler.login(bo);

            Assertions.assertNotNull(responseResult);
            System.out.println(responseResult);

        }


        @Test
        void registerTest() {
            UserRegisterBO bo = new UserRegisterBO();
            bo.setName("name");
            bo.setPassword("123456");

            ResponseResult<Void> responseResult = userHandler.register(bo);

            Assertions.assertNotNull(responseResult);
            System.out.println(responseResult);
        }

        @Test
        void queryTest() {
            Long id = 1L;

            ResponseResult<UserDTO> responseResult = userHandler.query(id);

            Assertions.assertNotNull(responseResult);
            System.out.println(responseResult);
        }
    }

}
