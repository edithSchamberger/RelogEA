package ar.edu.undef.fie.relog_rest_Api;


import ar.edu.undef.fie.domain.organizacion.Organizacion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RelogApplicationTests {

	@Test
	void nuevaUnidad() {
		var organizacion =new Organizacion("CMN", 200.0,10.6,10.5);

	}

}
