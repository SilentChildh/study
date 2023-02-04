import com.view.Client;
import com.view.Transformation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ViewTest {
    @Nested
    class ClientTest {
        @Test
        void clientTest() {
            new Client().show();
        }
    }

    @Nested
    class TransformationTest {
        Transformation transformation = new Transformation();

        @Test
        void getUserVOTest() {
            Object obj = transformation.getUserVO();
            Assertions.assertNotNull(obj);
            System.out.println(obj);
        }


        @Test
        void getUserLoginBOInfo() {
            Object obj = transformation.getUserLoginBOInfo();
            Assertions.assertNotNull(obj);
            System.out.println(obj);
        }

        @Test
        void getUserRegisterBOInfoTest() {
            Object obj = transformation.getUserRegisterBOInfo();
            Assertions.assertNotNull(obj);
            System.out.println(obj);
        }


    }


}
