package service.locator;

import java.util.stream.Stream;

import model.Pais;

public interface PaisesLocator {

	Stream<Pais> getJsonStream();

}