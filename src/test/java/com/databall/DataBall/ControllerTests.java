package com.databall.DataBall;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.List;

@SpringBootTest
public class ControllerTests {

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    public void checkNombreEquipos() {
        ResponseEntity<List> response = testRestTemplate.getForEntity("http://localhost:8080/getEquipoSearch/NOMBRE/Real", List.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(12, response.getBody().size());
    }

    @Test
    public void checkEstadioEquipos() {
        ResponseEntity<List> response = testRestTemplate.getForEntity("http://localhost:8080/getEquipoSearch/ESTADIO/Real", List.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(12, response.getBody().size());
    }

    @Test
    public void checkNombreJugadores() {
        ResponseEntity<List> response = testRestTemplate.getForEntity("http://localhost:8080/getJugadorSearch/NOMBRE/Ser", List.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(12, response.getBody().size());

    }

    @Test
    public void checkTarjetasAmarillasJugadores() {
        ResponseEntity<List> response = testRestTemplate.getForEntity("http://localhost:8080/getJugadorSearch/AMARILLAS/1", List.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(117, response.getBody().size());

    }

}
