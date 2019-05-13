open module com.soebes.kata {
	requires java.base;

	exports com.soebes.katas.factors;
	exports com.soebes.katas.filmausleihe;
	exports com.soebes.katas.muenzspeicher;
	exports com.soebes.katas.nodes;
	exports com.soebes.katas.wordwrap;



	requires org.junit.jupiter.api;
	requires org.assertj.core;
	requires org.mockito;
}
