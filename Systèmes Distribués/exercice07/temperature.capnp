@0xae47d9b20d9e659d;

interface Town {
	currentTemperature @0 () -> (temperature :CelsiusTemp);
	updateTemperature @2 (temperature :CelsiusTemp) -> ();
	name @1 () -> (name :Text);
	location @3 () -> (location :Coordinates);
	struct Coordinates {
  	latitude @0 :Float32;
  	longitude @1 :Float32;
	}
}

interface WeatherMap {
	findTown @0 (name :Text) -> (town :Town); # Investigate: Error handling?
	listTowns @1 () -> (towns :List(Town));
	toFahrenheit @2 (temperature :CelsiusTemp) -> (temperature :FahrenheitTemp);
	toCelsius @3 (temperature :FahrenheitTemp) -> (temperature :CelsiusTemp);
}

struct CelsiusTemp {
  value @0 :Float32;
}

struct FahrenheitTemp {
  value @0 :Float32;
}